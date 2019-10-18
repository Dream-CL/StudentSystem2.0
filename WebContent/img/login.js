$(function () {
    $(".add").click(function () {
        $mask = $("<div class=\"mask\">\n" +
            "    <div class=\"add\">\n" +
            "        <span class=\"cancel\"><img src=\"img/取消32px1.png\" alt=\"取消\"></span>\n" +
            "        <div class=\"infos\">\n" +
            "            <form action=\"\" method=\"post\">\n" +
            "            <div class=\"add_info\"><p>学号：</p><input type=\"text\" name=\"id\" id=\"id\"></div><br>\n" +
            "            <div class=\"add_info\"><p>姓名：</p><input type=\"text\" name=\"name\" id=\"name\"></div><br>\n" +
            "            <div class=\"add_info\"><p>年龄：</p><input type=\"text\" name=\"age\" id=\"age\"></div><br>\n" +
            "            <div class=\"add_info\"><p>性别：</p><input type=\"text\" name=\"sex\" id=\"sex\"></div><br>\n" +
            "            <div class=\"add_info\"><p>手机号：</p><input type=\"text\" name=\"phone\" id=\"phone\"></div><br>\n" +
            "            <div class=\"add_info\"><p>出生日期：</p><input type=\"text\" name=\"birth\" id=\"birth\"></div><br>\n" +
            "            <div class=\"add_info\"><p>专业名称：</p><input type=\"text\" name=\"major\" id=\"major\"></div><br>\n" +
            "            <div class=\"add_info\"><p>身份证号：</p><input type=\"text\" name=\"number\" id=\"number\"></div>\n" +
            "            <input type=\"submit\" class=\"put\" value=\"提交\" name=\"put\" id=\"put\" onclick=\"return check()\">\n" +
            "            </form>\n" +
            "        </div>\n" +
            "        </div>\n" +
            "    </div>");
        //添加蒙版
        $("body").append($mask);
        //移除蒙版
        $("body").delegate(".cancel>img","click",function () {
            if(confirm("你确定要取消本次添加吗？")){
                // 移除蒙版
                $mask.remove();
                return true;
            }else{
                return false;
            }
        });
    });
});

//添加学生信息正则匹配
function check() {
    var id = document.getElementById("id").value;
    if(!(/^[1][0-9]{8}$/.test(id))){
        document.getElementById("id").focus();
        alert("学号错误！");
        return false;
    }
    var name = document.getElementById("name").value;
    if(!(/[\u4e00-\u9fa5]{2,4}/.test(name))){
        document.getElementById("name").focus();
        alert("姓名错误！");
        return false;
    }
    var age = document.getElementById("age").value;
    if(!(/^[1-9][0-9]/.test(age))){
        document.getElementById("age").focus();
        alert("年龄错误！");
        return false;
    }
    var sex = document.getElementById("sex").value;
    if(!(/^['男'|'女']&/.test(sex))){
        document.getElementById("sex").focus();
        alert("性别错误！");
        return false;
    }
    var phone = document.getElementById("phone").value;
    if(!(/1[3-9]\d{9}/.test(phone))){
        document.getElementById("phone").focus();
        alert("电话号码错误！");
        return false;
    }
    var date = document.getElementById("date").value;
    if(!(/^((?:19[2-9]\d{1})|(?:20(?:(?:0[0-9])|(?:1[0-8]))))\-((?:0?[1-9])|(?:1[0-2]))\-((?:0?[1-9])|(?:[1-2][0-9])|30|31)$/.test(date))){
        document.getElementById("date").focus();
        alert("出生日期错误！");
        return false;
    }
    var major = document.getElementById("major").value;
    if(!(/[\u4e00-\u9fa5]{4,8}/.test(major))){
        document.getElementById("major").focus();
        alert("专业名称错误！");
        return false;
    }
    var number = document.getElementById("number").value;
    if(!(/^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/.test(number))){
        document.getElementById("number").focus();
        alert("身份证号错误！");
        return false;
    }
    alert("添加成功！")
    return true;
};