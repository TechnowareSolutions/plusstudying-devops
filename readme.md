# +Studying — API
> +Stuying é um aplicativo feito para auxiliar os estudantes a estudarem de forma mais eficiente e personalizado, utilizando da tecnologia GPT-3 da OpenAI para gerar conteúdo de acordo com o que o usuário deseja estudar.
> 
> +Studying é um projeto desenvolvido para o Challenge promovido pela [Plusoft](https://plusoft.com.br/) para as turmas 2TDS da [FIAP](https://fiap.com.br/). 
>
> Esta API foi desenvolvida utilizando o framework [Spring Boot](https://spring.io/projects/spring-boot) e o banco de dados [Oracle](https://www.oracle.com/br/database/technologies/).
> 
> Este projeto foi idealizado e desenvolvido por:

|Turma|Nome|RM|
|-|-|-|
|2TDSPG|[Caio Gallo Barreira]()|94526| 
|2TDSPG|[Guilherme Menezes da Silva]()|89384| 
|2TDSPG|[Guilherme Oliveira Rocha]()|94771| 
|2TDSPG|[João Victor de Souza Silva]()|92119| 

---

## :thinking: Sobre o projeto
Olá, somos a Technoware Solutions e nosso foco é em solucionar um problema que muitos estudantes possuem quando o assunto é organização dedicada aos estudos como a dificuldade de encontrar um tempo adequado. Quando isso ocorre, o estudante pode ficar variando de horários e assim nunca saberá qual é que se encaixa perfeitamente em sua rotina, difícil acesso aos exercícios para aquilo que está estudando em específico, além da dificuldade de esclarecer uma dúvida durante o estudo que mesmo após ler na Internet ou livros não consegue entender o conteúdo.

A plataforma que iremos desenvolver focará em solucionar esses problemas de maneira simples e prática, que com apenas alguns cliques o usuário conseguirá definir qual disciplina deseja estudar, informar o horário de sua rotina e também o seu nível referente à disciplina. Dadas as informações, nossa plataforma, que terá a implementação do ChatGPT, irá projetar uma lista de disciplinas que será acompanhada com uma porcentagem que irá aumentando cada vez que o estudante for progredindo, dentro dessas disciplinas terá o melhor horário para estudar, terá os conteúdos que devem ser estudados de acordo com o nível informado anteriormente e exercícios precisamente desenvolvidos para a aula em questão. Para que o aluno não se perca em qual disciplina está ou até mesmo quais exercícios realizou, ele poderá marcar como concluído seja a disciplina ou tarefa como um to-do list e isso será usado para aumentar seu progresso no programa.

Como falado anteriormente o foco da plataforma é ajudar estudantes seja do ensino fundamental até o mais avançado nível, com isso o público do qual queremos atrair são justamente os alunos, pois acreditamos que possivelmente iremos conseguir aumentar a taxa de aprendizado e até mesmo fazer o estudante se tornar uma pessoa organizada e focada.

Após uma análise do nosso programa buscamos no mercado produtos concorrentes e foi identificado que existem alguns que possuem funções parcialmente parecidas ou até mesmo diferentes com o que estamos desenvolvendo, porém estão subdivido entre outros programas, ou seja, deve instalar cada um para que se obtenha o resultado desejado. Com isso conseguiremos obter um melhor desenvolvimento para que o a plataforma contenha tudo em um único só lugar, sem que haja a necessidade de usar programa por programa.

---

## :rocket: Iniciando o projeto
Para iniciar o projeto, é necessário ter instalado em sua máquina o **Java 17** e o **Maven**.
Após a instalação, basta executar o comando abaixo para iniciar o projeto:

```bash
./mvnw spring-boot:run
```


---
- [+Studying — API](#studying--api)
  - [:thinking: Sobre o projeto](#thinking-sobre-o-projeto)
  - [Endpoints da API](#endpoints-da-api)
    - [Usuario](#usuario)
      - [``[GET]`` /api/v1/usuario](#get-apiv1usuario)
      - [``[GET]`` /api/v1/usuario/{id}](#get-apiv1usuarioid)
      - [``[POST]`` /api/v1/usuario](#post-apiv1usuario)
      - [``[PUT]`` /api/v1/usuario/{id}](#put-apiv1usuarioid)
      - [``[DELETE]`` /api/v1/usuario/{id}](#delete-apiv1usuarioid)
    - [Plano](#plano)
      - [``[GET]`` /api/v1/plano](#get-apiv1plano)
      - [``[GET]`` /api/v1/plano/{id}](#get-apiv1planoid)
      - [``[POST]`` /api/v1/plano](#post-apiv1plano)
      - [``[PUT]`` /api/v1/plano/{id}](#put-apiv1planoid)
      - [``[DELETE]`` /api/v1/plano/{id}](#delete-apiv1planoid)
    - [FormaPagamento](#formapagamento)
      - [``[GET]`` /api/v1/formaPagamento](#get-apiv1formapagamento)
      - [``[GET]`` /api/v1/formaPagamento/{id}](#get-apiv1formapagamentoid)
      - [``[GET]`` /api/v1/formaPagamento/pagamento/{id}](#get-apiv1formapagamentopagamentoid)
      - [``[POST]`` /api/v1/formaPagamento](#post-apiv1formapagamento)
      - [``[PUT]`` /api/v1/formaPagamento/{id}](#put-apiv1formapagamentoid)
      - [``[DELETE]`` /api/v1/formaPagamento/{id}](#delete-apiv1formapagamentoid)
    - [Pagamento](#pagamento)
      - [``[GET]`` /api/v1/pagamento](#get-apiv1pagamento)
      - [``[GET]`` /api/v1/pagamento/{id}](#get-apiv1pagamentoid)
      - [``[POST]`` /api/v1/pagamento](#post-apiv1pagamento)
      - [``[PUT]`` /api/v1/pagamento/{id}](#put-apiv1pagamentoid)
      - [``[DELETE]`` /api/v1/pagamento/{id}](#delete-apiv1pagamentoid)
    - [Cronograma](#cronograma)
      - [``[GET]`` /api/v1/cronograma](#get-apiv1cronograma)
      - [``[GET]`` /api/v1/cronograma/{id}](#get-apiv1cronogramaid)
      - [``[GET]`` /api/v1/cronograma/usuario/{id}](#get-apiv1cronogramausuarioid)
      - [``[POST]`` /api/v1/cronograma](#post-apiv1cronograma)
      - [``[PUT]`` /api/v1/cronograma/{id}](#put-apiv1cronogramaid)
      - [``[DELETE]`` /api/v1/cronograma/{id}](#delete-apiv1cronogramaid)
    - [GptPrompt](#gptprompt)
      - [``[GET]`` /api/v1/gptprompt](#get-apiv1gptprompt)
      - [``[GET]`` /api/v1/gptprompt/{id}](#get-apiv1gptpromptid)
      - [``[GET]`` /api/v1/gptprompt/cronograma/{id}](#get-apiv1gptpromptcronogramaid)
      - [``[POST]`` /api/v1/gptprompt](#post-apiv1gptprompt)
      - [`[DELETE]` /api/v1/gptprompt/{id}](#delete-apiv1gptpromptid)
    - [Materia](#materia)
      - [``[GET]`` /api/v1/materia](#get-apiv1materia)
      - [``[GET]`` /api/v1/materia/{id}](#get-apiv1materiaid)
      - [``[GET]`` /api/v1/materia/cronograma/{id}](#get-apiv1materiacronogramaid)
      - [``[POST]`` /api/v1/materia](#post-apiv1materia)
      - [``[PUT]`` /api/v1/materia/{id}](#put-apiv1materiaid)
      - [``[DELETE]`` /api/v1/materia/{id}](#delete-apiv1materiaid)
    - [Aula](#aula)
      - [``[GET]`` /api/v1/aula](#get-apiv1aula)
      - [``[GET]`` /api/v1/aula/{id}](#get-apiv1aulaid)
      - [``[GET]`` /api/v1/aula/materia/{id}](#get-apiv1aulamateriaid)
      - [``[POST]`` /api/v1/aula](#post-apiv1aula)
      - [``[PUT]`` /api/v1/aula/{id}](#put-apiv1aulaid)
      - [``[DELETE]`` /api/v1/aula/{id}](#delete-apiv1aulaid)
    - [Modulo](#modulo)
      - [``[GET]`` /api/v1/modulo](#get-apiv1modulo)
      - [``[GET]`` /api/v1/modulo/{id}](#get-apiv1moduloid)
      - [``[GET]`` /api/v1/modulo/aula/{id}](#get-apiv1moduloaulaid)
      - [``[POST]`` /api/v1/modulo](#post-apiv1modulo)
      - [``[PUT]`` /api/v1/modulo/{id}](#put-apiv1moduloid)
      - [``[DELETE]`` /api/v1/modulo/{id}](#delete-apiv1moduloid)
    - [SubModulo](#submodulo)
      - [``[GET]`` /api/v1/submodulo](#get-apiv1submodulo)
      - [``[GET]`` /api/v1/submodulo/{id}](#get-apiv1submoduloid)
      - [``[GET]`` /api/v1/submodulo/modulo/{id}](#get-apiv1submodulomoduloid)
      - [``[POST]`` /api/v1/submodulo](#post-apiv1submodulo)
      - [``[PUT]`` /api/v1/submodulo/{id}](#put-apiv1submoduloid)
      - [``[DELETE]`` /api/v1/submodulo/{id}](#delete-apiv1submoduloid)
    - [Exercicio](#exercicio)
      - [``[GET]`` /api/v1/exercicio](#get-apiv1exercicio)
      - [``[GET]`` /api/v1/exercicio/{id}](#get-apiv1exercicioid)
      - [``[GET]`` /api/v1/exercicio/submodulo/{id}](#get-apiv1exerciciosubmoduloid)
      - [``[POST]`` /api/v1/exercicio](#post-apiv1exercicio)
      - [``[PUT]`` /api/v1/exercicio/{id}](#put-apiv1exercicioid)
      - [``[DELETE]`` /api/v1/exercicio/{id}](#delete-apiv1exercicioid)
    - [Alternativa](#alternativa)
      - [``[GET]`` /api/v1/alternativa](#get-apiv1alternativa)
      - [``[GET]`` /api/v1/alternativa/{id}](#get-apiv1alternativaid)
      - [``[GET]`` /api/v1/alternativa/exercicio/{id}](#get-apiv1alternativaexercicioid)
      - [``[POST]`` /api/v1/alternativa](#post-apiv1alternativa)
      - [``[PUT]`` /api/v1/alternativa/{id}](#put-apiv1alternativaid)
      - [``[DELETE]`` /api/v1/alternativa/{id}](#delete-apiv1alternativaid)


---
## Endpoints da API 

### Usuario

#### ``[GET]`` /api/v1/usuario
Retorna todos os usuários cadastrados no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "plano": {
            "id": "1"
        },
        "nome": "Caio Gallo Barreira",
        "dataNascimento": "1995-03-22",
        "cpf": "123.456.789-10",
        "email": "caiogallobarreira@gmail.com",
        "senha": "123456",
        "dataCriacaoLogin": "2021-05-01",
        "statusConta": "A",
        "dataUltimoLogin": "2021-05-01"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/usuario/{id}
Retorna um usuário específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "plano": {
        "id": "1"
    },
    "nome": "Caio Gallo Barreira",
    "dataNascimento": "1995-03-22",
    "cpf": "123.456.789-10",
    "email": "caiogallobarreira@gmail.com",
    "senha": "123456",
    "dataCriacaoLogin": "2021-05-01",
    "statusConta": "A",
    "dataUltimoLogin": "2021-05-01"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Usuário não encontrado

---

#### ``[POST]`` /api/v1/usuario
Cadastra um novo usuário no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| plano          | Integer    | Sim         | ID do plano do usuário
| nome        | String | Sim         | Nome do usuário
| dataNascimento     | Calendar   | Sim         | Data de nascimento do usuário
| cpf            | String | Sim         | CPF do usuário
| email          | String | Sim         | E-mail do usuário
| senha          | String | Sim         | Senha do usuário
| dataCriacaoLogin  | Calendar   | Sim         | Data de criação da conta do usuário
| statusConta   | String   | Sim         | Data de status da conta do usuário
| dataUltimoLogin   | Calendar   | Sim         | Data do último login do usuário

**Exemplo do corpo da requisição:**

```json
{
    "plano": {
        "id": "1"
    },
    "nome": "Caio Gallo Barreira",
    "dataNascimento": "1995-03-22",
    "cpf": "123.456.789-10",
    "email": "caiogallobarreira@gmail.com",
    "senha": "123456",
    "dataCriacaoLogin": "2021-05-01",
    "statusConta": "A",
    "dataUltimoLogin": "2021-05-01"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Usuário cadastrado com sucesso
| 400 | Erro ao cadastrar usuário

---

#### ``[PUT]`` /api/v1/usuario/{id}
Atualiza um usuário específico cadastrado no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| plano          | Integer    | Sim         | ID do plano do usuário
| nome        | String | Sim         | Nome do usuário
| dataNascimento     | Calendar   | Sim         | Data de nascimento do usuário
| cpf            | String | Sim         | CPF do usuário
| email          | String | Sim         | E-mail do usuário
| senha          | String | Sim         | Senha do usuário
| dataCriacaoLogin  | Calendar   | Sim         | Data de criação da conta do usuário
| statusConta   | String   | Sim         | Data de status da conta do usuário
| dataUltimoLogin   | Calendar   | Sim         | Data do último login do usuário

**Exemplo do corpo da requisição:**

```json
{
    "plano": {
        "id": "1"
    },
    "nome": "Caio Gallo Barreira",
    "dataNascimento": "1995-03-22",
    "cpf": "123.456.789-10",
    "email": "caiogallobarreira@gmail.com",
    "senha": "123456",
    "dataCriacaoLogin": "2021-05-01",
    "statusConta": "A",
    "dataUltimoLogin": "2021-05-01"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Usuário atualizado com sucesso
| 400 | Erro ao atualizar usuário
| 404 | Usuário não encontrado

---

#### ``[DELETE]`` /api/v1/usuario/{id}
Deleta um usuário específico cadastrado no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Usuário deletado com sucesso
| 404 | Usuário não encontrado

---

### Plano

#### ``[GET]`` /api/v1/plano
Retorna todos os planos cadastrados no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "nome": "Plano 1",
        "valor": 10.00,
        "descricao": "Plano 1"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/plano/{id}
Retorna um plano específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "nome": "Plano 1",
    "valor": 10.00,
    "descricao": "Plano 1"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Plano não encontrado

---

#### ``[POST]`` /api/v1/plano
Cadastra um novo plano no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| nome          | String    | Sim         | Nome do plano
| valor          | Double | Sim         | Valor do plano
| descricao          | String | Sim         | Descrição do plano

**Exemplo do corpo da requisição:**

```json
{
    "nome": "Plano 1",
    "valor": 10.00,
    "descricao": "Plano 1"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Plano cadastrado com sucesso
| 400 | Erro ao cadastrar plano

---

#### ``[PUT]`` /api/v1/plano/{id}
Atualiza um plano específico cadastrado no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| nome          | String    | Sim         | Nome do plano
| valor          | Double | Sim         | Valor do plano
| descricao          | String | Sim         | Descrição do plano

**Exemplo do corpo da requisição:**

```json
{
    "nome": "Plano 1",
    "valor": 10.00,
    "descricao": "Plano 1"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Plano atualizado com sucesso
| 400 | Erro ao atualizar plano
| 404 | Plano não encontrado

---

#### ``[DELETE]`` /api/v1/plano/{id}
Deleta um plano específico cadastrado no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Plano deletado com sucesso
| 404 | Plano não encontrado

---

### FormaPagamento

#### ``[GET]`` /api/v1/formaPagamento
Retorna todas as formas de pagamento cadastradas no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "pagamento": {
            "id": 1
        },
        "plano": {
            "id": 1
        },
        "nomeTitular": "Caio Gallo Barreira",
        "cpf": "123.456.789-10",
        "numeroCartao": 1234567890123456,
        "dataValidade": "03/2023",
        "cvv": 123
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/formaPagamento/{id}
Retorna uma forma de pagamento específica cadastrada no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "pagamento": {
        "id": 1
    },
    "plano": {
        "id": 1
    },
    "nomeTitular": "Caio Gallo Barreira",
    "cpf": "123.456.789-10",
    "numeroCartao": 1234567890123456,
    "dataValidade": "03/2023",
    "cvv": 123
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Forma de pagamento não encontrada

---

#### ``[GET]`` /api/v1/formaPagamento/pagamento/{id}
Retorna todas as formas de pagamento de um pagamento específico cadastradas no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "pagamento": {
            "id": 1
        },
        "plano": {
            "id": 1
        },
        "nomeTitular": "Caio Gallo Barreira",
        "cpf": "123.456.789-10",
        "numeroCartao": 1234567890123456,
        "dataValidade": "03/2023",
        "cvv": 123
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Forma de pagamento não encontrada

---

#### ``[POST]`` /api/v1/formaPagamento
Cadastra uma nova forma de pagamento no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| pagamento      | Integer | Sim         | ID do pagamento
| plano          | Integer | Sim         | ID do plano
| nomeTitular        | String  | Sim         | Nome do titular do cartão
| cpf            | String  | Sim         | CPF do titular do cartão
| numeroCartao         | Long    | Sim         | Número do cartão
| dataValidade       | String  | Sim         | Data de validade do cartão
| cvv            | Integer | Sim         | CVV do cartão

**Exemplo do corpo da requisição:**

```json
{
    "pagamento": {
        "id": 1
    },
    "plano": {
        "id": 1
    },
    "nomeTitular": "Caio Gallo Barreira",
    "cpf": "123.456.789-10",
    "numeroCartao": 1234567890123456,
    "dataValidade": "03/2023",
    "cvv": 123
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Forma de pagamento cadastrada com sucesso
| 400 | Erro ao cadastrar forma de pagamento

---

#### ``[PUT]`` /api/v1/formaPagamento/{id}
Atualiza uma forma de pagamento específica cadastrada no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| pagamento      | Integer | Sim         | ID do pagamento
| plano          | Integer | Sim         | ID do plano
| nomeTitular        | String  | Sim         | Nome do titular do cartão
| cpf            | String  | Sim         | CPF do titular do cartão
| numeroCartao         | Long    | Sim         | Número do cartão
| dataValidade       | String  | Sim         | Data de validade do cartão
| cvv            | Integer | Sim         | CVV do cartão

**Exemplo do corpo da requisição:**

```json
{
    "pagamento": {
        "id": 1
    },
    "plano": {
        "id": 1
    },
    "nomeTitular": "Caio Gallo Barreira",
    "cpf": "123.456.789-10",
    "numeroCartao": 1234567890123456,
    "dataValidade": "03/2023",
    "cvv": 123
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Forma de pagamento atualizada com sucesso
| 400 | Erro ao atualizar forma de pagamento
| 404 | Forma de pagamento não encontrada

---

#### ``[DELETE]`` /api/v1/formaPagamento/{id}
Deleta uma forma de pagamento específica cadastrada no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Forma de pagamento deletada com sucesso
| 404 | Forma de pagamento não encontrada

---

### Pagamento

#### ``[GET]`` /api/v1/pagamento
Retorna todos os pagamentos cadastrados no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "data": "2021-05-01",
        "valorPagamento": 100.00,
        "statusPagamento": "P"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/pagamento/{id}
Retorna um pagamento específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "data": "2021-05-01",
    "valorPagamento": 100.00,
    "statusPagamento": "P"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Pagamento não encontrado

---

#### ``[POST]`` /api/v1/pagamento
Cadastra um novo pagamento no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| data      | Calendar   | Sim         | Data do pagamento
| valorPagamento      | Double | Sim         | Valor do pagamento
| statusPagamento | String | Sim         | Status do pagamento

**Exemplo do corpo da requisição:**

```json
{
    "data": "2021-05-01",
    "valorPagamento": 100.00,
    "statusPagamento": "P"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Pagamento cadastrado com sucesso
| 400 | Erro ao cadastrar pagamento

---

#### ``[PUT]`` /api/v1/pagamento/{id}
Atualiza um pagamento específico cadastrado no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| data      | Calendar   | Sim         | Data do pagamento
| valorPagamento      | Double | Sim         | Valor do pagamento
| statusPagamento | String | Sim         | Status do pagamento

**Exemplo do corpo da requisição:**

```json
{
    "data": "2021-05-01",
    "valorPagamento": 100.00,
    "statusPagamento": "P"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Pagamento atualizado com sucesso
| 400 | Erro ao atualizar pagamento
| 404 | Pagamento não encontrado

---

#### ``[DELETE]`` /api/v1/pagamento/{id}
Deleta um pagamento específico cadastrado no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Pagamento deletado com sucesso
| 404 | Pagamento não encontrado

---

### Cronograma

#### ``[GET]`` /api/v1/cronograma
Retorna todos os cronogramas cadastrados no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "usuario": {
            "id": 1
        },
        "porcentagem": 10,
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/cronograma/{id}
Retorna um cronograma específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "usuario": {
        "id": 1
    },
    "porcentagem": 10,
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Cronograma não encontrado

---

#### ``[GET]`` /api/v1/cronograma/usuario/{id}
Retorna todos os cronogramas de um usuário específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "usuario": {
            "id": 1
        },
        "porcentagem": 10,
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Cronograma não encontrado

---

#### ``[POST]`` /api/v1/cronograma
Cadastra um novo cronograma no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| id        | Integer   | Sim         | ID do usuário
| porcentagem    | Integer | Sim         | Porcentagem do cronograma

**Exemplo do corpo da requisição:**

```json
{
    "usuario": {
        "id": 1
    },
    "porcentagem": 10,
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Cronograma cadastrado com sucesso
| 400 | Erro ao cadastrar cronograma

---

#### ``[PUT]`` /api/v1/cronograma/{id}
Atualiza um cronograma específico cadastrado no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| id        | Integer   | Sim         | ID do usuário
| porcentagem    | Integer | Sim         | Porcentagem do cronograma

**Exemplo do corpo da requisição:**

```json
{
    "usuario": {
        "id": 1
    },
    "porcentagem": 10,
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Cronograma atualizado com sucesso
| 400 | Erro ao atualizar cronograma
| 404 | Cronograma não encontrado

---

#### ``[DELETE]`` /api/v1/cronograma/{id}
Deleta um cronograma específico cadastrado no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Cronograma deletado com sucesso
| 404 | Cronograma não encontrado

---

### GptPrompt

#### ``[GET]`` /api/v1/gptprompt
Retorna todos os prompts gerados pelo GPT cadastrados no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "cronograma": {
            "id": 1
        },
        "datasPrompt": "2021-05-01",
        "descricaoPrompt": "Descrição do prompt",
        "gptChoices": [...],
        "gptCreated": 1677823794,
        "gptId": "chatcmpl-6psu2Yl4ZFP5wb1S2CK9bCu7r2fEz",
        "gptModel": "davinci",
        "gptObject": "chat.completion",
        "gptComplTokens": 100,
        "gptPromptTokens": 100,
        "gptTotalTokens": 200
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/gptprompt/{id}
Retorna um prompt específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "cronograma": {
        "id": 1
    },
    "datasPrompt": "2021-05-01",
    "descricaoPrompt": "Descrição do prompt",
    "gptChoices": [...],
    "gptCreated": 1677823794,
    "gptId": "chatcmpl-6psu2Yl4ZFP5wb1S2CK9bCu7r2fEz",
    "gptModel": "davinci",
    "gptObject": "chat.completion",
    "gptComplTokens": 100,
    "gptPromptTokens": 100,
    "gptTotalTokens": 200
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Prompt não encontrado

---

#### ``[GET]`` /api/v1/gptprompt/cronograma/{id}
Retorna todos os prompts de um cronograma específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "cronograma": {
            "id": 1
        },
        "datasPrompt": "2021-05-01",
        "descricaoPrompt": "Descrição do prompt",
        "gptChoices": [...],
        "gptCreated": 1677823794,
        "gptId": "chatcmpl-6psu2Yl4ZFP5wb1S2CK9bCu7r2fEz",
        "gptModel": "davinci",
        "gptObject": "chat.completion",
        "gptComplTokens": 100,
        "gptPromptTokens": 100,
        "gptTotalTokens": 200
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Prompt não encontrado

---

#### ``[POST]`` /api/v1/gptprompt
Cadastra um novo prompt no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| cronograma     | Integer   | Sim         | ID do cronograma
| dataPrompt         | Calendar | Sim         | Data do prompt
| descricaoPrompt         | String | Sim         | Descrição do prompt
| gptChoices       | Array | Sim         | Array de escolhas do prompt
| gptCreated       | Long | Sim         | Data de criação do prompt
| gptId            | String | Sim         | ID do prompt
| gptModel         | String | Sim         | Modelo do prompt
| gptObject        | String | Sim         | Objeto do prompt
| gptComplTokens  | Integer | Sim         | Número de tokens de completamento do prompt
| gptPromptTokens | Integer | Sim         | Número de tokens do prompt
| gptTotalTokens  | Integer | Sim         | Número total de tokens do prompt

**Exemplo do corpo da requisição:**

```json
{
    "cronograma": {
        "id": 1
    },
    "datasPrompt": "2021-05-01",
    "descricaoPrompt": "Descrição do prompt",
    "gptChoices": [...],
    "gptCreated": 1677823794,
    "gptId": "chatcmpl-6psu2Yl4ZFP5wb1S2CK9bCu7r2fEz",
    "gptModel": "davinci",
    "gptObject": "chat.completion",
    "gptComplTokens": 100,
    "gptPromptTokens": 100,
    "gptTotalTokens": 200
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Prompt cadastrado com sucesso
| 400 | Erro ao cadastrar prompt

---

#### `[DELETE]` /api/v1/gptprompt/{id}
Deleta um prompt específico cadastrado no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Prompt deletado com sucesso
| 404 | Prompt não encontrado

---

### Materia

#### ``[GET]`` /api/v1/materia
Retorna todas as matérias cadastradas no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "cronograma": {
            "id": 1
        },
        "materia": "Matemática",
        "nivel": 1
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/materia/{id}
Retorna uma matéria específica cadastrada no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "cronograma": {
        "id": 1
    },
    "materia": "Matemática",
    "nivel": 1
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Matéria não encontrada

---

#### ``[GET]`` /api/v1/materia/cronograma/{id}
Retorna todas as matérias de um cronograma específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "cronograma": {
            "id": 1
        },
        "materia": "Matemática",
        "nivel": 1
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Matéria não encontrada

---

#### ``[POST]`` /api/v1/materia
Cadastra uma nova matéria no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| cronograma     | Integer   | Sim         | ID do materiarama
| materia      | String | Sim         | Nome da matéria
| nivel          | Integer | Sim         | Nível da matéria

**Exemplo do corpo da requisição:**

```json
{
    "cronograma": {
        "id": 1
    },
    "materia": "Matemática",
    "nivel": 1
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Matéria cadastrada com sucesso
| 400 | Erro ao cadastrar matéria

---

#### ``[PUT]`` /api/v1/materia/{id}
Atualiza uma matéria específica cadastrada no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| cronograma     | Integer   | Sim         | ID do materiarama
| materia      | String | Sim         | Nome da matéria
| nivel          | Integer | Sim         | Nível da matéria

**Exemplo do corpo da requisição:**

```json
{
    "cronograma": {
        "id": 1
    },
    "materia": "Matemática",
    "nivel": 1
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Matéria atualizada com sucesso
| 400 | Erro ao atualizar matéria
| 404 | Matéria não encontrada

---

#### ``[DELETE]`` /api/v1/materia/{id}
Deleta uma matéria específica cadastrada no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Matéria deletada com sucesso
| 404 | Matéria não encontrada

---

### Aula

#### ``[GET]`` /api/v1/aula
Retorna todas as aulas cadastradas no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "materia": {
            "id": 1
        },
        "titulo": "Aula 1",
        "descricaoAula": "Descrição da aula"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/aula/{id}
Retorna uma aula específica cadastrada no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "materia": {
        "id": 1
    },
    "titulo": "Aula 1",
    "descricaoAula": "Descrição da aula"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Aula não encontrada

---

#### ``[GET]`` /api/v1/aula/materia/{id}

Retorna todas as aulas de uma matéria específica cadastrada no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "materia": {
            "id": 1
        },
        "titulo": "Aula 1",
        "descricaoAula": "Descrição da aula"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Aula não encontrada

---

#### ``[POST]`` /api/v1/aula
Cadastra uma nova aula no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| materia        | Integer   | Sim         | ID da materia
titulo          | String | Sim         | Título da aula
descricaoAula          | String | Sim         | Descrição da aula

**Exemplo do corpo da requisição:**

```json
{
    "materia": {
        "id": 1
    },
    "titulo": "Aula 1",
    "descricaoAula": "Descrição da aula"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Aula cadastrada com sucesso
| 400 | Erro ao cadastrar aula

---

#### ``[PUT]`` /api/v1/aula/{id}
Atualiza uma aula específica cadastrada no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| materia        | Integer   | Sim         | ID da materia
titulo          | String | Sim         | Título da aula
descricaoAula          | String | Sim         | Descrição da aula

**Exemplo do corpo da requisição:**

```json
{
    "materia": {
        "id": 1
    },
    "titulo": "Aula 1",
    "descricaoAula": "Descrição da aula"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Aula atualizada com sucesso
| 400 | Erro ao atualizar aula
| 404 | Aula não encontrada

---

#### ``[DELETE]`` /api/v1/aula/{id}
Deleta uma aula específica cadastrada no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Aula deletada com sucesso
| 404 | Aula não encontrada

---

### Modulo

#### ``[GET]`` /api/v1/modulo
Retorna todos os módulos cadastrados no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "aula": {
            "id": 1
        },
        "modulo": "Módulo 1"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/modulo/{id}
Retorna um módulo específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "aula": {
        "id": 1
    },
    "modulo": "Módulo 1"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Módulo não encontrado

---

#### ``[GET]`` /api/v1/modulo/aula/{id}
Retorna todos os módulos de uma aula específica cadastrada no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "aula": {
            "id": 1
        },
        "modulo": "Módulo 1"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Módulo não encontrado

---

#### ``[POST]`` /api/v1/modulo
Cadastra um novo módulo no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| aula           | Integer   | Sim         | ID da aula
| modulo         | String | Sim         | Título do módulo

**Exemplo do corpo da requisição:**

```json
{
    "aula": {
        "id": 1
    },
    "modulo": "Módulo 1"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Módulo cadastrado com sucesso
| 400 | Erro ao cadastrar módulo

---

#### ``[PUT]`` /api/v1/modulo/{id}
Atualiza um módulo específico cadastrado no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| aula           | Integer   | Sim         | ID da aula
| modulo         | String | Sim         | Título do módulo

**Exemplo do corpo da requisição:**

```json
{
    "aula": {
        "id": 1
    },
    "modulo": "Módulo 1"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Módulo atualizado com sucesso
| 400 | Erro ao atualizar módulo
| 404 | Módulo não encontrado

---

#### ``[DELETE]`` /api/v1/modulo/{id}
Deleta um módulo específico cadastrado no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Módulo deletado com sucesso
| 404 | Módulo não encontrado

---

### SubModulo

#### ``[GET]`` /api/v1/submodulo
Retorna todos os submódulos cadastrados no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "modulo": {
            "id": 1
        },
        "titulo": "Submódulo 1",
        "conteudo": "Conteúdo do submódulo"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/submodulo/{id}
Retorna um submódulo específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "modulo": {
        "id": 1
    },
    "titulo": "Submódulo 1",
    "conteudo": "Conteúdo do submódulo"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Submódulo não encontrado

---

#### ``[GET]`` /api/v1/submodulo/modulo/{id}
Retorna todos os submódulos de um módulo específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "modulo": {
            "id": 1
        },
        "titulo": "Submódulo 1",
        "conteudo": "Conteúdo do submódulo"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Submódulo não encontrado

---

#### ``[POST]`` /api/v1/submodulo
Cadastra um novo submódulo no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| modulo         | Integer   | Sim         | ID do módulo
| titulo         | String | Sim         | Título do submódulo
| conteudo       | String | Sim         | Conteúdo do submódulo

**Exemplo do corpo da requisição:**

```json
{
    "modulo": {
        "id": 1
    },
    "titulo": "Submódulo 1",
    "conteudo": "Conteúdo do submódulo"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Submódulo cadastrado com sucesso
| 400 | Erro ao cadastrar submódulo

---

#### ``[PUT]`` /api/v1/submodulo/{id}
Atualiza um submódulo específico cadastrado no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| modulo         | Integer   | Sim         | ID do módulo
| titulo         | String | Sim         | Título do submódulo
| conteudo       | String | Sim         | Conteúdo do submódulo

**Exemplo do corpo da requisição:**

```json
{
    "modulo": {
        "id": 1
    },
    "titulo": "Submódulo 1",
    "conteudo": "Conteúdo do submódulo"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Submódulo atualizado com sucesso
| 400 | Erro ao atualizar submódulo
| 404 | Submódulo não encontrado

---

#### ``[DELETE]`` /api/v1/submodulo/{id}
Deleta um submódulo específico cadastrado no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Submódulo deletado com sucesso
| 404 | Submódulo não encontrado

---

### Exercicio

#### ``[GET]`` /api/v1/exercicio
Retorna todos os exercícios cadastrados no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "subModulo": {
            "id": 1
        },
        "titulo": "Enunciado do exercício",
        "pergunta": "Pergunta do exercício"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/exercicio/{id}
Retorna um exercício específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "subModulo": {
        "id": 1
    },
    "titulo": "Enunciado do exercício",
    "pergunta": "Pergunta do exercício"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Exercício não encontrado

---

#### ``[GET]`` /api/v1/exercicio/submodulo/{id}
Retorna todos os exercícios de um submódulo específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "subModulo": {
            "id": 1
        },
        "titulo": "Enunciado do exercício",
        "pergunta": "Pergunta do exercício"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Exercício não encontrado

---

#### ``[POST]`` /api/v1/exercicio
Cadastra um novo exercício no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| subModulo      | Integer   | Sim         | ID do submódulo
| titulo         | String | Sim         | Título do exercício
| pergunta       | String | Sim         | Pergunta do exercício

**Exemplo do corpo da requisição:**

```json
{
    "subModulo": {
        "id": 1
    },
    "titulo": "Enunciado do exercício",
    "pergunta": "Pergunta do exercício"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Exercício cadastrado com sucesso
| 400 | Erro ao cadastrar exercício

---

#### ``[PUT]`` /api/v1/exercicio/{id}
Atualiza um exercício específico cadastrado no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| subModulo      | Integer   | Sim         | ID do submódulo
| titulo         | String | Sim         | Título do exercício
| pergunta       | String | Sim         | Pergunta do exercício

**Exemplo do corpo da requisição:**

```json
{
    "subModulo": {
        "id": 1
    },
    "titulo": "Enunciado do exercício",
    "pergunta": "Pergunta do exercício"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Exercício atualizado com sucesso
| 400 | Erro ao atualizar exercício
| 404 | Exercício não encontrado

---

#### ``[DELETE]`` /api/v1/exercicio/{id}
Deleta um exercício específico cadastrado no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Exercício deletado com sucesso
| 404 | Exercício não encontrado

---

### Alternativa

#### ``[GET]`` /api/v1/alternativa
Retorna todas as alternativas cadastradas no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "exercicio": {
            "id": 1
        },
        "alternativa": "Alternativa 1",
        "resposta": "S"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

#### ``[GET]`` /api/v1/alternativa/{id}
Retorna uma alternativa específica cadastrada no sistema.

**Exemplo do corpo da resposta:**

```json
{
    "id": 1,
    "exercicio": {
        "id": 1
    },
    "alternativa": "Alternativa 1",
    "resposta": "S"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Alternativa não encontrada

---

#### ``[GET]`` /api/v1/alternativa/exercicio/{id}
Retorna todas as alternativas de um exercício específico cadastrado no sistema.

**Exemplo do corpo da resposta:**

```json
[
    {
        "id": 1,
        "exercicio": {
            "id": 1
        },
        "alternativa": "Alternativa 1",
        "resposta": "S"
    }
]
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Alternativa não encontrada

---

#### ``[POST]`` /api/v1/alternativa
Cadastra uma nova alternativa no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| exercicio      | Integer   | Sim         | ID do exercício
| alternativa    | String | Sim         | Alternativa
| resposta       | String | Sim         | Resposta (S/N)

**Exemplo do corpo da requisição:**

```json
{
    "exercicio": {
        "id": 1
    },
    "alternativa": "Alternativa 1",
    "resposta": "S"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 201 | Alternativa cadastrada com sucesso
| 400 | Erro ao cadastrar alternativa

---

#### ``[PUT]`` /api/v1/alternativa/{id}
Atualiza uma alternativa específica cadastrada no sistema.

**Campos da requisição:**
| Campo             | Tipo   | Obrigatório?| Descrição
|-------------------|--------|:-----------:|-|
| exercicio      | Integer   | Sim         | ID do exercício
| alternativa    | String | Sim         | Alternativa
| resposta       | String | Sim         | Resposta (S/N)

**Exemplo do corpo da requisição:**

```json
{
    "exercicio": {
        "id": 1
    },
    "alternativa": "Alternativa 1",
    "resposta": "S"
}
```

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 200 | Alternativa atualizada com sucesso
| 400 | Erro ao atualizar alternativa
| 404 | Alternativa não encontrada

---

#### ``[DELETE]`` /api/v1/alternativa/{id}
Deleta uma alternativa específica cadastrada no sistema.

**Códigos HTTP da resposta:**
| Código | Descrição
|-|-|
| 204 | Alternativa deletada com sucesso
| 404 | Alternativa não encontrada