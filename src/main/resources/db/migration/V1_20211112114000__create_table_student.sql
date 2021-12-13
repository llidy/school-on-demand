
create table student (
    id int8 NOT NULL auto_increment,
    name varchar(255) NOT NULL,
    cpf varchar(64) NOT NULL,
    email varchar(64) NOT NULL,
    rg varchar(64) NOT NULL,
    birth_date varchar(64) NOT NULL,
    mother_name varchar(255) NOT NULL,
    father_name varchar(255) NOT NULL,
    registration_number varchar(255) NOT NULL,
    initial_date DATE NOT NULL,
    CONSTRAINT student_pk PRIMARY KEY(id)
);