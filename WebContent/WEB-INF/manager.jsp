<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理系统用户界面</title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<style type="text/css">
.tablex{
    border: 1px solid #ccc;border-collapse: collapse; text-align:center;
   }
.tablex tr,.tablex td{
    border: 1px solid #ccc;padding: 10px;
   }
   .page{
   margin-left:10px;
   margin-top:10px;
   }
</style>
</head>
<body>
<div id="usernamelogin"></div>
 <input id="mingcheng" placeholder="添加商品名称" />
<input id="danjia" placeholder="添加商品单价" />
<input id="shuliang" placeholder="添加你所需要的数量" />
<button id="tianjia" >添加</button>
<div id="sousuokuang">
<input id="ssmingcheng" placeholder="查询的商品名称" />
<button id="sousuo" >搜索</button>
 </div>
 <table  class="tablex">
   <tr id="test1">
       <td id="test">商品名称</td>
       <td>单价</td>
        <td>数量</td>
       <td>总额</td>
       <td>可点击删除</td>
   </tr>
   </table>
   <div id="pagebutton">
   
   </div>
</body>
<script>
    $(document).ready(function () {
        <%
        String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(username);
          %>
        var username = "<%=username %>"
        var count;
        var page;
        var pagecount = 5;
        $("#usernamelogin").html(username+",欢迎您");
        $("#sousuo").click(function () {
        });
        $.ajax({
            type: "POST",//请求类型
            url: "/Supermarket/Marketservlet",//请求的url
            data: {method: "product", "username": username, "pagecount": pagecount}, //请求参数
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {
                for (var i in data) {
                    if (i == 0) {
                        count = data[0].shuliang;
                    } else {
                        $(".tablex").append('<tr><td>' + data[i].mingchen + '</td><td>' + data[i].danjia + '</td><td>' + data[i].shuliang + '</td><td>' + data[i].zonge + '</td><td><button class="scbutton" style="border: 5px solid royalblue; ">删除</button></td></tr>');
                    }
                }

                page = Math.ceil(count / pagecount);

                for (var j = 1; j <= page; j++) {
                    $("#pagebutton").append('<button class="page">' + j + '</button>');
                }
            }
        });
        $("#pagebutton").on("click", ".page", function () {
            var pagevalue = $(this).html();
            $.ajax({
                type: "POST",//请求类型
                url: "/Supermarket/Marketservlet",//请求的url
                data: {method: "pageproduct", "username": username, "pagecount": 5, "pagevalue": pagevalue}, //请求参数
                dataType: "json",//ajax接口（请求url）返回的数据类型
                success: function (data) {
                    $(".tablex").empty();
                    $(".tablex").append('<tr id="test1"><td id="test">商品名称</td> <td>单价</td> <td>数量</td> <td>总额</td> <td>可点击删除</td> </tr>');
                    for (var i in data) {
                        $(".tablex").append('<tr><td>' + data[i].mingchen + '</td><td>' + data[i].danjia + '</td><td>' + data[i].shuliang + '</td><td>' + data[i].zonge + '</td><td><button class="scbutton" style="border: 5px solid royalblue; ">删除</button></td></tr>');

                    }
                }
            });
        });
        $("#tianjia").click(function () {
            var mingchen = $("#mingcheng").val();
            var danjia = $("#danjia").val();
            var shuliang = $("#shuliang").val();
            var zonge = danjia * shuliang;
            if (mingchen != "" && danjia != "" && shuliang != "") {
                $.ajax({
                    type: "POST",//请求类型
                    url: "/Supermarket/Marketservlet",//请求的url
                    data: {
                        method: "insert",
                        "username": username,
                        "mingchen": mingchen,
                        "danjia": danjia,
                        "shuliang": shuliang,
                        "zonge": zonge
                    }, //请求参数
                    dataType: "text",//ajax接口（请求url）返回的数据类型
                    success: function () {

                    }
                });
                $(".tablex").append('<tr><td>' + mingchen + '</td><td>' + danjia + '</td><td>' + shuliang + '</td><td>' + zonge + '</td><td><button class="scbutton" style="border: 5px solid royalblue; ">删除</button></td></tr>');
                $("#mingcheng").val('');
                $("#danjia").val('');
                $("#shuliang").val('');
            } else {
                alert("你所要添加的数据有空缺，请补充完整");
            }
        });

        $(".tablex").on("click", ".scbutton", function () {
            var mingchen = $(this).parent().parent().children()[0].innerHTML;
            $.ajax({
                type: "POST",//请求类型
                url: "/Supermarket/Marketservlet",//请求的url
                data: {method: "delete", "mingchen": mingchen}, //请求参数
                dataType: "text",//ajax接口（请求url）返回的数据类型
                success: function () {

                }
            });
            $(this).parent().parent().remove();
        })
        $("#sousuokuang").on("click", "#sousuo", function () {
            var length = 0;
            var ssmingcheng = $("#ssmingcheng").val();
            $.ajax({
                type: "POST",//请求类型
                url: "/Supermarket/Marketservlet",//请求的url
                data: {method: "sousuo", "username": username, "ssmingcheng": ssmingcheng}, //请求参数
                dataType: "json",//ajax接口（请求url）返回的数据类型
                success: function (data) {
                    for (var i in data) {
                        length++;
                    }
                    if (length != 0) {
                        $("tr").remove();
                        $("#pagebutton").remove();
                        for (var i in data) {
                            $(".tablex").append('<tr><td>' + data[i].mingchen + '</td><td>' + data[i].danjia + '</td><td>' + data[i].shuliang + '</td><td>' + data[i].zonge + '</td><td><button class="scbutton" style="border: 5px solid royalblue; ">删除</button></td></tr>');
                        }
                    }
                }
            });
        })
    });
</script>
</html>