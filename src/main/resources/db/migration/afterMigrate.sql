set foreign_key_checks = 0;

lock tables medicos write, pacientes write;

delete from medicos;
delete from pacientes;

set foreign_key_checks = 1;

alter table medicos auto_increment = 1;
alter table pacientes auto_increment = 1;

# Mok Medicos
insert into medicos (nome, email, crm, especialidade,telefone,logradouro,bairro,cep,complemento,numero,uf,cidade)
values ('Jorge Rufino', 'jorge@gmail.com','123456','CARDIOLOGIA','99999-9999','Av Brasil','Centro','12345-000','Fundos','136','PA','Benevides');
insert into medicos (nome, email, crm, especialidade,telefone,logradouro,bairro,cep,numero,uf,cidade)
values ('Ubirajara Salgado', 'bira@hotmail.com','654321','ORTOPEDIA','98888-8888','Rua Pinheiro Delgado','Reduto','65978-000','1001-B','PA','Belém');
insert into medicos (nome, email, crm, especialidade,telefone,logradouro,bairro,cep,complemento,numero,uf,cidade)
values ('Larissa Sousa', 'larissa@gmail.com','111222','GINECOLOGIA','91234-5678','Av Joao Fanjas','Coqueiro','68795-000','Altos','205','PA','Ananindeua');

# Dados gerados em (https://generatedata.com/generator)
INSERT INTO `medicos` (`nome`,`email`,`crm`,`especialidade`,`telefone`,`logradouro`,`bairro`,`cep`,`numero`,`uf`,`cidade`)
VALUES
    ("Xanthus de Andrade","massa.vestibulum.accumsan@icloud.net","044119","ORTOPEDIA","44012-1522","Rod.Br 316","Reduto","61140-880","181","PA","Belem"),
    ("Farrah Abreu","sem@yahoo.net","132259","CARDIOLOGIA","66542-9440","Rua General Gurjao","Canutama","62764-923","6866","PA","Benevides"),
    ("Isaac Sántos","tempor@google.ca","876997","ORTOPEDIA","22878-2126","Av. Almirante Barroso","Reduto","65093-545","638","PA","Ananindeua"),
    ("Oleg Rocha","nunc.nulla@icloud.couk","414077","ORTOPEDIA","53135-0785","Rua General Gurjao","Braz","13483-424","4254","PA","Marituba"),
    ("Baxter de Freitas","mus.donec@protonmail.couk","086866","CARDIOLOGIA","72165-7045","Av. Gentil Bitencourt","Pratinha","18150-889","615","PA","Marituba"),
    ("Zeus Maciel","nullam@icloud.com","576268","GINECOLOGIA","15758-5382","Rod.Br 316","Braz","85618-338","642","PA","Marituba"),
    ("Steel Amorim","cursus@hotmail.ca","926771","ORTOPEDIA","61086-4824","Rua General Gurjao","Braz","89684-902","1254","PA","Marituba"),
    ("Graiden Paiva","mauris.molestie.pharetra@icloud.com","865223","CARDIOLOGIA","28797-3812","Av. Almirante Barroso","Centro","97913-514","3871","PA","Belem"),
    ("Damon Soares","nulla.donec@yahoo.net","588236","ORTOPEDIA","76361-6424","Rua General Gurjao","Braz","25412-551","9072","PA","Marituba"),
    ("Allistair Diniz","sed.facilisis@yahoo.edu","134674","CARDIOLOGIA","62662-3887","Av. Gentil Bitencourt","Coqueiro","58986-871","7416","PA","Belem");

insert into pacientes (nome, email, cpf, telefone,logradouro,bairro,cep, numero,uf,cidade)
values
    ("Antonio Lima","antonio@icloud.net","11122233344", "44012-1522","Rod.Br 316","Reduto","61140-880","181","PA","Belem"),
    ("Julia Rufino","julia@hotmail.net","11222213345", "95212-1522","Almirante Barros","Reduto","61140-880","500","PA","Marituba"),
    ("Nayara Sousa","nay@hotmail.net","00221561334", "95500-1522","Visconde Sousa","Centro","61140-880","505","PA","Benevides");


unlock tables;