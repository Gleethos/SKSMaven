
# SKS - Maven ? #

This little repository contains a simple
example setup for the following technology
stack configuration : <br>
<br>

- Apache Maven 3.6.x (.zip)

- JDK 11+

- Spring Tool Suite 4.8.x (.jar)

...or...

- IntelliJ IDEA Ultimate

- MySQL Community Edition 8.x

---

Todo : <br>

## Maven : ##

- Download Apache Maven from :
https://maven.apache.org/download.cgi

- Installation insruction : https://maven.apache.org/install.html

- Unzip, set PATH :

- PATH = C:\Java\apache-maven-3.6.3\bin

- MyTest it :  mvn -version

## JDK : ##
- install...

- set : JAVA_HOME = C:\Java\jdk11 

- also : PATH = C:\Java\jdk11\bin

- MyTest Java : java -version

## STS ##

- unzip, install

- start STS

## MySQL ##

- install

- password : "admin"

- MyTest : ...connect...

## pom.xml ##

```
<?xml version="1.0" encoding="UTF-8"?>
<project
        xmlns="http://maven.apache.org/POM/4.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.3.2.RELEASE</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.example</groupId>
    <artifactId>SKSMaven</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
    </dependencies>

</project>
```