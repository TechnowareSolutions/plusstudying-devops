-- RM94526 - CAIO GALLO BARREIRA
-- RM89384 - GUILHERME MENEZES DA SILVA
-- RM94771 - GUILHERME OLIVEIRA ROCHA
-- RM92119 - JOAO VICTOR DE SOUZA SILVA



DROP TABLE t_std_alternativa CASCADE CONSTRAINTS;
DROP TABLE t_std_aula CASCADE CONSTRAINTS;
DROP TABLE t_std_cronograma CASCADE CONSTRAINTS;
DROP TABLE t_std_exercicio CASCADE CONSTRAINTS;
DROP TABLE t_std_forma_pagamento CASCADE CONSTRAINTS;
DROP TABLE t_std_gptprompt CASCADE CONSTRAINTS;
DROP TABLE t_std_materia CASCADE CONSTRAINTS;
DROP TABLE t_std_modulo CASCADE CONSTRAINTS;
DROP TABLE t_std_pagamento CASCADE CONSTRAINTS;
DROP TABLE t_std_plano CASCADE CONSTRAINTS;
DROP TABLE t_std_submodulo CASCADE CONSTRAINTS;
DROP TABLE t_std_usuario CASCADE CONSTRAINTS;
DROP TABLE t_std_logs CASCADE CONSTRAINTS;
DROP TABLE t_std_controle_plano CASCADE CONSTRAINTS;
DROP TABLE t_std_audit_log_forma_pagamento CASCADE CONSTRAINTS;
DROP TABLE t_std_audit_log_usuario CASCADE CONSTRAINTS;


CREATE TABLE t_std_logs ( cod_erro NUMBER(5) NOT NULL, nm_erro VARCHAR2(255) NOT NULL, dt_ocorrencia DATE NOT NULL, nm_usuario VARCHAR2(100) NOT NULL );

CREATE TABLE t_std_alternativa ( id_alternativa NUMBER(5) NOT NULL, id_exercicio NUMBER(5) NOT NULL, ds_alternativa VARCHAR2(100) NOT NULL, ds_resposta CHAR(1) NOT NULL );

ALTER TABLE t_std_alternativa ADD CONSTRAINT t_std_alternativa_pk PRIMARY KEY (id_alternativa);

CREATE TABLE t_std_aula ( id_aula NUMBER(5) NOT NULL, id_materia NUMBER(5) NOT NULL, ds_titulo VARCHAR2(30) NOT NULL, ds_descricao_aula VARCHAR2(50) NOT NULL );

ALTER TABLE t_std_aula ADD CONSTRAINT t_std_aula_pk PRIMARY KEY (id_aula);

CREATE TABLE t_std_cronograma ( id_cronograma NUMBER(5) NOT NULL, id_usuario NUMBER(10) NOT NULL, nr_porcentagem NUMBER(3) NOT NULL );

ALTER TABLE t_std_cronograma ADD CONSTRAINT t_std_cronograma_pk PRIMARY KEY (id_cronograma);

CREATE TABLE t_std_exercicio ( id_exercicio NUMBER(5) NOT NULL, id_submodulo NUMBER(5) NOT NULL, ds_titulo VARCHAR2(50) NOT NULL, ds_pergunta VARCHAR2(50) NOT NULL );

ALTER TABLE t_std_exercicio ADD CONSTRAINT t_std_exercicio_pk PRIMARY KEY (id_exercicio);

CREATE TABLE t_std_forma_pagamento ( id_forma_pagamento NUMBER(5) NOT NULL, id_plano NUMBER(2) NOT NULL, id_pagamento NUMBER(5) NOT NULL, nm_titular VARCHAR2(50) NOT NULL, nr_cpf VARCHAR2(11) NOT NULL, nr_cartao NUMBER(16), dt_validade DATE, nr_cvv NUMBER(3) );

ALTER TABLE t_std_forma_pagamento ADD CONSTRAINT t_std_forma_pagamento_pk PRIMARY KEY (id_forma_pagamento);

CREATE TABLE t_std_gptprompt ( id_prompt NUMBER(5) NOT NULL, id_cronograma NUMBER(5) NOT NULL, dt_prompt DATE NOT NULL, ds_prompt VARCHAR2(30) NOT NULL, gpt_choices BLOB NOT NULL, gpt_created NUMBER(38) NOT NULL, gpt_id VARCHAR2(100) NOT NULL, gpt_model VARCHAR2(100) NOT NULL, gpt_object VARCHAR2(100) NOT NULL, gpt_compl_tokens NUMBER(38) NOT NULL, gpt_prompt_tokens NUMBER(38) NOT NULL, gpt_total_tokens NUMBER(38) NOT NULL );

ALTER TABLE t_std_gptprompt ADD CONSTRAINT t_std_gptprompt_pk PRIMARY KEY (id_prompt);

CREATE TABLE t_std_materia ( id_materia NUMBER(5) NOT NULL, id_cronograma NUMBER(5) NOT NULL, nm_materia VARCHAR2(50) NOT NULL, nr_nivel NUMBER(1) NOT NULL );

ALTER TABLE t_std_materia ADD CONSTRAINT t_std_materia_pk PRIMARY KEY (id_materia);

CREATE TABLE t_std_modulo ( id_modulo NUMBER(5) NOT NULL, id_aula NUMBER(5) NOT NULL, ds_modulo VARCHAR2(50) NOT NULL );

