<%--
  Created by IntelliJ IDEA.
  User: El-ra
  Date: 17/06/2019
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/_include/head.jsp"%>
    <style type="text/css">
        #bloc
        {
            margin: 20px;
            text-align: center;
        }

        em
        {
            color : white;
        }
        #barreDeRecherche
        {
            width: 100%;
            margin-top: 50px;
            height: 60px;
            padding-top: 10px;
            border: 1px gray solid;
            display: flex;
            justify-content: center;
        }
        #textCodeISBN,#textEditeur,#textTitre,#textEmail,#textNom,#textPrenom,#textPseudo
        {
            margin-left: 10px;
            margin-right: 10px;
        }
        #selectBibliotheque
        {
            margin-left: 10px;
            margin-right: 10px;
        }
        #btnRecherche
        {
            margin-left: 10px;
            margin-right: 10px;
        }
        #formulaire
        {
            width:70%;
        }
        #cadrePret
        {

        }
    </style>
</head>
<body>
<header>
    <%@ include file="/_include/header.jsp"%>
</header>
<div id="page">

    <div id="barreDeRecherche" class="bg-light">
        <s:form id="formulaire" action="recherchePret" >
            <div class="input-group">
                <div class="col-auto">
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text bg-light">Rechercher via</div>
                        </div>
                        <button id="btnAbonne" type="button" class="btn btn-outline-secondary">Abonnées</button>
                        <button id="btnLivre" type="button" class="btn btn-outline-secondary">Livres</button>
                    </div>
                </div>
                <input id="textTitre" name="titre" type="text" class="form-control" placeholder="Titre" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input id="textEditeur" name="auteur" type="text" class="form-control" placeholder="Auteur" aria-label="Recipient's username" aria-describedby="basic-addon2" >
                <input id="textCodeISBN" name="isbn" type="text" class="form-control" placeholder="Code ISBN" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input id="textEmail" name="email" type="text" class="form-control" placeholder="Email" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input id="textPseudo" name="pseudo" type="text" class="form-control" placeholder="Pseudo" aria-label="Recipient's username" aria-describedby="basic-addon2" >
                <input id="textNom" name="nom" type="text" class="form-control" placeholder="Nom" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input id="textPrenom" name="prenom" type="text" class="form-control" placeholder="Prénom" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <select id="selectBibliotheque" name="select" class="form-control col-5">
                        <option>Toutes les bibliothèques</option>
                        <option>Bibliothèque de la gare</option>
                        <option>Bibliotheque centre ville</option>
                        <option>Bibliotheque du port marchand</option>
                    </select>
                </div>
                <div>
                    <button type="submit" value="Rechercher" id="btnRecherche" class="btn btn-outline-secondary">Rechercher</button>
                </div>
            </div>
        </s:form>
    </div>
    <div id="cadrePret">
        <s:iterator value="pretList">
            <s:property value="dateEmprunt"/>
             <s:property value="dateRestitution"/>
            <s:property value="prolonge"/>
            <s:property value="abonne.pseudo"/>
            <s:property value="livre.titre"/>
        </s:iterator>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
    $(function() {

        $('#textEmail').hide();
        $('#textPseudo').hide();
        $('#textNom').hide();
        $('#textPrenom').hide();

        $("#btnAbonne").click(function() {
            $('#textEmail').show();
            $('#textPseudo').show();
            $('#textNom').show();
            $('#textPrenom').show();
            $('#textTitre').hide();
            $('#textEditeur').hide();
            $('#textCodeISBN').hide();
            $("input[id=textTitre]").val("");
            $("input[id=textEditeur]").val("");
            $("input[id=textCodeISBN]").val("");
        });
        $("#btnLivre").click(function() {
            $('#textEmail').hide();
            $('#textPseudo').hide();
            $('#textNom').hide();
            $('#textPrenom').hide();
            $('#textTitre').show();
            $('#textEditeur').show();
            $('#textCodeISBN').show();
            $("input[id=textEmail]").val("");
            $("input[id=textPseudo]").val("");
            $("input[id=textNom]").val("");
            $("input[id=textPrenom]").val("");
        });
    });
</script>
</body>
</html>
