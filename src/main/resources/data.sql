--COMANDOS DML

-- Populando tabela t_std_plano
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 1', 29.90,'Plano Pro');
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 2', 0,'Plano Gr�tis');
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 3', 19.90,'Plano Iniciante');
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 1', 29.90,'Plano Pro');
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 2', 0,'Plano Gr�tis');

-- Populando tabela t_std_usuario
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (1, 'Usu�rio 1', TO_DATE('2000-01-01', 'YYYY-MM-DD'), '12345678901', 'usuario1@example.com', 'senha1', TO_DATE('2023-01-01', 'YYYY-MM-DD'), 'A', TO_DATE('2023-01-01', 'YYYY-MM-DD'));
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (2, 'Usu�rio 2', TO_DATE('2000-02-02', 'YYYY-MM-DD'), '23456789012', 'usuario2@example.com', 'senha2', TO_DATE('2023-02-02', 'YYYY-MM-DD'), 'A', TO_DATE('2023-02-02', 'YYYY-MM-DD'));
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (2, 'Usu�rio 3', TO_DATE('2000-03-03', 'YYYY-MM-DD'), '34567890123', 'usuario3@example.com', 'senha3', TO_DATE('2023-03-03', 'YYYY-MM-DD'), 'A', TO_DATE('2023-03-03', 'YYYY-MM-DD'));
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (3, 'Usu�rio 4', TO_DATE('2000-04-04', 'YYYY-MM-DD'), '45678901234', 'usuario4@example.com', 'senha4', TO_DATE('2023-04-04', 'YYYY-MM-DD'), 'A', TO_DATE('2023-04-04', 'YYYY-MM-DD'));
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (3, 'Usu�rio 5', TO_DATE('2000-05-05', 'YYYY-MM-DD'), '56789012345', 'usuario5@example.com', 'senha5', TO_DATE('2023-05-05', 'YYYY-MM-DD'), 'A', TO_DATE('2023-05-05', 'YYYY-MM-DD'));

-- Populando tabela t_std_cronograma
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (1, 50);
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (2, 75);
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (3, 25);
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (4, 90);
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (5, 60);

-- Populando tabela t_std_gptprompt
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (1, TO_DATE('2023-05-01', 'YYYY-MM-DD'), 'Prompt 1', utl_raw.cast_to_raw('Choices 1'), 123456789, 'GPTID1', 'GPT Model 1', 'GPT Object 1', 10, 20, 30);
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (2, TO_DATE('2023-05-02', 'YYYY-MM-DD'), 'Prompt 2', utl_raw.cast_to_raw('Choices 2'), 234567890, 'GPTID2', 'GPT Model 2', 'GPT Object 2', 15, 25, 35);
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (3, TO_DATE('2023-05-03', 'YYYY-MM-DD'), 'Prompt 3', utl_raw.cast_to_raw('Choices 3'), 345678901, 'GPTID3', 'GPT Model 3', 'GPT Object 3', 12, 22, 32);
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (4, TO_DATE('2023-05-04', 'YYYY-MM-DD'), 'Prompt 4', utl_raw.cast_to_raw('Choices 4'), 456789012, 'GPTID4', 'GPT Model 4', 'GPT Object 4', 18, 28, 38);
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (5, TO_DATE('2023-05-05', 'YYYY-MM-DD'), 'Prompt 5', utl_raw.cast_to_raw('Choices 5'), 567890123, 'GPTID5', 'GPT Model 5', 'GPT Object 5', 16, 26, 36);

-- Populando tabela t_std_materia
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (1, 'Mat�ria 1', 1);
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (1, 'Mat�ria 2', 2);
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (2, 'Mat�ria 1', 3);
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (2, 'Mat�ria 2', 1);
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (3, 'Mat�ria 1', 3);

-- Populando tabela t_std_aula
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (1, 'Aula 1', 'Descri��o da Aula 1');
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (1, 'Aula 2', 'Descri��o da Aula 2');
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (2, 'Aula 1', 'Descri��o da Aula 1');
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (2, 'Aula 2', 'Descri��o da Aula 2');
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (3, 'Aula 1', 'Descri��o da Aula 1');

-- Populando tabela t_std_modulo
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (1, 'M�dulo 1');
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (1, 'M�dulo 2');
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (2, 'M�dulo 1');
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (2, 'M�dulo 2');
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (3, 'M�dulo 1');

-- Populando tabela t_std_submodulo
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (1, 'Subm�dulo A', 'Conte�do A');
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (1, 'Subm�dulo B', 'Conte�do B');
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (2, 'Subm�dulo A', 'Conte�do C');
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (2, 'Subm�dulo B', 'Conte�do D');
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (3, 'Subm�dulo A', 'Conte�do E');

-- Populando tabela t_std_exercicio
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (1, 'Exerc�cio 1', 'Qual � a capital do Brasil?');
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (1, 'Exerc�cio 2', 'Quanto � 2 + 2?');
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (2, 'Exerc�cio 1', 'Qual � o maior planeta do sistema solar?');
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (2, 'Exerc�cio 2', 'Quem pintou a Mona Lisa?');
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (3, 'Exerc�cio 1', 'Qual � a f�rmula qu�mica da �gua?');

-- Populando tabela t_std_alternativa
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (1, 'Gatos s�o felinos', 'A');
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (1, 'A f�rmula da �gua � H20', 'B');
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (1, '2+2 � 4', 'C');
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (2, 'Segunda Guerra Mundial', 'A');
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (2, 'Hist�ria', 'B');

-- Populando tabela t_std_pagamento
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES (TO_DATE('2023-01-01', 'YYYY-MM-DD'),29.9, 'P');
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES (TO_DATE('2023-02-23', 'YYYY-MM-DD'),0, 'N');
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES (TO_DATE('2023-04-01', 'YYYY-MM-DD'),19.9, 'P');
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES (TO_DATE('2023-01-12', 'YYYY-MM-DD'),0, 'N');
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES (TO_DATE('2023-05-31', 'YYYY-MM-DD'),29.9, 'P');

-- Populando tabela t_std_forma_pagamento
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (1, 1, 'Titular 1', '12345678901', 1234567890123456, TO_DATE('2025-12-31', 'YYYY-MM-DD'), 123);
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (2, 2, 'Titular 2', '23456789012', 2345678901234567, TO_DATE('2024-10-31', 'YYYY-MM-DD'), 234);
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (2, 3, 'Titular 3', '34567890123', 3456789012345678, TO_DATE('2023-08-31', 'YYYY-MM-DD'), 345);
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (3, 4, 'Titular 4', '45678901234', 4567890123456789, TO_DATE('2025-06-30', 'YYYY-MM-DD'), 456);
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (3, 5, 'Titular 5', '56789012345', 5678901234567890, TO_DATE('2024-04-30', 'YYYY-MM-DD'), 567);