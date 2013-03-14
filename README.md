# Sample CDI on Tomcat/Jetty

## What is it?

This is a barebones, deployable Maven project that servers as a proof of concept
for Java EE 6 on servlet containers. Specifically, this project is setup to allow
you to create a JSF, JPA and CDI 1.0 application that can run on Tomcat and Jetty.

## Deploy on CloudBees

 Set the database credentials with:

 #bees config:set -a myappid db.username=mydbuser
 #bees config:set -a myappid db.password=mydbpassword

 Or

 #bees app:deploy -a myappid -P db.password=mydbpassword -P db.password=mydbpassword myapp.war


## Usage with Cloud4SOA

 You can use this project to test cloud deployment with Cloud4SOA modeling an application profile with
 a database software component.



