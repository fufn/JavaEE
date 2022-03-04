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
<%
    User user = (User) request.getSession().getAttribute("CURRENT_USER");
%>

<%@include file="taskNavbar.jsp"%>

<div class = "container-fluid" style="background-color: #fcba03; min-height: 660px">
    <div class = "row" >
        <div class = "col-6 mx-auto" >
            <%
              if (request.getParameter("profileUpdated")!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Profile successfully updated!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                if (request.getParameter("profileUpdateError")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Profile is not updated!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                if (request.getParameter("notEqual")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Passwords are not equal!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                if (request.getParameter("oldPasswordError")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Old password is incorrect!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                if (request.getParameter("successPassword")!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Password is successfully updated!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                if (request.getParameter("updateError")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Password is not updated!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>

            <label class = "form-label mt-2">Email:</label>
            <input type="email" class = "form-control" name = "email" value="<%=user.getEmail()%>" disabled form = "form">
            <label class = "form-label mt-2">Full Name:</label>
            <input type="text" class = "form-control" name = "full_name" value="<%=user.getFull_name()%>" form = "form">
            <form action="/profile" method="post" id = "form">
                <button class = "btn-success mt-3 w-100" style="border-radius: 30px; height: 50px">UPDATE PROFILE</button>
            </form>

            <label class = "form-label mt-2">Old password:</label>
            <input type="password" class = "form-control" name = "old_password" form = "form2">
            <label class = "form-label mt-2">New password:</label>
            <input type="password" class = "form-control" name = "new_password" form = "form2">
            <label class = "form-label mt-2">Repeat new password:</label>
            <input type="password" class = "form-control" name = "re_new_password" form = "form2">
            <form action="/passwordupdate" method="post" id = "form2">
                <button class = "btn-success mt-3 w-100" style="border-radius: 30px; height: 50px">UPDATE PASSWORD</button>
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
