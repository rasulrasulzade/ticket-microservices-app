CREATE KEYSPACE IF NOT EXISTS accountservice WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use accountservice;

CREATE TABLE emp(
    emp_id int PRIMARY KEY,
    emp_name text,
    emp_city text,
    emp_sal varint,
    emp_phone varint
);