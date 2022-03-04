<%@ page import="DB.User" %>
<%
    User userq = (User) session.getAttribute("CURRENT_USER");
%>
<nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: #436091;">
    <div class="container-fluid">
        <a class="navbar-brand" href="/homepage">Anime Fandom</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar float-end" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%
                if (userq != null) {
            %>
                <li class="nav-item ">
                    <a class="nav-link active" aria-current="page" href="/allcharacters">All Characters</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link active" aria-current="page" href="/addcharacter">Add Character</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link active" aria-current="page" href="/profile"><%=userq.getFull_name()%></a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link active" aria-current="page" href="/login">Sign out</a>
                </li>
            <%
                } else {
            %>
                <li class="nav-item ">
                    <a class="nav-link active" aria-current="page" href="/allcharacters">All Characters</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link active" aria-current="page" href="/login">Sign in</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>