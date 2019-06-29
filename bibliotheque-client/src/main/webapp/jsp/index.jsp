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
    <%@ include file="./_include/head.jsp"%>
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
            color : white;
        }
        #cadrePret
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
        #cadreCategorie
        {
            width: 100%;
            height: 860px;
            border: darkgray 1px solid;
            text-align: center;
        }
        #cadreUnique
        {
            margin: 23px;
            height: 385px;
        }

        em
        {
            margin-left: auto;
            margin-right: auto;
            background-color: gray;
            color: white;
            padding: auto;
        }

        #cadreUnique:hover
        {
            background-color: gray;
        }

    </style>
</head>
<body>
<header>
    <%@ include file="./_include/header.jsp"%>
</header>

</div>

<div id="page">
    <div id="bottom" >
        <div id="cadrePret" class="col-9">
            <label class="form-check-label" id="labelRecherche"> Nos  catégories </label>
            <div class="col-12 container bg-light" id="cadreCategorie">
                <section class="row">
                    <s:iterator value="categorieList" status="list">
                        <div class="card col-2 text-white bg-dark" id="cadreUnique" style="padding-top: 10px">
                            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner" style="height: 100%">
                                    <s:if test="%{#list.count == 1}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre1.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre2.jpg" style="height: 300px"
                                                 alt="Second slide">
                                        </div>
                                    </s:if>
                                    <s:elseif test="%{#list.count == 2}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre3.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 3}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre4.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre5.jpg" style="height: 300px"
                                                 alt="Second slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 4}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre6.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 5}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre7.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 6}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre8.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 7}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre9.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre10.jpg" style="height: 300px"
                                                 alt="Second slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 8}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre11.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 9}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre12.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre13.jpg" style="height: 300px"
                                                 alt="Second slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre14.jpg" style="height: 300px"
                                                 alt="Third slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 10}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre15.jpg" style="height: 300px"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre16.jpg" style="height: 300px"
                                                 alt="Second slide">
                                        </div>
                                    </s:elseif>
                                </div>
                            </div>
                            <div class="card-footer">
                                <button type="button" class="btn btn-outline-info" style="font-size: 0.8em;font-weight: bold;width: 100%;height: 100%"><s:property value="nom"/></button>
                            </div>
                        </div>
                    </s:iterator>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>