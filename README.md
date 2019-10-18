# StudentSystem2.0
## 学生信息管理系统2.0 (小demo)
成品可以查看（界面展示.png）  
这是一个javaweb项目，没有使用到框架，适合学完javaee想做点小demo的同学尝试。
## 涉及内容有：
1、后端：Javase基础，servlet，JSP，jdbc  
2、前端：HTML+css，JavaScript，jQuery，ajax  
3、数据库：mysql  
4、服务器：Tomcat
## 数据库
数据库名：studentsystem  
表名：student_info  
创建表SQL语句  
CREATE TABLE student_info(  
id VARCHAR(9) NOT NULL PRIMARY KEY,  
name VARCHAR(15) NOT NULL,  
age INT(3) NOT NULL,  
sex CHAR(3) NOT NULL,  
phone VARCHAR(11) NOT NULL,  
birth DATE NOT NULL,  
number VARCHAR(18) NOT NULL,  
major VARCHAR(255) NOT NULL  
)  
   
