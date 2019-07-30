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
    <br>
    <div class="container">
        <%--        message from servlet--%>
        <c:if test="${msg!=null}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    ${msg}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <br>
        <h4 class="cover-heading">Zlecenia dla pojazdu </h4>
        <form action="${pageContext.request.contextPath}/vehicle/vehicleOrder" method="get">
            <div class="form-row">
                <div class="form-group col-md-8">
                    <select id="vehicleId" class="custom-select" onchange="this.form.submit()" name="vehicleId">
                        <option value="">Wszystkie pojazdy</option>
                        <c:forEach items="${vehicleList}" var="vehicle">
                            <option value="${vehicle.id}"
                                    <c:if test="${vehicle.id == vehicleId}">selected</c:if> >${vehicle.brand} ${vehicle.model} ${vehicle.plateNumber}</option>
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
                <th scope="col">Opis</th>
                <th scope="col">Pracownik</th>
                <th scope="col">Status</th>
                <th scope="col">Akcja</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${orders}" var="order" varStatus="i">
                <tr>
                    <th scope="row">${i.index+1}</th>
                    <td>${order.problemDescription}</td>
                    <td>${order.employeeName} ${order.employeeSurname}</td>
                    <td><c:forEach items="${statusList}" var="status"><c:if
                            test="${order.statusId == status.id}">${status.status}</c:if></c:forEach></td>
                    <td><a role="button" class="btn btn-primary"
                           href="${pageContext.request.contextPath}/vehicle/orderDetails?orderId=${order.id}">Szczegóły</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </p>
    </div>
</main>
<jsp:include page="/jsp/footer.jsp"/>