ALTER TABLE t_std_modulo ADD CONSTRAINT t_std_modulo_pk PRIMARY KEY (id_modulo);

CREATE TABLE t_std_pagamento ( id_pagamento NUMBER(5) NOT NULL, dt_pagamento DATE NOT NULL, vl_pagamento NUMBER(5, 2) NOT NULL, ds_status_pagamento CHAR(2) NOT NULL );

ALTER TABLE t_std_pagamento ADD CONSTRAINT t_std_pagamento_pk PRIMARY KEY (id_pagamento);

CREATE TABLE t_std_plano ( id_plano NUMBER(2) NOT NULL, nm_plano VARCHAR2(20) NOT NULL, vl_preco NUMBER(5, 2) NOT NULL, ds_plano VARCHAR2(50) NOT NULL );

ALTER TABLE t_std_plano ADD CONSTRAINT t_std_plano_pk PRIMARY KEY (id_plano);

CREATE TABLE t_std_submodulo ( id_submodulo NUMBER(5) NOT NULL, id_modulo NUMBER(5) NOT NULL, ds_titulo VARCHAR2(30) NOT NULL, ds_conteudo VARCHAR2(50) NOT NULL );

CREATE TABLE t_std_controle_plano ( id_plano NUMBER(2) NOT NULL, nm_plano_anterior VARCHAR2(20) NOT NULL, nm_plano_novo VARCHAR2(20) NOT NULL, dt_alteracao DATE NOT NULL );

ALTER TABLE t_std_submodulo ADD CONSTRAINT t_std_submodulo_pk PRIMARY KEY (id_submodulo);

CREATE TABLE t_std_usuario ( id_usuario NUMBER(10) NOT NULL, id_plano NUMBER(2) NOT NULL, nm_usuario VARCHAR2(50) NOT NULL, dt_nascimento DATE NOT NULL, ds_cpf VARCHAR2(11) NOT NULL, ds_email VARCHAR2(80) NOT NULL, ds_senha VARCHAR2(30) NOT NULL, dt_criacao_login DATE NOT NULL, ds_status_conta CHAR(1) NOT NULL, dt_ultimo_login DATE NOT NULL );

CREATE TABLE t_std_audit_log_forma_pagamento ( log_id NUMBER PRIMARY KEY, operacao VARCHAR2(10), data_operacao DATE, forma_pagamento_id NUMBER);

CREATE TABLE t_std_audit_log_usuario ( log_id NUMBER PRIMARY KEY, usuario_id NUMBER, operacao VARCHAR2(10), data_operacao DATE);


ALTER TABLE t_std_usuario ADD CONSTRAINT t_std_usuario_pk PRIMARY KEY (id_usuario);
ALTER TABLE t_std_alternativa ADD CONSTRAINT t_std_alternativa_exercicio_fk FOREIGN KEY (id_exercicio) REFERENCES t_std_exercicio (id_exercicio);
ALTER TABLE t_std_aula ADD CONSTRAINT t_std_aula_materia_fk FOREIGN KEY (id_materia) REFERENCES t_std_materia (id_materia);
ALTER TABLE t_std_cronograma ADD CONSTRAINT t_std_cronograma_usuario_fk FOREIGN KEY (id_usuario) REFERENCES t_std_usuario (id_usuario);
ALTER TABLE t_std_exercicio ADD CONSTRAINT t_std_exercicio_submodulo_fk FOREIGN KEY (id_submodulo) REFERENCES t_std_submodulo (id_submodulo);
ALTER TABLE t_std_forma_pagamento ADD CONSTRAINT t_std_forma_pagamento_pg_fk FOREIGN KEY (id_pagamento) REFERENCES t_std_pagamento (id_pagamento);
ALTER TABLE t_std_forma_pagamento ADD CONSTRAINT t_std_forma_pagamento_plano_fk FOREIGN KEY (id_plano) REFERENCES t_std_plano (id_plano);
ALTER TABLE t_std_gptprompt ADD CONSTRAINT t_std_gptprompt_cronograma_fk FOREIGN KEY (id_cronograma) REFERENCES t_std_cronograma (id_cronograma);
ALTER TABLE t_std_materia ADD CONSTRAINT t_std_materia_cronograma_fk FOREIGN KEY (id_cronograma) REFERENCES t_std_cronograma (id_cronograma);
ALTER TABLE t_std_modulo ADD CONSTRAINT t_std_modulo_aula_fk FOREIGN KEY (id_aula) REFERENCES t_std_aula (id_aula);
ALTER TABLE t_std_submodulo ADD CONSTRAINT t_std_submodulo_modulo_fk FOREIGN KEY (id_modulo) REFERENCES t_std_modulo (id_modulo);
ALTER TABLE t_std_usuario ADD CONSTRAINT t_std_usuario_plano_fk FOREIGN KEY (id_plano) REFERENCES t_std_plano (id_plano);
ALTER TABLE t_std_audit_log_forma_pagamento ADD CONSTRAINT t_std_forma_pagamento FOREIGN KEY (forma_pagamento_id) REFERENCES t_std_forma_pagamento(id_forma_pagamento);
ALTER TABLE t_std_audit_log_usuario ADD CONSTRAINT t_std_usuario FOREIGN KEY (usuario_id) REFERENCES t_std_usuario(id_usuario);
