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
    <script src="/js/tinymce/tinymce.min.js"></script>
    <script>tinymce.init({selector:'textarea'});</script>
</head>
<body>

<%@include file="taskNavbar.jsp"%>

<div class = "container-fluid" style="background-color: #fcba03; min-height: 660px">
    <div class = "row">
        <div class = "col-6 mx-auto">
            <form action = "/addcharacter" method = "post">
                <div class = "mt-2">
                    <label> Name: </label>
                    <input type = "text" class = "form-control mt-2" required name = "name">
                </div>
                <div class = "mt-2">
                    <label> Anime: </label>
                    <input type = "text" class = "form-control mt-2" required name = "anime">
                </div>
                <div class = "mt-2">
                    <label> Skills: </label>
                    <input type = "text" class = "form-control mt-2" required name = "skills">
                </div>
                <div class = "mt-2">
                    <label> Biography: </label>
                    <textarea name = "biography"></textarea>
                </div>
                <div class = "mt-2">
                    <label> Picture (write url to picture): </label>
                    <textarea name = "picture"></textarea>
                </div>
                <div class = "mt-2">
                    <button class = "btn btn-success"> Add Character </button>
                </div>
            </form>
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
