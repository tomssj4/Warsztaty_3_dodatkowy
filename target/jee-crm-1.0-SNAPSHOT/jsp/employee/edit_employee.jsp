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

        <div class="rounded border p-5">

            <h4 class="cover-heading">Edycja danych pracownika</h4>
            <p>
            <form style="text-align: left" action="${pageContext.request.contextPath}/employee/editEmployee"
                  method="post">
                <input type="hidden" value="${employee.id}" name="id">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="name">Imię</label>
                        <input required type="text" class="form-control" placeholder="Imię pracownika" name="name"
                               id="name" value="${employee.name}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="surname">Nazwisko</label>
                        <input type="text" class="form-control" placeholder="Nazwisko pracownika" name="surname"
                               id="surname" value="${employee.surname}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-10">
                        <label for="address">Adres</label>
                        <input type="text" class="form-control" placeholder="Adres zamieszkania pracownika"
                               name="address" id="address" value="${employee.address}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="number">Telefon</label>
                        <input type="text" class="form-control" placeholder="Telefon pracownika" name="number"
                               id="number" value="${employee.number}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="manhourCost">Koszt roboczogodziny</label>
                        <input required type="number" class="form-control" placeholder="Koszt roboczogodziny pracownika"
                               name="manhourCost" id="manhourCost" value="${employee.manhourCost}">
                    </div>
                </div>

                Notatka
                <div class="form-group">
                    <textarea class="form-control" placeholder="Notatka dotycząca pracownika" rows="3" name="note"
                              id="note">${employee.note}</textarea>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-primary">Zapisz zmiany</button>
                    </div>
                </div>
            </form>
            </p>
        </div>
    </div>
</main>
<jsp:include page="/jsp/footer.jsp"/>