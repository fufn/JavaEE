<%@ page import="DB.User" %>
<%@ page import="DB.DBManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DB.Character" %>
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
        <%
            ArrayList<Character> characters = (ArrayList<Character>) request.getAttribute("characters");
            if (characters != null) {
                for (Character c: characters) {
        %>
            <div class = "col-4" >
                <div class = "container" style="background-color: #fffeba">
                    <h3>
                        <a href = "/readcharacter?id=<%=c.getId()%>"  style="text-decoration: none; color: black;">
                            <%=c.getName()%>
                        </a>
                    </h3>
                    <p>
                        <%=c.getPicture()%>
                    </p>
                    <p>
                        Posted by <b><%=c.getUser().getFull_name()%></b> at <b><%=c.getPostDate()%></b>
                    </p>
                    <p>
                        <span style="font-weight: bold"> <%=c.getLikes()%> </span> <%=(c.getLikes()==1?"like":"likes")%>
                    </p>
                </div>
            </div>
        <%
                }
            }
        %>
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
