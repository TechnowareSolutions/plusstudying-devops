-- Populando tabela t_std_plano
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 1', 29.90, 'Plano Pro');
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 2', 0, 'Plano Grátis');
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 3', 19.90, 'Plano Iniciante');
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 1', 29.90, 'Plano Pro');
INSERT INTO t_std_plano (nm_plano, vl_preco, ds_plano) VALUES ('Plano 2', 0, 'Plano Grátis');

-- Populando tabela t_std_usuario
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (1, 'Usuário 1', '2000-01-01', '12345678901', 'usuario1@example.com', 'senha1', '2023-01-01', 'A', '2023-01-01');
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (2, 'Usuário 2', '2000-02-02', '23456789012', 'usuario2@example.com', 'senha2', '2023-02-02', 'A', '2023-02-02');
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (2, 'Usuário 3', '2000-03-03', '34567890123', 'usuario3@example.com', 'senha3', '2023-03-03', 'A', '2023-03-03');
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (3, 'Usuário 4', '2000-04-04', '45678901234', 'usuario4@example.com', 'senha4', '2023-04-04', 'A', '2023-04-04');
INSERT INTO t_std_usuario (id_plano, nm_usuario, dt_nascimento, ds_cpf, ds_email, ds_senha, dt_criacao_login, ds_status_conta, dt_ultimo_login) VALUES (3, 'Usuário 5', '2000-05-05', '56789012345', 'usuario5@example.com', 'senha5', '2023-05-05', 'A', '2023-05-05');

-- Populando tabela t_std_cronograma
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (1, 50);
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (2, 75);
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (3, 25);
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (4, 90);
INSERT INTO t_std_cronograma (id_usuario, nr_porcentagem) VALUES (5, 60);

-- Populando tabela t_std_gptprompt
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (1, '2023-05-01', 'Prompt 1', 'Choices 1', 123456789, 'GPTID1', 'GPT Model 1', 'GPT Object 1', 10, 20, 30);
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (2, '2023-05-02', 'Prompt 2', 'Choices 2', 234567890, 'GPTID2', 'GPT Model 2', 'GPT Object 2', 15, 25, 35);
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (3, '2023-05-03', 'Prompt 3', 'Choices 3', 345678901, 'GPTID3', 'GPT Model 3', 'GPT Object 3', 12, 22, 32);
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (4, '2023-05-04', 'Prompt 4', 'Choices 4', 456789012, 'GPTID4', 'GPT Model 4', 'GPT Object 4', 18, 28, 38);
INSERT INTO t_std_gptprompt (id_cronograma, dt_prompt, ds_prompt, gpt_choices, gpt_created, gpt_id, gpt_model, gpt_object, gpt_compl_tokens, gpt_prompt_tokens, gpt_total_tokens) VALUES (5, '2023-05-05', 'Prompt 5', 'Choices 5', 567890123, 'GPTID5', 'GPT Model 5', 'GPT Object 5', 16, 26, 36);

-- Populando tabela t_std_materia
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (1, 'Matéria 1', 1);
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (1, 'Matéria 2', 2);
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (2, 'Matéria 1', 3);
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (2, 'Matéria 2', 1);
INSERT INTO t_std_materia (id_cronograma, nm_materia, nr_nivel) VALUES (3, 'Matéria 1', 3);

-- Populando tabela t_std_aula
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (1, 'Aula 1', 'Descrição da Aula 1');
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (1, 'Aula 2', 'Descrição da Aula 2');
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (2, 'Aula 1', 'Descrição da Aula 1');
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (2, 'Aula 2', 'Descrição da Aula 2');
INSERT INTO t_std_aula (id_materia, ds_titulo, ds_descricao_aula) VALUES (3, 'Aula 1', 'Descrição da Aula 1');

-- Populando tabela t_std_modulo
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (1, 'Módulo 1');
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (1, 'Módulo 2');
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (2, 'Módulo 1');
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (2, 'Módulo 2');
INSERT INTO t_std_modulo (id_aula, ds_modulo) VALUES (3, 'Módulo 1');

-- Populando tabela t_std_submodulo
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (1, 'Submódulo A', 'Conteúdo A');
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (1, 'Submódulo B', 'Conteúdo B');
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (2, 'Submódulo A', 'Conteúdo C');
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (2, 'Submódulo B', 'Conteúdo D');
INSERT INTO t_std_submodulo (id_modulo, ds_titulo, ds_conteudo) VALUES (3, 'Submódulo A', 'Conteúdo E');

-- Populando tabela t_std_exercicio
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (1, 'Exercício 1', 'Qual é a capital do Brasil?');
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (1, 'Exercício 2', 'Quanto é 2 + 2?');
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (2, 'Exercício 1', 'Qual é o maior planeta do sistema solar?');
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (2, 'Exercício 2', 'Quem pintou a Mona Lisa?');
INSERT INTO t_std_exercicio (id_submodulo, ds_titulo, ds_pergunta) VALUES (3, 'Exercício 1', 'Qual é a fórmula química da água?');

-- Populando tabela t_std_alternativa
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (1, 'Gatos são felinos', 'A');
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (1, 'A fórmula da água é H2O', 'B');
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (1, '2 + 2 é 4', 'C');
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (2, 'Segunda Guerra Mundial', 'A');
INSERT INTO t_std_alternativa (id_exercicio, ds_alternativa, ds_resposta) VALUES (2, 'História', 'B');

-- Populando tabela t_std_pagamento
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES ('2023-01-01', 29.9, 'P');
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES ('2023-02-23', 0, 'N');
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES ('2023-04-01', 19.9, 'P');
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES ('2023-01-12', 0, 'N');
INSERT INTO t_std_pagamento (dt_pagamento, vl_pagamento, ds_status_pagamento) VALUES ('2023-05-31', 29.9, 'P');

-- Populando tabela t_std_forma_pagamento
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (1, 1, 'Titular 1', '12345678901', '1234567890123456', '2025-12-31', 123);
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (2, 2, 'Titular 2', '23456789012', '2345678901234567', '2024-10-31', 234);
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (2, 3, 'Titular 3', '34567890123', '3456789012345678', '2023-08-31', 345);
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (3, 4, 'Titular 4', '45678901234', '4567890123456789', '2025-06-30', 456);
INSERT INTO t_std_forma_pagamento (id_plano, id_pagamento, nm_titular, nr_cpf, nr_cartao, dt_validade, nr_cvv) VALUES (3, 5, 'Titular 5', '56789012345', '5678901234567890', '2024-04-30', 567);
