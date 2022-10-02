# IoT Connectivity Interviews Exercise

[IoT Interviews](https://github.com/rmrosa25/iot_interviews) is a group of exercises to be used in Interviews.

# Table of Contents

- [IoT Connectivity Interviews Exercise](#iot-connectivity-interviews-exercise)
- [Table of Contents](#table-of-contents)
- [Setup your workspace](#setup-your-workspace)
- [Workspace tips](#workspace-tips)
  - [Database](#database)
  - [Application](#application)

# Setup your workspace

Initiate your GITPOD workspace

[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/from-referrer/)

# Workspace tips

## Database
Mysql database with following schema objects

[employees](/data/mysql/tables/employees.db.md)

[departments](/data/mysql/tables/departments.db.md)

Access to database from command line

```
mysql -u root -p example_app

mysql > show tables;
mysql > desc departments;
mysql > desc employees;

```

Recreate Database

```
mysql -u root -e "drop database example_app";
mysql -u root -e "create database example_app";
mysql -u root -p example_app < createTables.sql;
mysql -u root -p example_app < insertData.sql;

```

## Application

SpringBoot application that expose employees services described below

To compile and start

```
./mvnw -B dependency:go-offline package -DskipTests
java -jar target/*.jar

```

Get your application url

 ```
 gitpod /workspace/iot_interviews (main) $ gp url 8080
 https://8080-rmrosa25-iotinterviews-n9i34m5f0yb.ws-eu69.gitpod.io

 ```

 Access to https://8080-rmrosa25-iotinterviews-n9i34m5f0yb.ws-eu69.gitpod.io/
