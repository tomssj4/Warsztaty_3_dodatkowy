<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 19.07.19
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsp/header.jsp"/>
<main role="main" class="flex-shrink-0">
    <div class="container">
        <%--        message from servlet--%>
        <c:if test="${msg!=null}">
        <br><br><br>
        <div class="alert alert-danger" role="alert">
                ${msg}
        </div>
        </c:if>
        <br><br><br>

        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Imie</th>
                <th scope="col">Nazwisko</th>
                <th scope="col">Adres</th>
                <th scope="col">Numer</th>
                <th scope="col">Notatka</th>
                <th scope="col">Koszt roboczogodziny</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${employees}" var="employee" varStatus="i">
                <tr>
                    <th scope="row">${i.index+1}</th>
                    <td>${employee.name}</td>
                    <td>${employee.surname}</td>
                    <td>${employee.address}</td>
                    <td>${employee.number}</td>
                    <td>${employee.note}</td>
                    <td>${employee.manhourCost}</td>
                    <td>
                        <div class="btn-group" role="group" aria-label="First group">
                            <button type="button" class="btn btn-primary"
                                    onclick="window.location.href='${pageContext.request.contextPath}/employee/editEmployee?employeeId=${employee.id}'">
                                Edytuj
                            </button>
                            <button type="button" class="btn btn-danger"
                                    onclick="location.href= '${pageContext.request.contextPath}/employee/deleteEmployee?employeeId=${employee.id}'">
                                Usuń
                            </button>
                            <button type="button" class="btn btn-success"
                                    onclick="window.location.href='${pageContext.request.contextPath}/employee/employeeOrder?employeeId=${employee.id}'">
                                Zlecenia
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    <button type="button" class="btn btn-primary"
                            onclick="window.location.href='${pageContext.request.contextPath}/employee/addEmployee'">
                        Dodaj nowego pracownika
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
</main>
<jsp:include page="/jsp/footer.jsp"/>