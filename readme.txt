 Cyntelix Sample CDI on Tomcat/Jetty

 What is it?
 ===========

 This is a barebones, deployable Maven project to help you
 get your foot in the door developing with Java EE 6. Specifically, this
 project is setup to allow you to create a JSF, JPA and CDI 1.0 application that
 can run on Servlet Containers like Tomcat and Jetty.

 Deploy on CloudBees
 ===================

 Set the database credentials with:

 #bees config:set -a myappid db.username=mydbuser
 #bees config:set -a myappid db.password=mydbpassword

 Or

 #bees app:deploy -a myappid -P db.password=mydbpassword -P db.password=mydbpassword build/myapp.war



