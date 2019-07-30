<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 19.07.19
  Time: 13:33
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

            <h4 class="cover-heading">Dodawanie nowego zlecenia</h4>
            <p>
            <form style="text-align: left" method="post" action="${pageContext.request.contextPath}/order/addOrder">
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="status">Status zlecenia</label>
                        <div class="input-group" id="status">
                            <select name="statusId" class="custom-select" id="inputGroupSelect04"
                                    aria-label="Example select with button addon">
                                <c:forEach items="${statusList}" var="status">
                                    <option value="${status.id}"
                                            <c:if test="${status.id == order.statusId}">selected</c:if> >${status.status}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                Klient
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <div class="input-group">
                            <select name="customerId" id="clientSelect" class="custom-select"
                                    aria-label="Imie i nazwisko klienta" onchange="$(this).siblings('input').click()">
                                <option value="0"></option>
                                <c:forEach items="${customerList}" var="customer">
                                    <option value="${customer.id}"
                                            <c:if test="${customer.id == order.customerId}">selected</c:if> >${customer.name} ${customer.surname}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" name="action" value="customer" hidden>
                        </div>
                    </div>
                </div>
                Samochód [marka/model / numer rejestracyjny]
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <div class="input-group">
                            <select name="vehicleId" id="vehicleSelect" class="custom-select"
                                    aria-label="Marka i model pojazdu" onchange="$(this).siblings('input').click()">
                                <option value="0"></option>
                                <c:forEach items="${vehicleList}" var="vehicle">
                                    <option value="${vehicle.id}"
                                            <c:if test="${vehicle.id == order.repairedVehicleId}">selected</c:if> >${vehicle.brand} ${vehicle.model} ${vehicle.plateNumber}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" name="action" value="vehicle" hidden>
                        </div>
                    </div>
                </div>
                Data [dostarczenia / planowanej naprawy / rozpoczęcia naprawy]
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <div class="input-group">
                            <input name="startServiceDate" type="date" class="form-control"
                                   placeholder="Data dostarczenia" value="${order.startServiceDate}">
                            <input name="plannedRepairDate" type="date" class="form-control"
                                   placeholder="Data planowanej naprawy" value="${order.plannedRepairDate}">
                            <input name="startRepairDate" type="date" class="form-control"
                                   placeholder="Data rozpoczęcia naprawy" value="${order.startRepairDate}">
                        </div>
                    </div>
                </div>
                Pracownik
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <div class="input-group">
                            <select name="employeeId" id="employeeSelect" class="custom-select"
                                    onchange="$(this).siblings('input').click()">
                                <option value="0"></option>
                                <c:forEach items="${employeeList}" var="employee">
                                    <option value="${employee.id}"
                                            <c:if test="${employee.id == order.employeeId}">selected</c:if> >${employee.name} ${employee.surname}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" name="action" value="employee" hidden>
                        </div>
                    </div>
                </div>
                Opis awarii
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <textarea name="problemDescription" class="form-control" placeholder="Opis problemu / awarii"
                                  rows="3">${order.problemDescription}</textarea>
                    </div>
                </div>
                Opis naprawy
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <textarea name="repairDescription" class="form-control" placeholder="Opis naprawy"
                                  rows="3">${order.repairDescription}</textarea>
                    </div>
                </div>
                Koszt czesci / koszt roboczogodziny / liczba roboczogodzin
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <div class="input-group">
                            <input name="costOfUsedParts" type="text" class="form-control" placeholder="Koszt czesci"
                                   value="${order.costOfUsedParts}">
                            <input name="manhourCost" id="manhourCost" type="text" class="form-control"
                                   placeholder="Koszt roboczogodziny" value="${order.manhourCost}">
                            <input name="numberOfManhour" type="text" class="form-control"
                                   placeholder="Liczba roboczogodzin" value="${order.numberOfManhour}">
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="costRepairForClient">Platnosc jaka ponosi klient</label>
                        <input name="costRepairForClient" type="text" class="form-control"
                               placeholder="Koszt dla klienta" id="costRepairForClient"
                               value="${order.costRepairForClient}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-primary" name="action" value="create">Dodaj nowe zlecenie
                        </button>
                    </div>
                </div>
            </form>
            </p>
        </div>
    </div>
</main>
<jsp:include page="/jsp/footer.jsp"/>
