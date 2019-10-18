<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.cl.dao.userAll" 
         import="java.util.List"
         import="java.util.Iterator"
         import="com.cl.model.Student"
         %>
<html>
  <head>
      <title>学生信息管理</title>
      <link rel="shortcut icon" href="img/学生16pxlogo.png" type="image/x-icon">
      <link type="text/css" rel="stylesheet" href="css/login.css">
      <script src="js/jquery-1.12.4.js"></script>
      <script src="js/login.js"></script>
  </head>
  <body>
    <div class="head">
        <div class="logo">
            <div class="icon"></div>
            <div class="font">学生信息管理</div>
        </div>
        <button class="add">+添加学生</button>
    </div>
    <div class="center">
        <div class="query">
            <input type="text" name="id" class="left" id="sou" placeholder="  学号">
            <button class="query_btn">搜索</button>
        </div>
    </div>
    <div class="content">
        <div class="fields">
            <div class="field">学号</div>
            <div class="field">姓名</div>
            <div class="field">年龄</div>
            <div class="field">性别</div>
            <div class="field">手机号</div>
            <div class="field">出生日期</div>
            <div class="field">专业名称</div>
            <div class="number_field">身份证号</div>
            <div class="last_field">操作</div>
        </div>
        <div class="data">
            <%
            List<Student> list = userAll.getAll();
            Iterator<Student> stus = list.iterator();
            Student stu = null;
            while (stus.hasNext()){
                stu = stus.next();
                out.print("<div class=\"datainfo\">");
                out.print("<div class=\"info\">"+stu.getId()+"</div>");
                out.print("<div class=\"info\">"+stu.getName()+"</div>");
                out.print("<div class=\"info\">"+stu.getAge()+"</div>");
                out.print("<div class=\"info\">"+stu.getSex()+"</div>");
                out.print("<div class=\"info\">"+stu.getPhone()+"</div>");
                out.print("<div class=\"info\">"+stu.getBirth()+"</div>");
                out.print("<div class=\"info\">"+stu.getmajor()+"</div>");
                out.print("<div class=\"number_info\">"+stu.getumber()+"</div>");
                out.print("<div class=\"last_info\">\n" +
                        "                    <button class=\"updata\" value=\""+stu.getId()+"\" name=\"updata\">修改</button>\n" +
                        "                    <button class=\"del\" value=\""+stu.getId()+"\" name=\"del\">删除</button>\n" +
                        "                </div>");
                out.print("</div>");
            }
          %>
        </div>
    </div>
</body>
</html>