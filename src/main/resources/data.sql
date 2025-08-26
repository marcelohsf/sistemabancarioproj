-- Inserir dados de exemplo
INSERT INTO banco (razao_social) VALUES ('Banco do Brasil S.A.');
INSERT INTO banco (razao_social) VALUES ('Caixa Econômica Federal');

INSERT INTO usuario (razao_social) VALUES ('João Silva');
INSERT INTO usuario (razao_social) VALUES ('Maria Santos');

INSERT INTO pessoa (nome, email, senha) VALUES ('João Silva', 'joao@email.com', '123456');
INSERT INTO pessoa (nome, email, senha) VALUES ('Maria Santos', 'maria@email.com', '123456');

INSERT INTO conta (saldo, tipo_conta, banco_id, usuario_id) VALUES (1000.00, 'CORRENTE', 1, 1);
INSERT INTO conta (saldo, tipo_conta, banco_id, usuario_id) VALUES (500.00, 'POUPANCA', 1, 1);
INSERT INTO conta (saldo, tipo_conta, banco_id, usuario_id) VALUES (2000.00, 'CORRENTE', 2, 2);

INSERT INTO orcamento (valor_limite, mes, pessoa_id, conta_id) VALUES (1500.00, 1, 1, 1);
INSERT INTO orcamento (valor_limite, mes, pessoa_id, conta_id) VALUES (800.00, 1, 2, 3);

INSERT INTO lancamento (descricao, valor, tipo, situacao, data_lancamento, conta_id) 
VALUES ('Salário', 3000.00, 'CREDITO', 'FECHADO', '2024-01-01', 1);

INSERT INTO lancamento (descricao, valor, tipo, situacao, data_lancamento, conta_id) 
VALUES ('Supermercado', 150.00, 'DEBITO', 'FECHADO', '2024-01-02', 1);
