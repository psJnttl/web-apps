PostgreSQL + Java Spring Boot + AngularJS

PostgreSQL has been used as database for application data. For a quick start it's a good
idea to run the database in a Virtual Machine. Excellent documentation how to do that can be
found here:
https://wiki.postgresql.org/wiki/PostgreSQL_For_Development_With_Vagrant

Flyway is used to migrate some data to the database when application is run the first time.
For more info on Flyway, visit: http://flywaydb.org/

Java back-end is accessing database mainly via JpaRepository. Some native queries are used to
experiment with the Java 8 style in result processing. JDBC template might bring a bit clearer
code though.

Front-end is done with AngularJS. Each view/tab has it's own controller. Some experimentation
has been done with ColumnSorter.js to get an idea how filters work. AngularJS' builtin orderBy
filter is used in the actual 'production' version.

I built this app when I was a trainee at Solita and has been published with their permission.
The base can be found at:
https://github.com/mprencipe/angular-1.5.x-tutorial
