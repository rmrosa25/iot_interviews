# IoT Connectivity Interviews Exercise

[IoT Interviews](https://github.com/rmrosa25/iot_interviews) is a group of exercises to be used in Interviews.

# Table of Contents

- [Setup your workspace](#setup-your-workspace)
- [Exercise 1](#exercise-1)
- [Exercise 2](#exercise-2)
  - [Question 1](#question-1)

# Setup your workspace

Initiate your GITPOD workspace
TODO: This reference should be relative

<a href="https://gitpod.io/#https://github.com/rmrosa25/iot_interviews/" style="padding: 10px;">
    <img src="https://gitpod.io/button/open-in-gitpod.svg" width="150" alt="Push" align="center">
</a>

After let's start below exercises


# Exercise 1
 Fix Application and put it running with mysql db

To compile and start

```
./mvnw -B dependency:go-offline package -DskipTests
java -jar target/*.jar

```

Get your application url

 ```
 gitpod /workspace/iot_interviews (main) $ gp url 8080
 https://8080-rmrosa25-iotinterviews-tjtzq10vl3n.ws-eu67.gitpod.io
 ```

 Access to https://.../Employees/...

# Exercise 2
```
mysql -u root
mysql > Use example_app
mysql > show tables;
mysql > desc departments;
mysql > desc employees;
mysql > select * from departments;
mysql > select * from employees;
```

## Question 1

Can you print count per department on employees table?

Can you create a JOIN to print all the employees and their given department?





