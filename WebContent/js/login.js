$(function(){
	
		//添加学生信息
		$(".add").click(function () {
	        $mask = $("<div class=\"mask\">\n" +
	            "    <div class=\"add\">\n" +
	            "        <span class=\"cancel\"><img src=\"img/取消32px1.png\" alt=\"取消\"></span>\n" +
	            "        <div class=\"infos\">\n" +
	            "            <form action=\"\" name=\"form\" method=\"post\">\n" +
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
		
		//搜索学生信息
		$(".query_btn").click(function(){
			if($("#sou").val()==""||$("#sou").val()==null||$("#sou").val()==undefined){
				alert("请输入学号");
			}else{
				var flag = {};
				$.ajax({
					url:"QueryStudent2.0",//传送地址
					type:"post",
					dataType: "json",
					data:{
						"id":$("#sou").val()
						},
					success:function(data){
						flag = JSON.stringify(data);
						var info = JSON.parse(flag);
						if(info.id==$("#sou").val()){
							$mask = $("<div class=\"mask\">\n" +
			      		            "    <div class=\"add\">\n" +
			      		            "        <span class=\"cancel\"><img src=\"img/取消32px1.png\" alt=\"取消\"></span>\n" +
			      		            "        <div class=\"infos\">\n" +
			      		            "            <form action=\"\" name=\"form\" method=\"post\">\n" +
			      		            "            <div class=\"add_info\"><p>学号：</p><input type=\"text\" name=\"id\" id=\"id\" value=\""+info.id+"\" readonly=\"readonly\"></div><br>\n" +
			      		            "            <div class=\"add_info\"><p>姓名：</p><input type=\"text\" name=\"name\" id=\"name\" value=\""+info.name+"\"></div><br>\n" +
			      		            "            <div class=\"add_info\"><p>年龄：</p><input type=\"text\" name=\"age\" id=\"age\" value=\""+info.age+"\"></div><br>\n" +
			      		            "            <div class=\"add_info\"><p>性别：</p><input type=\"text\" name=\"sex\" id=\"sex\" value=\""+info.sex+"\"></div><br>\n" +
			      		            "            <div class=\"add_info\"><p>手机号：</p><input type=\"text\" name=\"phone\" id=\"phone\" value=\""+info.phone+"\"></div><br>\n" +
			      		            "            <div class=\"add_info\"><p>出生日期：</p><input type=\"text\" name=\"birth\" id=\"birth\" value=\""+info.birth+"\"></div><br>\n" +
			      		            "            <div class=\"add_info\"><p>专业名称：</p><input type=\"text\" name=\"major\" id=\"major\" value=\""+info.major+"\" readonly=\"readonly\"></div><br>\n" +
			      		            "            <div class=\"add_info\"><p>身份证号：</p><input type=\"text\" name=\"number\" id=\"number\" value=\""+info.number+"\" readonly=\"readonly\"></div>\n" +
			      		            "            </form>\n" +
			      		            "        </div>\n" +
			      		            "        </div>\n" +
			      		            "    </div>");
			      		        //添加蒙版
			      		        $("body").append($mask);
			      		        //移除蒙版
			      		        $("body").delegate(".cancel>img","click",function () {
			      		                // 移除蒙版
			      		                $mask.remove();
			      		                return true;
			      		        }); 
						}else{
							alert("没有该学生的信息。");
						}
					},
					error:function(data){
						alert("失败");
					}
				});
			}
		});
	
		var delObj = {};
		//删除学生jQuery代码
		$(".del").click(function(){
			if(confirm("确定要删除学号:"+$(this).val()+"的学生吗？")){
				$.ajax({
					url:"DeleteStudent2.0",//请求地址
					type:"post",//请求类型
					data:{
						"id":$(this).val()
					},
					success:function(data){
						delObj = JSON.parse(data);
						alert(delObj.win);
						location.reload();
					}
				})
			}
		});
		
		var updataObj = {};
		//修改学生信息jQuery代码
		$(".updata").click(function(){
			$.ajax({
				url:"UpdataStudent2.0",//提交地址
				type:"post",//提交方式
				data:{
					"id":$(this).val()
				},
				success:function(data){
					updataObj = JSON.parse(data);
					$mask = $("<div class=\"mask\">\n" +
	      		            "    <div class=\"add\">\n" +
	      		            "        <span class=\"cancel\"><img src=\"img/取消32px1.png\" alt=\"取消\"></span>\n" +
	      		            "        <div class=\"infos\">\n" +
	      		            "            <form action=\"\" name=\"form\" method=\"post\">\n" +
	      		            "            <div class=\"add_info\"><p>学号：</p><input type=\"text\" name=\"id\" id=\"id\" value=\""+updataObj.id+"\" readonly=\"readonly\"></div><br>\n" +
	      		            "            <div class=\"add_info\"><p>姓名：</p><input type=\"text\" name=\"name\" id=\"name\" value=\""+updataObj.name+"\"></div><br>\n" +
	      		            "            <div class=\"add_info\"><p>年龄：</p><input type=\"text\" name=\"age\" id=\"age\" value=\""+updataObj.age+"\"></div><br>\n" +
	      		            "            <div class=\"add_info\"><p>性别：</p><input type=\"text\" name=\"sex\" id=\"sex\" value=\""+updataObj.sex+"\"></div><br>\n" +
	      		            "            <div class=\"add_info\"><p>手机号：</p><input type=\"text\" name=\"phone\" id=\"phone\" value=\""+updataObj.phone+"\"></div><br>\n" +
	      		            "            <div class=\"add_info\"><p>出生日期：</p><input type=\"text\" name=\"birth\" id=\"birth\" value=\""+updataObj.birth+"\"></div><br>\n" +
	      		            "            <div class=\"add_info\"><p>专业名称：</p><input type=\"text\" name=\"major\" id=\"major\" value=\""+updataObj.major+"\" readonly=\"readonly\"></div><br>\n" +
	      		            "            <div class=\"add_info\"><p>身份证号：</p><input type=\"text\" name=\"number\" id=\"number\" value=\""+updataObj.number+"\" readonly=\"readonly\"></div>\n" +
	      		            "            <input type=\"submit\" class=\"put\" value=\"修改\" name=\"put\" id=\"put\" onclick=\"return Updatacheck()\">\n" +
	      		            "            </form>\n" +
	      		            "        </div>\n" +
	      		            "        </div>\n" +
	      		            "    </div>");
	      		        //添加蒙版
	      		        $("body").append($mask);
	      		        //移除蒙版
	      		        $("body").delegate(".cancel>img","click",function () {
	      		            if(confirm("你确定要取消本次修改吗？")){
	      		                // 移除蒙版
	      		                $mask.remove();
	      		                return true;
	      		            }else{
	      		                return false;
	      		            }
	      		        }); 
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
    if(!(/['男'|'女']/.test(sex))){
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
    var birth = document.getElementById("birth").value;
    if(!(/^((?:19[2-9]\d{1})|(?:20(?:(?:0[0-9])|(?:1[0-9]))))\-((?:0?[1-9])|(?:1[0-2]))\-((?:0?[1-9])|(?:[1-2][0-9])|30|31)$/.test(birth))){
        document.getElementById("birth").focus();
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
    $.ajax({
    	url:"AddStudent2.0",
        type:"post",
        data:$("form").serializeArray(),
        success:function (data) {
            alert("添加成功");
        },
        error:function(wrong){
        	alert(wrong);
        }
    });
};

function Updatacheck() {
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
    if(!(/['男'|'女']/.test(sex))){
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
    var birth = document.getElementById("birth").value;
    if(!(/^((?:19[2-9]\d{1})|(?:20(?:(?:0[0-9])|(?:1[0-9]))))\-((?:0?[1-9])|(?:1[0-2]))\-((?:0?[1-9])|(?:[1-2][0-9])|30|31)$/.test(birth))){
        document.getElementById("birth").focus();
        alert("出生日期错误！");
        return false;
    }
    $.ajax({
    	url:"UpdataBaseStudent",//传送地址
    	type:"post",
    	data:$("form").serializeArray(),
    	/*dataType:"json",*/
    	success:function(data){
    		var obj = JSON.parse(data);
    		alert(obj.win);
    	},
    	error:function(wrong){
    		alert("修改失败!");
    	}
    });
};