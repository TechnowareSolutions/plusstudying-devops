package br.com.fiap.technoware.plusstudying.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.technoware.plusstudying.exception.RestNotFoundException;
import br.com.fiap.technoware.plusstudying.model.Usuario;
import br.com.fiap.technoware.plusstudying.repository.UsuarioRepository;
import br.com.fiap.technoware.plusstudying.repository.PlanoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var usuarios = (search == null) ? usuarioRepository.findAll(pageable) : usuarioRepository.findByNomeContaining(search, pageable);
        return assembler.toModel(usuarios.map(Usuario::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        var usuarioOptional = getUsuario(id);
        log.info("Listando usuario: " + id);
        return ResponseEntity.ok(usuarioOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Usuario>> create(@RequestBody @Valid Usuario usuario, BindingResult result){
        log.info("Usuario criado com sucesso! " + usuario);
        usuarioRepository.save(usuario);
        usuario.setPlano(planoRepository.findById(usuario.getPlano().getId()).get());
        return ResponseEntity.created(usuario.toEntityModel().getRequiredLink("self").toUri()).body(usuario.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        var usuarioOptional = getUsuario(id);
        log.info("Usuario deletado com sucesso! " + id);
        usuarioRepository.delete(usuarioOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario, BindingResult result){
        getUsuario(id);
        log.info("Usuario atualizado com sucesso! " + usuario);
        usuario.setId(id);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    private Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrado!"));
    }
}
