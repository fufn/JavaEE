<%@ page import="DB.User" %>
<%@ page import="DB.Character" %><%--
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
<%
    User user = (User) session.getAttribute("CURRENT_USER");
%>
<%@include file="taskNavbar.jsp"%>

<div class = "container-fluid" style="background-color: #fcba03; min-height: 660px">
    <div class = "row">
        <div class = "col-6 mx-auto">
            <%
                Character character = (Character) request.getAttribute("character");
                if (character != null) {
            %>
            <%
                if (character.getUser().getId() == user.getId()) {
            %>
            <%
                if (request.getParameter("success")!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Character successfully updated!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
                <input type = "hidden" value="<%=character.getId()%>" name = "id" form="form">
                <div class = "mt-2">
                    <label> Name: </label>
                    <input type = "text" class = "form-control mt-2" form="form"  required name = "name" value="<%=character.getName()%>">
                </div>
                <div class = "mt-2">
                    <label> Anime: </label>
                    <input type = "text" class = "form-control mt-2" form="form" required name = "anime" value="<%=character.getAnime()%>">
                </div>
                <div class = "mt-2">
                    <label> Skills: </label>
                    <input type = "text" class = "form-control mt-2"   form="form" required name = "skills" value="<%=character.getSkills()%>">
                </div>
                <div class = "mt-2">
                    <label> Biography: </label>
                    <textarea name = "biography" form="form"><%=character.getBiography()%></textarea>
                </div>
                <div class = "mt-2">
                    <label> Picture (write url to picture): </label>
                    <textarea name = "picture" form="form"><%=character.getPicture()%> </textarea>
                </div>
                <div class = "mt-2" style="display: flex">
                    <form action = "/editcharacter" method = "post" id = "form">
                    <button class = "btn btn-success" style="height: 40px"> Save Character </button>
                    </form>
                    <button class = "btn btn-danger" data-toggle="modal" data-target="#myModal" style="height: 40px">DELETE</button>
                    <div id = "myModal" class="modal" tabindex="-1" role="dialog">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Confirm delete</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <span>Are you sure? </span> <br>
                                </div>
                                <div class="modal-footer">
                                    <form action = "/deletecharacter" method="post">
                                        <input type = "hidden" name = "id" value="<%=character.getId()%>">
                                        <button class="btn btn-success">Yes</button>
                                    </form>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            <%
                }
            %>
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
