
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
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <groovy.version>2.5.13</groovy.version>
    </properties>


    <build>
        <plugins>
            <!-- Mandatory plugins for using Spock -->
            <plugin>
                <!-- The gmavenplus plugin is used to compile Groovy code. To learn more about this plugin,
                visit https://github.com/groovy/GMavenPlus/wiki -->
                <groupId>org.codehaus.gmavenplus</groupId>
                <artifactId>gmavenplus-plugin</artifactId>
                <version>1.6</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>compile</goal>
                            <goal>compileTests</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>

        <pluginManagement>
            <plugins>
                <plugin>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.8.1</version>
                </plugin>
                <plugin>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>3.0.0-M5</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>



    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.spockframework</groupId>
                <artifactId>spock-bom</artifactId>
                <version>2.0-M3-groovy-2.5</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-web -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>5.2.9.RELEASE</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.7.0</version>
            <scope>test</scope>
        </dependency>

        <!-- Mandatory dependencies for using Spock -->
        <dependency>
            <groupId>org.spockframework</groupId>
            <artifactId>spock-core</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.spockframework</groupId>
            <artifactId>spock-junit4</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Optional dependencies for using Spock -->
        <dependency> <!-- use a specific Groovy version rather than the one specified by spock-core -->
            <groupId>org.codehaus.groovy</groupId>
            <artifactId>groovy</artifactId>
            <version>${groovy.version}</version>
        </dependency>
        <dependency> <!-- enables mocking of classes (in addition to interfaces) -->
            <groupId>net.bytebuddy</groupId>
            <artifactId>byte-buddy</artifactId>
            <version>1.10.10</version>
            <scope>test</scope>
        </dependency>
        <dependency> <!-- enables mocking of classes without default constructor (together with ByteBuddy or CGLIB) -->
            <groupId>org.objenesis</groupId>
            <artifactId>objenesis</artifactId>
            <version>3.1</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

</project>

```