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

        <br>
        <h4 class="cover-heading">Lista Klientów </h4>
        <p>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Imię</th>
                <th scope="col">Nazwisko</th>
                <th scope="col">Data urodzenia</th>
                <th scope="col">E-mail</th>
                <th scope="col">Akcja</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${customers}" var="customer" varStatus="i">
                <tr>
                    <th scope="row">${i.index+1}</th>
                    <td>${customer.name}</td>
                    <td>${customer.surname}</td>
                    <td>${customer.birthDate}</td>
                    <td>${customer.email}</td>
                    <td>
                        <div class="btn-group" role="group" aria-label="First group">
                            <button type="button" class="btn btn-primary"
                                    onclick="window.location.href='${pageContext.request.contextPath}/customer/editCustomer?customerId=${customer.id}'">
                                Edytuj
                            </button>
                            <button type="button" class="btn btn-danger"
                                    onclick="location.href = '${pageContext.request.contextPath}/customer/deleteCustomer?customerId=${customer.id}'">
                                Usuń
                            </button>
                            <button type="button" class="btn btn-success"
                                    onclick="window.location.href='${pageContext.request.contextPath}/customer/customerOrder?customerId=${customer.id}'">
                                Zlecenia
                            </button>
                            <button type="button" class="btn btn-secondary"
                                    onclick="window.location.href='${pageContext.request.contextPath}/customer/customerVehicle?customerId=${customer.id}'">
                                Pojazdy
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    <button type="button" class="btn btn-primary"
                            onclick="window.location.href='${pageContext.request.contextPath}/customer/addCustomer'">
                        Dodaj nowego klienta
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
        </p>
    </div>


</main>
<jsp:include page="/jsp/footer.jsp"/>