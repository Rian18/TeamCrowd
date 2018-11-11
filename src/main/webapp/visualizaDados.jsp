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
            colors: ['#191970', '#ADD8E6']
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
    }
    ;

</script>

<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawSeriesChart);

    function drawSeriesChart() {

      var data = new google.visualization.DataTable();
        data.addColumn('string', 'Contribuidores');
        data.addColumn('number', 'Commits');
        data.addColumn('number', 'Followers');
        data.addColumn('string', 'Region');
        $.each(dados, function (i, dados)
        {
            var nome = dados.nome;
            var commits = dados.contribuicao;
            var seguidores = dados.numseguidores;
            var local = dados.local;
            data.addRows([[nome, commits,seguidores,local]]);
        });
      var options = {
        title: 'Correlation between number of followers,  ' +
               'commits and location of contributors',
        hAxis: {title: 'Commits'},
        vAxis: {title: 'Number of Followers'},
        bubble: {textStyle: {fontSize: 11}}
      };

      var chart = new google.visualization.BubbleChart(document.getElementById('series_chart_div'));
      chart.draw(data, options);
    }
    </script>



  <script type="text/javascript">
      var dados = <%=request.getAttribute("colaboradoresJson")%>;
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawStuff);

      function drawStuff() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Contribuidores');
        data.addColumn('number', 'Commits');
        data.addColumn('number', 'Followers');
       
        $.each(dados, function (i, dados)
        {
            var nome = dados.nome;
            var commits = dados.contribuicao;
            var seguidores = dados.numseguidores;
            data.addRows([[nome, commits,seguidores]]);
        });

        var options = {
          width: 800,
          chart: {
            title: 'Commits and Followers',
            subtitle: 'data acquaintance'
          },
          bars: 'horizontal', // Required for Material Bar Charts.
          series: {
            0: { axis: 'Commits' }, // Bind series 0 to an axis named 'distance'.
            1: { axis: 'Followers' } // Bind series 1 to an axis named 'brightness'.
          },
          axes: {
            x: {
              distance: {label: 'parsecs'}, // Bottom x-axis.
              brightness: {side: 'top', label: 'apparent magnitude'} // Top x-axis.
            }
          }
        };

      var chart = new google.charts.Bar(document.getElementById('dual_x_div'));
      chart.draw(data, options);
    };
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
                            <td colspan="4">Suggested Collaborators for the Formation of a Group</td>
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
          


        </div>
         <div class = "row">
          <div class="col">
                <center><div id="dual_x_div" style="width: 700px; height:500px;"></div></center>
                
            </div>
             <div class="col">
                
                <center><div id="series_chart_div" style="width: 700px; height:500px;"></div></center>
            </div>
         </div>
        <div class = "row">
            <div class="col"> 
                <table class="table table-hover" >
                    <thead>
                        <tr class="table-primary">
                            <td colspan="4">Collaborators related to the Software Domain</td>

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
                            <td colspan="3">Repositories related to the domain</td>
                        </tr>
                        
                       
                    </thead>
                    <tbody>
                         <tr class="table-primary">
                            <th><center>Repository</center></th>
                            <th><center>Language</center></th>
                            <th><center><img src="imagens\star-icon.png" id="imagemborda" alt="Estrelas do Repositório" width="15" height="15"></center></th>

                        </tr>
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