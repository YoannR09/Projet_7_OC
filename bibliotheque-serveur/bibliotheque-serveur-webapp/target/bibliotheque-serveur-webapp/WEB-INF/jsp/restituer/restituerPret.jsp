<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: El-ra
  Date: 17/06/2019
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/_include/head.jsp"%>
    <style type="text/css">
        *
        {
            font-family: "Microsoft YaHei UI Light";
        }
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
            margin-left: 5px;
            margin-right: 5px;
        }
        #selectBibliotheque
        {
            margin-left: 10px;
            margin-right: 10px;
        }
        #btnRecherche
        {
            margin-right: 10px;
        }
        #cadrePret
        {
            margin-top: 50px;
        }
        #bottom
        {
            display: flex;
            justify-content: space-around;
        }
        #labelRecherche
        {
            float: left;
            font-size: 1.3em;
            margin: 10px;
            font-weight: bold;
        }
        #tableau
        {
            border: 1px gray solid;
        }
        tr,td
        {
            text-align: center;
        }

        #tdBtnRenouv,#tdBtnSuppr, #thBtnRenouv,#thBtnSuppr
        {
            border-left: 1px solid darkgray;
            border-right: 1px solid darkgray;
            background-color: whitesmoke;
        }
    </style>
</head>
<body>
<header>
    <%@ include file="/_include/header.jsp"%>
</header>
<div id="page">

    <div id="barreDeRecherche" class="bg-light">
        <s:form id="formulaire" action="rechercheRestituerLivre" >
            <div class="input-group">
                <input id="textNumInterne" name="numeroInterne" type="text" class="form-control" placeholder="Auteur" aria-label="Recipient's username" aria-describedby="basic-addon2" >
                <input id="textCodeISBN" name="isbn" type="text" class="form-control" placeholder="Code ISBN" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <select id="selectBibliotheque" name="bibliotheque" class="form-control ">
                        <option>Toutes les bibliothèques</option>
                        <option>Bibliotheque de la gare</option>
                        <option>Bibliotheque centre ville</option>
                        <option>Bibliotheque du port marchand</option>
                    </select>
                </div>
                <div>
                    <button type="submit" value="Rechercher" id="btnRecherche" class="btn btn-outline-info">Rechercher</button>
                </div>
            </div>
        </s:form>
    </div>
    <div id="bottom">
        <div id="cadrePret" class="col-9" >
            <label class="form-check-label" id="labelRecherche"> Ma recherche de livre disponible</label>
            <table class="table" id="tableau">
                <thead>
                <tr>
                    <th scope="col">ISBN</th>
                    <th scope="col">Numéro interne</th>
                    <th scope="col">Bibliothèque</th>
                    <th scope="col" id="thBtnRenouv">Réstituer</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="livreUniqueList">
                    <tr>
                        <td><s:property value="livre.isbn"/></td>
                        <td><s:property value="numeroInterne"/></td>
                        <td><s:property value="bibliotheque.nom"/></td>
                        <td id="tdBtnRenouv"><s:a action="" class="btn btn-info" style="font-size:0.6em;"><i class="fas fa-arrow-alt-circle-right"></i><s:param name="livreUniqueId" value="id"/></s:a></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
