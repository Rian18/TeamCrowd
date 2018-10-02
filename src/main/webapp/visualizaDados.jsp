<%-- 
    Document   : visualizaDados
    Created on : 23/09/2018, 23:54:08
    Author     : Rian Alves
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@include file="jspf/header.jspf" %>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
    td {border:none}



</style>
<script type="text/javascript">
    var dados = <%=request.getAttribute("colaboradoresJson")%>;
    google.charts.load("current", {packages: ["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {

        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Colaboradores');
        data.addColumn('number', 'Commits');
        $.each(dados, function (i, dados)
        {
            var nome = dados.nome;
            var commits = dados.contribuicao;
            data.addRows([[nome, commits]]);
        });
        var options = {
            title: 'Commits por Colaborador',
            is3D: true,
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
    }
    ;

</script>

<script type="text/javascript">
    var dados = <%=request.getAttribute("colaboradoresJson")%>;
    google.charts.load("current", {packages: ["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {

        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Colaboradores');
        data.addColumn('number', 'Seguidores');
        $.each(dados, function (i, dados)
        {
            var nome = dados.nome;
            var seguidores = dados.numseguidores;
            data.addRows([[nome, seguidores]]);
        });
        var options = {
            title: 'Quantidade de Seguidores por Colaborador',
            is3D: true,
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
        chart.draw(data, options);
    }
    ;

</script>
<title> Team Crowd - Visualização dos Dados</title>
</head>
<body>
    <%@include file="jspf/nav.jspf" %>
    <br/>

    <div class="container-fluid">
        <div class="row">

            <div class="col">  
                <table class="table table-hover" >
                    <thead>
                        <tr class="table-primary">
                            <td colspan="3">Colaboradores Sugeridos para a Formação de um Grupo</td>
                        </tr> 

                    </thead>
                    <tbody>
                        <c:forEach var="sugerido" items="${sugeridos}">
                            <tr>
                                <td><center><a href="${sugerido.url}" target="_blank">${sugerido.nome}</center></td> 
                        <td><center><a href="mailto:${sugerido.email}" target="_blank">${sugerido.email}</center></td> 
                        <td><center>${sugerido.local}</center></td> 
                        <td><center><img src="${sugerido.imagem_URL}" id="imagemborda" alt="imagem Usuário" width="32" height="32"></center></td> 

                        </tr>
                    </c:forEach>
                    </tbody>

                </table>

            </div>
            <div class="col">
                <center><div id="piechart" style="width: 500px; height:300px;"></div></center>
                <center><div id="piechart2" style="width: 500px; height:300px;"></div></center>
            </div>


        </div>
        <div class = "row">
            <div class="col"> 
                <table class="table table-hover" >
                    <thead>
                        <tr class="table-primary">
                            <td><center>Colaboradores relacionados ao Domínio</center></td>
                    <th><center></center></th>
                    <th><center></center></th>
                    <th><center></center></th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="colaborador" items="${colaboradores}">
                            <tr>
                                <td><center><a href="${colaborador.url}" target="_blank">${colaborador.nome}</center></td> 
                        <td><center><a href="mailto:${colaborador.email}" target="_blank">${colaborador.email}</center></td> 
                        <td><center>${colaborador.local}</center></td> 
                        <td><center><img src="${colaborador.imagem_URL}" id="imagemborda" alt="imagem Usuário" width="30" height="30"></center></td> 

                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
            <div class="col">

                <table class="table table-hover" >
                    <thead>
                        <tr class="table-primary">
                            <th><center>Repositórios relacionados ao domínio</center></th>
                    <th><center></center></th>
                    <th><center></center></th>

                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="repositorio" items="${repositorios}">
                            <tr>
                                <td><center><a href="${repositorio.url}" target="_blank">${repositorio.name}</center></td> 
                        <td><center>${repositorio.linguagem}</center></td> 
                        <td><center>${repositorio.numEstrelas}</center></td> 

                        </tr>
                    </c:forEach>
                    </tbody>

                </table>

            </div>
        </div>
        <br/>

    </div>
    <%@include file="jspf/footer.jspf" %>