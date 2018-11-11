<%-- 
    Document   : Busca
    Created on : 23/09/2018, 11:21:01
    Author     : Rian Alves
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@include file="jspf/header.jspf" %>
<style type="text/css">
    .card {
        box-shadow: 0 4px 8px 0 rgba(1,0,0,0.2);
        transition: 0.3s;
        width: 30%;
        border-radius: 10px;
    }

    .card:hover {
        box-shadow: 0 8px 16px 0 rgba(1,0,0,0.2);
    }

    .container {
        padding: 2px 16px;
    }

    #imagemborda{

        border-radius:100px;
    }   



</style>
<title> Team Crowd - Busca</title>
</head>
<body>
    <%@include file="jspf/nav.jspf" %>
    <br/>

    <div class="container-fluid">

        <center><h4>Find collaborators for the formation of your time.</h4></center>
        <center><h6>You can enter the domain of your project and find people who can help you</h6></center>           
        <br/>

        <br/>
        <form action="FrontController?action=BuscarDominioPost" method="post">
            <div class="row">
                <div class="col">
                </div>
                <div class="col">
                    <input class="form-control form-control-sm" type="text" placeholder="Enter keyword here for your search" name="keyword"/> 
                    <br/>
                    <select class="form-control form-control-sm" name ="complexidade">
                        <option selected>Choose the Complexity of Your Project</option>
                        <option value= "5">Baixa</option> 
                        <option value= "10">Média</option>
                        <option value="15">Alta</option>
                    </select>
                </div>
                <div class="col">

                </div>
            </div>
            <br/>
            <div class="row">

                <div class="col"> 
                </div>
                <div class="col">
                    <center> <button type="submit" class="btn btn-success btn-sm">Search</button>
                        <button type="reset" class="btn btn-danger  btn-sm"/>Cancel</button> </center>
                    <br/>
                </div>
                <div class="col"> 
                </div>
            </div> 
            <div class = "row"> 
                <div class="col"> </div>
                <div class="col">
                    <br/>
                    <center><img src="imagens\crowedsource.jpg" alt="CrowdSourcing" align=center height="350" id="imagemborda"/></center>
                </div>
                <div class="col"> 
                </div>
            </div> 
        </form>
    </div>
    <%@include file="jspf/footer.jspf" %>
