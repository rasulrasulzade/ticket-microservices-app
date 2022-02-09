CREATE KEYSPACE accountservice
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};