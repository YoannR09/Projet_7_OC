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
    <%@ include file="../_include/head.jsp"%>
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
    <%@ include file="../_include/header.jsp"%>
</header>
<div id="page">
    <div id="bottom">
        <div id="cadrePret" class="col-9" >
            <label class="form-check-label" id="labelRecherche"> Mes prêts en cours</label>
            <table class="table" id="tableau">
                <thead>
                <tr>
                    <th scope="col">Titre du livre</th>
                    <th scope="col">ISBN</th>
                    <th scope="col">Numéro interne</th>
                    <th scope="col">Bibliothèque</th>
                    <th scope="col">Date d'emprunt</th>
                    <th scope="col">Date de réstitution</th>
                    <th scope="col" id="thBtnRenouv">Renouveler</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="pretList">
                    <tr>
                        <td><s:property value="livre.titre"/></td>
                        <td><s:property value="livre.isbn"/></td>
                        <td><s:property value="livreUnique.numeroInterne"/></td>
                        <td><s:property value="bibliotheque.nom"/></td>
                        <td><s:property value="dateEmprunt"/></td>
                        <td><s:property value="dateRestitution"/></td>
                        <s:if test="prolongation">
                            <td id="tdBtnRenouv"><button type="button" class="btn btn-info" style="font-size:0.6em;" disabled><i class="fas fa-redo-alt"></i></button></td>
                        </s:if>
                        <s:else>
                            <td id="tdBtnRenouv"><s:a action="prolongationPret" class="btn btn-info" style="font-size:0.6em;">
                                <s:param name="pretId" value="id" />
                                <i class="fas fa-redo-alt"></i></i></s:a></td>
                        </s:else>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
