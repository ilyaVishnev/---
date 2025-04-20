CREATE TABLE IF NOT EXISTS worker_info
(
    id    BIGSERIAL PRIMARY KEY ,
    last_name  VARCHAR(200) NOT NULL ,
    first_name  VARCHAR(200) NOT NULL ,
    patronymic  VARCHAR(200) NOT NULL ,
    date_of_birth  date NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    phone VARCHAR(20)  NOT NULL
);