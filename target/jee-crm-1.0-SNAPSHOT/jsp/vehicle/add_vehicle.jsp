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
        <%--        message from servlet--%>
        <c:if test="${msg!=null}">
            <br><br><br>
            <div class="alert alert-danger" role="alert">
                    ${msg}
            </div>
        </c:if>
        <br><br><br>

        <div class="rounded border p-5">

            <h4 class="cover-heading">Dodawanie nowego pojazdu</h4>
            <p>
            <form style="text-align: left" action="${pageContext.request.contextPath}/${cat}/addVehicle" method="post">
                <input type="hidden" value="${vehicle.id}" name="id">
                <input type="hidden" value="${orderId}" name="orderId">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="customerId">Klient</label>
                        <select id="customerId" class="custom-select" aria-label="Imie i nazwisko klienta"
                                name="customerId">
                            <c:forEach items="${listOfCustomers}" var="customer">
                                <option value="${customer.id}" name="customerId"
                                        <c:if test="${customer.id == vehicle.customerId}"> selected</c:if>
                                        <c:if test="${(customerId>0 && customer.id != vehicle.customerId)}"> disabled</c:if>
                                >${customer.name} ${customer.surname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="brand">Marka</label>
                        <input required type="text" class="form-control" placeholder="Marka" name="brand" id="brand"
                               value="${vehicle.brand}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="model">Model</label>
                        <input type="text" class="form-control" placeholder="Model" name="model" id="model"
                               value="${vehicle.model}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="plateNumber">Nr rejestracyjny</label>
                        <input required type="text" class="form-control" placeholder="Numer rejestracyjny"
                               name="plateNumber" id="plateNumber" value="${vehicle.plateNumber}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="productionYear">Rok produkcji</label>
                        <input type="text" pattern="[12][0-9]{3}-[0-9]{2}-[0-9]{2}" class="form-control"
                               placeholder="Rok produkcji" name="productionYear" id="productionYear"
                               value="${vehicle.productionYear}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="nextServiceDate">Data następnego przeglądu</label>
                        <input type="date" class="form-control" placeholder="Data następnego przeglądu"
                               name="nextServiceDate" id="nextServiceDate" value="${vehicle.nextServiceDate}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-primary">Dodaj pojazd</button>
                    </div>
                </div>
            </form>
        </div>
        </p>
    </div>
</main>
<jsp:include page="/jsp/footer.jsp"/>
