

## MariaDB

Add user "admin"

How to add a user with all privileges to MariaDB

Add a user=admin with password=admin

```roomsql
mysql -uroot -p
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost';
FLUSH PRIVILEGES;
exit;
```
Add a user=admin without password

```roomsql
mysql -uroot -p
CREATE USER 'admin'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost';
FLUSH PRIVILEGES;
exit;
```


```
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64

```

#
#### Properties of a table
```
 mvn spring-boot:run
```



```
use friends;
show tables;
describe friend;

```


Running view
```roomsql
mannu@mannu-pc:~/workspace/Tutorials/Java/spring-rest$ mariadb -uadmin
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 61
Server version: 10.1.43-MariaDB-0ubuntu0.18.04.1 Ubuntu 18.04

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> use friends
Database changed


MariaDB [friends]> show tables;
+--------------------+
| Tables_in_friends  |
+--------------------+
| friend             |
| hibernate_sequence |
+--------------------+
2 rows in set (0.00 sec)


MariaDB [friends]> describe friend;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| id         | int(11)      | NO   | PRI | NULL    |       |
| first_name | varchar(255) | YES  |     | NULL    |       |
| last_name  | varchar(255) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+


```
#