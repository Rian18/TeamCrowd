<%-- 
    Document   : visualizaDados
    Created on : 23/09/2018, 23:54:08
    Author     : Rian Alves
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title> Team Crowd - Visualização dos Dados</title>
</head>
<body>
    <%@include file="jspf/nav.jspf" %>
    <br/>

    <div class="container-fluid">
        <div class="row">

    <div class="col">  
        <label for="origem" class="text-center font-weight-bold"> Todos os Colaboradores Encontrados </label>
        <select class="custom-select" size="15" id="origem">
            <c:forEach var="colaborador" items="${colaboradores}">
                <option value="${colaborador.nome}">${colaborador.email} ( ${colaborador.contribuicao} ) </option>

            </c:forEach>
        </select>

    </div>
    <div class="col btn-group-vertical">

        <button type="button" id="add" class="btn btn-primary" onclick="MoveListBoxItem('origem', 'destino', false)">Adicionar</button>
        <button type="button" id="addAll" class="btn btn-primary" onclick="MoveListBoxItem('origem', 'destino', true)">Adicionar Todos</button>
        <button type="button" id="remove" class="btn btn-danger" onclick="MoveListBoxItem('destino', 'origem', false)">Remover</button>
        <button type="button" id="removeAll" class="btn btn-danger" onclick="MoveListBoxItem('destino', 'origem', true)">Remover Todos</button>
    </div>
    <div class="col">  
        <form method="post">
             </form>
    </div>

</div>

<br/>
        
    </div>
     <%@include file="jspf/footer.jspf" %>