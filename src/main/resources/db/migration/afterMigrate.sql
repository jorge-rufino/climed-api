set foreign_key_checks = 0;

lock tables medicos write;

delete from medicos;

set foreign_key_checks = 1;

alter table medicos auto_increment = 1;

unlock tables;