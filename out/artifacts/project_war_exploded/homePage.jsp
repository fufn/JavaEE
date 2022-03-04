<%@ page import="DB.User" %><%--
  Created by IntelliJ IDEA.
  User: fufn
  Date: 29.07.2021
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Anime Fandom</title>
    <link rel = "stylesheet" type = "text/css" href = "css/bootstrap.min.css">
</head>
<body>


<%@include file="taskNavbar.jsp"%>


<div class = "container-fluid" style="background-color: #fcba03; min-height: 660px">
    <div class = "row">
        <div class = "col-6">
            <img src= "picture1.jpg">
        </div>
        <div class = "col-6 mt-5">
            <div class = "container mt-5 pt-5">
                <div class = "row mt-5">
                    <div class = "col-12">
                        <p class="h1" style="font-family: 'Helvetica Neue'">WELCOME TO ANIME CLUB </p>
                    </div>
                </div>
                <div class = "row mt-5">
                    <div class = "col-12">
                        <p class="h3" style="font-family: 'Helvetica Neue'">JOIN US</p>
                    </div>
                </div>
                <div class = "row mt-5">
                    <div class = "col-8 mt-5">
                        <form action = "/signup" method = "get">
                            <button class = "btn btn-primary w-100" style = "border-radius: 50px">Sing up</button>
                        </form>
                    </div>
                </div>
                <div class = "row mt-2">
                    <div class = "col-8">
                        <form action = "/login" method="get">
                            <button class = "btn btn-primary w-100" style = "border-radius: 50px">Log in</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type = "text/javascript" src = "js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
</html>
