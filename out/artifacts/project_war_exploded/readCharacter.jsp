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
</head>
<body onload = "loadComments()">
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
            <form action = "/editcharacter" method = "get">
                <input type = "hidden" value="<%=character.getId()%>" name = "id">
                <h3 class = "text-center">
                    <%=character.getName()%>
                </h3>
                <p>
                    <%=character.getPicture()%>
                </p>
                <p>
                    <strong>FROM:</strong> <%=character.getAnime()%>
                </p>
                <p>
                    <strong>SKILLS:</strong> <%=character.getSkills()%>
                </p>
                <p>
                    <strong>Biography:</strong> <br> <%=character.getBiography()%>
                </p>
                <p>
                    Posted by <b><%=character.getUser().getFull_name()%></b> at <b><%=character.getPostDate()%></b>
                </p>
                <p style = "font-size: 20px">
                    <%
                        if (user != null) {
                    %>
                    <a href = "JavaScript:void(0)" style = "text-decoration: none" onclick="toLike()"> &#10084; </a>
                    <script>
                        function toLike(){
                            $.post("/tolike", {
                                character_id: <%=character.getId()%>
                            }, function (result){
                                document.getElementById("like_amount").innerHTML = result;
                            });
                        }
                    </script>
                    <%
                        }
                    %>
                    <span style = "font-weight: bold" id = "like_amount"><%=character.getLikes()%></span> <%=(character.getLikes()==1?"like":"likes")%>
                </p>
                <%
                    if (user!= null && character.getUser().getId() == user.getId()) {
                %>
                <div class = "mt-2">
                    <button class = "btn btn-success"> Edit Character </button>
                </div>
                <%
                    }
                %>
            </form>
            <script type = "text/javascript">
                function loadComments(){
                    $.get("/readcomment", {
                        character_id: <%=character.getId()%>
                    }, function (result){
                        //alert(result);
                        commentList = JSON.parse(result);
                        htmlCode = "";

                        for (i=0; i < commentList.length; i++){
                            htmlCode += "<a href='JavaScript:void(0)' class='list-group-item list-group-item-action'>";
                            htmlCode += "<div class='d-flex w-100 justify-content-between'>";
                            htmlCode += "<h5 class='mb-1'>" + commentList[i].user.full_name + "</h5>";
                            if (<%=(user!=null?user.getId():-1)%>==commentList[i].user.id){
                                htmlCode += "<small onclick='deleteComment("+commentList[i].id+")'>&#x2715</small>";
                            }
                            htmlCode += "</div>";
                            htmlCode += "<p class='mb-1'>" + commentList[i].comment+ "</p>";
                            htmlCode += "<small>" + commentList[i].postDate + "</small>";
                            htmlCode += "</a>";
                        }

                        document.getElementById("div").innerHTML = htmlCode;

                    })
                }
            </script>
            <div class = "mt-5">
                <%
                    if (user != null) {
                %>
                <div>
                    <textarea class = "form-control" id = "comment_id" placeholder="Insert your comment here"></textarea>
                    <button class = "btn btn-success btn-sm mt-3" onclick="addComment()">Add comment</button>
                </div>
                <script type = "text/javascript">
                    function addComment(){
                        commentText = document.getElementById("comment_id");

                        $.post("/addcomment", {
                            comment: commentText.value,
                            character_id: <%=character.getId()%>
                        }, function (result){
                            commentText.value = "";
                            loadComments();
                        });

                    }
                    function deleteComment(id){
                        toDelete = confirm("Are your sure?");
                        if (toDelete){
                            $.post("/deletecomment",{
                                comment_id: id
                            }, function (result){
                                loadComments();
                            });
                        };
                    }
                </script>
                <%
                    } else {
                %>
                <div>
                    <h5>Please, <a href="/login">sign in</a> to comment.</h5>
                </div>
                <%
                    }
                %>
                <div class="list-group mt-3 mb-5" id = "div">

                </div>
            </div>
            <%
                }
            %>

        </div>
    </div>
</div>


</body>
<script type = "text/javascript" src = "/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
<script type = "text/javascript" src = "/js/jquery-3.6.0.min.js"></script>
</html>
