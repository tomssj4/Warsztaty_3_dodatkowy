<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 19.07.19
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsp/header.jsp"/>
<main role="main" class="flex-shrink-0">
    <br>
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

        <div class="form-row">
            <div class="form-group col-md-8">
                <h4 class="cover-heading">Aktualne zlecenia</h4>
            </div>
            <div class="form-group col-md-4" style="text-align: right">
                <button class="btn btn-primary" type="button"
                        onclick="window.location.href='${pageContext.request.contextPath}/order/addOrder'">Dodaj nowe
                    zlecenie
                </button>
            </div>
        </div>
        <p>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Marka</th>
                <th scope="col">Model</th>
                <th scope="col">Nr rejestracyjny</th>
                <th scope="col">Klient</th>
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
                    <td>${order.brand}</td>
                    <td>${order.model}</td>
                    <td>${order.plateNumber}</td>
                    <td>${order.customerName} ${order.customerSurname}</td>
                    <td>${order.problemDescription}</td>
                    <td>${order.employeeName} ${order.employeeSurname}</td>
                    <td>${order.statusStatus}</td>
                    <td>
                        <div class="btn-group" role="group" aria-label="First group">
                            <button type="button" class="btn btn-primary"
                                    onclick="window.location.href='${pageContext.request.contextPath}/order/editOrder?orderId=${order.id}'">
                                Edytuj
                            </button>
                            <button type="button" class="btn btn-danger"
                                    onclick="location.href='${pageContext.request.contextPath}/order/deleteOrder?orderId=${order.id}'">
                                Usuń
                            </button>
                            <button type="button" class="btn btn-success"
                                    onclick="window.location.href='${pageContext.request.contextPath}/order/orderDetails?orderId=${order.id}'">
                                Szczegóły
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </p>
    </div>
</main>
<jsp:include page="/jsp/footer.jsp"/>
