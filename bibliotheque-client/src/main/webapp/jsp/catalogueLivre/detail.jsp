<%--
  Created by IntelliJ IDEA.
  User: El-ra
  Date: 28/06/2019
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <style type="text/css">
        #page {
            display: flex;
            justify-content: space-around;
        }
        em
        {
            color : white;
        }
        *
        {
            font-family: "Microsoft YaHei UI Light";
        }

        em
        {
            color : gray;
        }
        #cadrePret
        {
            margin-top: 50px;
            margin-bottom: 20px;
        }
        #bottom
        {
            display: flex;
            justify-content: space-around;
            width: 100%;
        }
        #labelRecherche
        {
            left: 10px;
            font-size: 1.5em;
            margin: 10px;
            font-weight: bold;
        }
        #cadreLivre
        {
            width: 100%;
            height: 435px;
            border: darkgray 1px solid;
        }


    </style>
</head>
<body>
<header>
    <%@ include file="../_include/header.jsp"%>
</header>

</div>

<div id="page">
    <div id="bottom" >
        <div id="cadrePret" class="col-9">
            <label class="form-check-label" id="labelRecherche"> Détails du livre </label>
            <div class="col-12 container bg-light" id="cadreLivre">
                <section class="row">
                <div  class="col-3" style="margin-top: 15px;text-align: center">
                <img  src="../image/<s:property value="illustration.url"/>" class="border border-secondary" style="height: 400px"
                     alt="<s:property value="illustration.description"/>">
                </div>
                <div class="col-5 border-left" style="margin-top: 20px;text-align: center">
                    <p style="text-align: center;font-size: 1.2em"><em>Informations sur le produit</em></p>
                    <p><em>Titre :  </em><s:property value="livre.titre"/></p>
                    <p><em>Auteur :  </em><s:property value="livre.auteur"/></p>
                    <p><em>Editeur :  </em><s:property value="livre.editeur"/></p>
                    <p><em>Catégorie :  </em><s:property value="categorie.nom"/></p>
                    <p><em>Langue :  </em><s:property value="livre.langue"/></p>
                    <p><em>Date de parution :  </em><s:property value="livre.dateDeCreation"/></p>
                    <p><em>ISBN-13 :  </em><s:property value="livre.isbn"/></p>
                </div>
                <div class="col-4 border-left" style="margin-top: 20px;">
                    <p style="text-align: center;font-size: 1.2em"><em>Résumé du livre</em></p>
                    <div class="border border-info" style="overflow:auto;height: 300px;padding: 10px;font-style: italic"><s:property value="livre.resume"/></div>
                </div>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>