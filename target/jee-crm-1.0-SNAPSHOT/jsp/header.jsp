<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 25.05.19
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="pl" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>CRM</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/da6d9e6874.js"></script>
    <script src="https://unpkg.com/ionicons@4.2.2/dist/ionicons.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css"/>
</head>
<body class="d-flex flex-column h-100">
<header class="header-panel" style="margin-top: 80px;">
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="${pageContext.request.contextPath}">
            <div class="container">
                <i class="fas fa-warehouse fa-2x">CRM</i>
            </div>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item <c:if test="${empty cat}">active</c:if>">
                    <a class="nav-link" href="${pageContext.request.contextPath}"><i class="fas fa-home"></i> Strona
                        glowna<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle <c:if test="${cat == 'customer'}">active</c:if>" href="#"
                       id="navbarDropdownMenuLink1" role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <ion-icon name="contacts"></ion-icon>
                        Klienci
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink1">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/customer/listOfCustomers">Lista
                            klientów
                            <ion-icon name="list-box"></ion-icon>
                        </a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/customer/addCustomer">Dodaj
                            klienta
                            <ion-icon name="person-add"></ion-icon>
                        </a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/customer/customerVehicle">Pojazdy
                            klienta
                            <ion-icon name="logo-model-s"></ion-icon>
                        </a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/customer/customerOrder">Zlecenia
                            klienta
                            <ion-icon name="call"></ion-icon>
                        </a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle <c:if test="${cat == 'vehicle'}">active</c:if>" href="#"
                       id="navbarDropdownMenuLink2" role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <ion-icon name="logo-model-s"></ion-icon>
                        Pojazdy
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink2">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/vehicle/listOfVehicles">Lista
                            pojazdów
                            <ion-icon name="list"></ion-icon>
                        </a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/vehicle/addVehicle">Dodaj
                            pojazd
                            <ion-icon name="add-circle"></ion-icon>
                        </a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle <c:if test="${cat == 'order'}">active</c:if>" href="#"
                       id="navbarDropdownMenuLink3" role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <ion-icon name="clipboard"></ion-icon>
                        Zlecenia
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink3">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/order/listOfOrders">Lista
                            zleceń
                            <ion-icon name="filing"></ion-icon>
                        </a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/order/addOrder">Dodaj
                            zlecenie
                            <ion-icon name="add"></ion-icon>
                        </a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle <c:if test="${cat == 'employee'}">active</c:if>" href="#"
                       id="navbarDropdownMenuLink4" role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <i class="fas fa-users"></i> Pracownicy
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink4">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/employee/listOfEmployees">Lista
                            pracowników
                            <ion-icon name="list-box"></ion-icon>
                        </a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/employee/addEmployee">Dodaj
                            pracownika
                            <ion-icon name="person-add"></ion-icon>
                        </a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/employee/employeeOrder">Zlecenia
                            pracownika
                            <ion-icon name="albums"></ion-icon>
                        </a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle <c:if test="${cat == 'statement'}">active</c:if>" href="#"
                       id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <ion-icon name="analytics"></ion-icon>
                        </ion-icon></i> Zestawienia
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath}/statement/statement?statement=StatementEmployeeHours&statementName=Liczba%20przepracowanych%20godzin%20przez%20pracownikow">Liczba
                            przepracowanych
                            godzin
                            <ion-icon name="watch"></ion-icon>
                        </a>
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath}/statement/statement?statement=StatementProfit&statementName=Zyski%20NETTO%20z%20dzialalnosci">Zysk
                            NETTO
                            <ion-icon name="aperture"></ion-icon>
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</header>