<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 19.07.19
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsp/header.jsp"/>
<main role="main" class="flex-shrink-0">
    <div class="container">
        <br>
        <%--        message from servlet--%>

        <c:if test="${not empty param.msg}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    ${param.msg}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <h4 class="cover-heading">Lista Pojazdów </h4>
        <p>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Klient</th>
                <th scope="col">Marka</th>
                <th scope="col">Model</th>
                <th scope="col">Numer rejestracyjny</th>
                <th scope="col">Rok produkcji</th>
                <th scope="col">Data nastepnego przeglądu</th>
                <th scope="col">Akcja</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${vehicles}" var="vehicle" varStatus="i">
                <tr>
                    <th scope="row">${i.index+1}</th>
                    <td>${vehicle.customerId}</td>
                    <td>${vehicle.brand}</td>
                    <td>${vehicle.model}</td>
                    <td>${vehicle.plateNumber}</td>
                    <td>${vehicle.productionYear}</td>
                    <td>${vehicle.nextServiceDate}</td>
                    <td>
                        <div class="btn-group" role="group" aria-label="First group">
                            <button type="button" class="btn btn-primary"
                                    onclick="window.location.href='${pageContext.request.contextPath}/vehicle/editVehicle?vehicleId=${vehicle.id}'">
                                Edytuj
                            </button>
                            <button type="button" class="btn btn-danger"
                                    onclick="location.href='${pageContext.request.contextPath}/vehicle/deleteVehicle?vehicleId=${vehicle.id}'">
                                Usuń
                            </button>
                            <button type="button" class="btn btn-success"
                                    onclick="window.location.href='${pageContext.request.contextPath}/vehicle/vehicleOrder?vehicleId=${vehicle.id}'">
                                Zlecenia
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    <button type="button" class="btn btn-primary"
                            onclick="window.location.href='${pageContext.request.contextPath}/vehicle/addVehicle'">Dodaj
                        nowy pojazd
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
        </p>
    </div>


</main>
<jsp:include page="/jsp/footer.jsp"/>
