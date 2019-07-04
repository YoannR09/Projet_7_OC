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
        *
        {
            font-family: "Microsoft YaHei UI Light";
        }

        em
        {
            color : gray;
            text-align: left;
        }
        #cadreLogin
        {
            margin-top: 50px;
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
        #cadreLog
        {
            width: 100%;
            border: darkgray 1px solid;
        }
        label
        {
            text-align: right;
            margin-left: 15px;
            font-weight: 600;
        }
        #message
        {
            float: right;
            font-size: 1.1em;
            margin-top: 15px;
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
        <div id="cadreLogin" class="col-xl-5 col-lg-8 col-md-10 col-sm-10">
            <label class="form-check-label" id="labelRecherche"> Mon profil </label>
            <em id="message"><s:actionmessage/></em>
            <div class="col-12 container bg-light" id="cadreLog">
                <div class="col-12" style="text-align: center; margin: 10px" ><span> Informations</span></div>
                <div style="width: 100% ;display: flex;justify-content: space-around;">
                <div  style="padding: 10px;" class="col-10">
                    <p><em> Pseudo : </em> <label><s:property value="abonne.pseudo"/></label></p>
                    <p><em> Adresse électronique : </em> <label><s:property value="abonne.email"/></label> <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#popUpEmail" style="font-size:0.6em; margin-left: 15px">
                        Modifier
                    </button></p>
                    <p><em> Nom : </em> <label><s:property value="abonne.nom"/></label></p>
                    <p><em> Prénom : </em> <label><s:property value="abonne.prenom"/></label></p>
                    <p><em> Numéro de téléphone : </em> <label><s:property value="abonne.numeroTelephone"/></label></p>
                    <p><em> Bibliothèque favorite : </em> <label><s:property value="abonne.bibliotheque.nom"/></label> <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#popUpBibliotheque" style="font-size:0.6em;margin-left: 15px">
                        Modifier
                    </button></p>
                </div>
                </div>
                <div class="col-12" style="text-align: center;  margin: 10px" ><span class="label label-info">Adresse</span></div>
                <div  style="width: 100%;display: flex;justify-content: space-around">
                    <div style="padding: 10px;" class="col-10">
                    <p><em> Numero : </em> <label><s:property value="abonne.adresse.numero"/></label></p>
                    <p><em> Rue : </em> <label><s:property value="abonne.adresse.rue"/></label></p>
                    <p><em> Code postal : </em> <label><s:property value="abonne.adresse.codePostal"/></label></p>
                    <p><em> Ville : </em> <label><s:property value="abonne.adresse.ville"/></label></p>
                    <p><em> Pays : </em> <label><s:property value="abonne.adresse.pays"/></label></p>
                    </div>
                </div>
                <div style="display: flex;justify-content: space-around;padding: 20px;">
                    <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#popUpMdp" style="font-size:0.6em;">
                        Changer de mot de passe
                    </button>
                    <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#popUpAdresse" style="font-size:0.6em;">
                        Changer votre adresse
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- Modal -->
<div class="modal fade" id="popUpMdp" tabindex="-1" role="dialog" aria-labelledby="popUpMdp" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="popUpMdpTitle">Changer votre mot de passe</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <s:form action="doChangeMdp">
                    <div class="form-group" style="margin: 20px;">
                        <label for="inputMdp">Nouveau mot de passe</label>
                        <input name="newMdp" type="password" class="form-control" id="inputMdp" required>
                    </div>
                    <div class="form-group " style="margin: 20px">
                        <label for="inputMdpVerif">Confirmation du mot de passe</label>
                        <input name="newMdpVerif" type="password" class="form-control" id="inputMdpVerif" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-outline-info">Changer</button>
                    </div>
                </s:form>
            </div>

        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="popUpEmail" tabindex="-1" role="dialog" aria-labelledby="popUpEmail" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="popUpEmailTitle">Changer votre adresse électronique</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <s:form action="doChangeEmail">
                    <div class="form-group" style="margin: 20px;">
                        <label for="inputEmail">Nouvelle adresse électronique</label>
                        <input name="newEmail" type="text" class="form-control" id="inputEmail" required>
                    </div>
                    <div class="form-group " style="margin: 20px">
                        <label for="inputEmailVerif">Confirmation de l'adresse</label>
                        <input name="newEmailVerif" type="text" class="form-control" id="inputEmailVerif" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-outline-info">Changer</button>
                    </div>
                </s:form>
            </div>

        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="popUpAdresse" tabindex="-1" role="dialog" aria-labelledby="popUpAdresse" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="popUpAdresseTitle">Changer votre adresse</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <s:form action="doChangeAdresse">
                    <div class="form-group" style="margin: 20px;">
                        <label for="inputNumero">Numero</label>
                        <input name="numero" type="text" class="form-control" id="inputNumero" required value="<s:property value="abonne.adresse.numero"/>">
                    </div>
                    <div class="form-group" style="margin: 20px;">
                        <label for="inputRue">Rue</label>
                        <input name="rue" type="text" class="form-control" id="inputRue" required value="<s:property value="abonne.adresse.rue"/>">
                    </div>
                    <div class="form-group" style="margin: 20px;">
                        <label for="inputCodePostal">Code postal</label>
                        <input name="codePostal" type="text" class="form-control" id="inputCodePostal" required value="<s:property value="abonne.adresse.codePostal"/>">
                    </div>
                    <div class="form-group" style="margin: 20px;">
                        <label for="inputVille">Ville</label>
                        <input name="ville" type="text" class="form-control" id="inputVille" required value="<s:property value="abonne.adresse.ville"/>">
                    </div>
                    <div class="form-group" style="margin: 20px;">
                        <label for="inputPays">Pays</label>
                        <input name="pays" type="text" class="form-control" id="inputPays" required value="<s:property value="abonne.adresse.pays"/>">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-outline-info">Changer</button>
                    </div>
                </s:form>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="popUpBibliotheque" tabindex="-1" role="dialog" aria-labelledby="popUpBibliotheque" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="popUpBibliothequeTitle">Changer de bibliothèque favorite</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <s:form action="doChangeBibliotheque">
                    <div class="col-auto" style="margin: 7px" id="checkBibliotheque">
                        <div class="input-group" style="display:flex;">
                            <s:iterator value="bibliothequeList" status="list">
                                <div class="col-12">
                                    <input id="btnBibliotheque" class="form-check-input" type="radio" name="bibliotheque"  value="<s:property value="id"/>">
                                    <p><em> Nom : </em><span><s:property value="nom"/>    /  </span>
                                    <em>   Adresse : </em> <span><s:property value="adresse.numero"/> <s:property value="adresse.rue"/> <s:property value="adresse.codePostal"/>  <s:property value="adresse.ville"/></span></p>
                                </div>
                            </s:iterator>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-outline-info">Changer</button>
                    </div>
                </s:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>