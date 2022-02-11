CREATE KEYSPACE IF NOT EXISTS accountservice WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use accountservice;

CREATE TABLE IF NOT EXISTS account
(
    id         varchar PRIMARY KEY,
    uname      varchar,
    name       varchar,
    surname    varchar,
    email      varchar,
    birthDate  timestamp,
    created_at timestamp,
    is_active  boolean
);