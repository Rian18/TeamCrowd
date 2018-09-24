<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

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
<title>Administração de Contato</title>
</head>
<body>
    <%@include file="jspf/nav.jspf" %>
    <div class="row">
        <div class = "col"></div>
        <div class = "col"><center><h1>Team Crowd</h1></center><br/>
            <center><img src="imagens\crowedsource.jpg" id="imagemborda" alt="CrowdSourcing" align=center height="150"/></center></div>
        <div class = "col"></div>
    </div>
    <div class="row">
        <div class = "col"></div>
        <div class = "col">
            <p align="justify">Esta aplicação visa a utilização de Repositórios de Software Open Source para a Formação de Grupos. Minerando os Dados do GitHub,
                busca-se nas multidões pessoas capazes de colaborarem no Projeto do usuário solicitante. Para isso, o usuário solicitante insere 
                uma "string" ou palavra-chave, pertinente ao domínio do projeto em questão, para a realização da busca. O software minera nos
                repositórios públicos do GitHub e retorna os contribuidores dos repositórios que apresentam em seu título ou descrição o que foi pesquisado.
                A partir disso, o software seleciona os colaboradores que poderão formar uma boa equipe para o desenvolvimeto do usuário solicitante. 
                Assim, o software busca ser uma ferramenta que auxilia no recrutamento de newcommers, formação de grupos e também no Desenvolvimento Distribuído de Software.
            </p>
        </div>
        <div class = "col"></div>


        <%@include file="jspf/footer.jspf" %>
