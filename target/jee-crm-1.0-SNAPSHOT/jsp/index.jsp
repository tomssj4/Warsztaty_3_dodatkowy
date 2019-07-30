<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<main role="main" class="flex-shrink-0">
    <br>
    <div class="container">
        <h4 class="cover-heading">Aktualne zlecenia </h4>
        <p>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Marka</th>
                <th scope="col">Model</th>
                <th scope="col">Opis</th>
                <th scope="col">Pracownik</th>
                <th scope="col">Akcja</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${orders}" var="order" varStatus="i">
                <tr>
                    <th scope="row">${i.index+1}</th>
                    <td>${order.brand}</td>
                    <td>${order.model}</td>
                    <td>${order.problemDescription}</td>
                    <td>${order.employeeName} ${order.employeeSurname}</td>
                    <td><a role="button" class="btn btn-primary"
                           href="${pageContext.request.contextPath}/orderDetails?orderId=${order.id}">Szczegoly</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </p>
    </div>
</main>
<jsp:include page="footer.jsp"/>