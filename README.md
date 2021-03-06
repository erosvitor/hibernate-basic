## About
The project shows how use fundamentals of Hibernate ORM.

## Technologies
The following technologies were used in this project:

* [Java Oracle](https://www.oracle.com/java/)
* [Apache Maven](https://maven.apache.org/)
* [MySQL Server](https://www.mysql.com/)
* [Hibernate ORM](https://hibernate.org/orm/)
* [IDE Eclipse](https://www.eclipse.org/)

## Starting the project

### Clonning the project
```
$ git clone https://github.com/erosvitor/hibernate-basic.git

$ cd hibernate-basic
```

### Creating the database
A demo database must be created by using the following command:

```
CREATE SCHEMA hibernatebasic DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

USE hibernatebasic;

CREATE TABLE students
(
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  date_birth DATE NOT NULL,
  PRIMARY KEY (id)
);
```

Run the following commands to populate the demo database:

```
INSERT INTO students (id, name, date_birth) VALUES (1, 'Beltrano Cunha', '1983-01-27');
INSERT INTO students (id, name, date_birth) VALUES (2, 'Siclano Pereira', '1982-03-20');
INSERT INTO students (id, name, date_birth) VALUES (3, 'Fulano da Silva', '1983-05-12');
INSERT INTO students (id, name, date_birth) VALUES (4, 'Acrópolis da Penha', '1981-12-05');
INSERT INTO students (id, name, date_birth) VALUES (5, 'Mitrus Gonçalves', '1984-01-30');
INSERT INTO students (id, name, date_birth) VALUES (6, 'Bino Alvarenga', '1980-05-20');
INSERT INTO students (id, name, date_birth) VALUES (7, 'Goman da Silva', '1983-11-10');
INSERT INTO students (id, name, date_birth) VALUES (8, 'Sincom Gomes', '1985-10-24');
INSERT INTO students (id, name, date_birth) VALUES (9, 'Beltrana Gomes da Silva', '1982-10-20');
INSERT INTO students (id, name, date_birth) VALUES (10, 'Siclana Pinheiro', '1984-06-06');
INSERT INTO students (id, name, date_birth) VALUES (11, 'Fulana Pedrosa', '1983-08-10');
INSERT INTO students (id, name, date_birth) VALUES (12, 'Duola Andrade', '1982-11-09');
INSERT INTO students (id, name, date_birth) VALUES (13, 'Katrina Munhoz', '1985-12-20');
INSERT INTO students (id, name, date_birth) VALUES (14, 'Vaz Castro', '1982-11-02');
INSERT INTO students (id, name, date_birth) VALUES (15, 'Suli Mascarenhas', '1985-04-20');
```
### Testing the project
**Step 1:** Start the application using Eclipse IDE

## License
This project is under license from MIT. For more details, see the LICENSE file.
