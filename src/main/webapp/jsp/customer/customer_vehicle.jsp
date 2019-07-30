<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 19.07.19
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsp/header.jsp"/>
<main role="main" class="flex-shrink-0">
    <br>
    <div class="container">
        <%--        message from servlet--%>
        <c:if test="${param.msg!=null}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    ${param.msg}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <h4 class="cover-heading">Pojazdy klienta </h4>
        <form action="${pageContext.request.contextPath}/customer/customerVehicle" method="get">
            <div class="form-row">
                <div class="form-group col-md-8">
                    <select id="customerId" class="custom-select" onchange="this.form.submit()" name="customerId">
                        <option value="">Wszyscy klienci</option>
                        <c:forEach items="${customerList}" var="customer">
                            <option value="${customer.id}"
                                    <c:if test="${customer.id == customerId}">selected</c:if> >${customer.name} ${customer.surname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </form>

        <p>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Marka</th>
                <th scope="col">Model</th>
                <th scope="col">Nr rejestracyjny</th>
                <th scope="col">Data produkcji</th>
                <th scope="col">Data nastepnej inspekcji</th>
                <th scope="col">Akcja</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${vehicles}" var="vehicle" varStatus="i">
                <tr>
                    <th scope="row">${i.index+1}</th>
                    <td>${vehicle.brand}</td>
                    <td>${vehicle.model}</td>
                    <td>${vehicle.plateNumber}</td>
                    <td>${vehicle.productionYear}</td>
                    <td>${vehicle.nextServiceDate}</td>
                    <td>
                        <div class="btn-group" role="group" aria-label="First group">
                            <button type="button" class="btn btn-primary"
                                    onclick="window.location.href='${pageContext.request.contextPath}/customer/editVehicle?vehicleId=${vehicle.id}&customerId=${vehicle.customerId}'">
                                Edytuj
                            </button>
                            <button type="button" class="btn btn-danger"
                                    onclick="location.href = '${pageContext.request.contextPath}/customer/deleteVehicle?vehicleId=${vehicle.id}&customerId=${vehicle.customerId}'">
                                Usuń
                            </button>
                            <button type="button" class="btn btn-success"
                                    onclick="window.location.href='${pageContext.request.contextPath}/customer/vehicleOrder?vehicleId=${vehicle.id}&customerId=${vehicle.customerId}'">
                                Zlecenia
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${vehicle.customerId!=null}">
                <tr>
                    <td colspan="7">
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href='${pageContext.request.contextPath}/customer/addVehicle?customerId=${vehicle.customerId}'">
                            Dodaj nowy pojazd
                        </button>
                    </td>

                </tr>
            </c:if>
            </tbody>
        </table>
        </p>
    </div>
</main>
<jsp:include page="/jsp/footer.jsp"/>
