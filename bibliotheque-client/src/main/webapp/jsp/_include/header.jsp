<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: El-ra
  Date: 17/06/2019
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-dark " style="background-color:rgba(0,0,0,0.7);">

    <s:a action="index" class="navbar-brand">Ma bibliothèque</s:a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <s:a action="catalogueLivre" class="nav-link" style="font-size:1.3em">| Livre |</s:a>
            </li>
            <li class="nav-item">
                <s:if test="#session.user">
                <s:a action="doListPret" class="nav-link" style="font-size:1.3em">| Mes prêts |</s:a>
                </s:if>
                <s:else>
                    <s:a action="login" class="nav-link" style="font-size:1.3em">| Mes prêts |</s:a>
                </s:else>
            </li>
            <li class="nav-item">
                <s:if test="#session.employe">
                    <s:a action="consulterPret" class="nav-link" style="font-size:1.3em">| Consulter les prêts |</s:a>
                </s:if>
            </li>
            <li class="nav-item">
                <s:if test="#session.employe">
                    <s:a action="ajouterPret" class="nav-link" style="font-size:1.3em">| Ajouter un prêt |</s:a>
                </s:if>
            </li>
            <li class="nav-item">
                <s:if test="#session.employe">
                    <s:a action="restituerPret" class="nav-link" style="font-size:1.3em">| Restituer un prêt |</s:a>
                </s:if>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" style="color: white" >
            <s:if test="#session.user">
                <em id="pseudo"><s:property value="#session.user.pseudo" /></em>
                <s:set var="pseudo" value="session.user.pseudo"/>
                <s:a action="logout" class="nav-link text-info">Deconnexion</s:a> /
                <s:a action="doProfil" class="nav-link text-info">Mon profil</s:a>
            </s:if>
            <s:else>
                <s:a action="login" style="color:lightgray" class="nav-link">Connexion</s:a> /
                <s:a action="formInscription" style="color:lightgray" class="nav-link">S'inscrire</s:a>
            </s:else>

        </form>
    </div>
</nav>
