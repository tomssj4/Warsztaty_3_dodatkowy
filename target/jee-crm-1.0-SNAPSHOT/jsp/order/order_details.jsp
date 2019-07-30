<%--Vehicle
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
    <div class="container">
        <div class="rounded border p-5">

            <h4 class="cover-heading">Szczegoly zlecenia</h4>

            <div class="form-row">
                <div class="form-group col-md-3">
                    <label for="status">Status zlecenia</label>
                    <div class="input-group" id="status">
                        <input readonly class="form-control" type="text" value="${order.statusStatus}">
                    </div>
                </div>
            </div>

            Klient
            <div class="form-row">
                <div class="form-group col-md-6">
                    <div class="input-group">
                        <input readonly type="text" class="form-control"
                               value="${order.customerName} ${order.customerSurname}">
                    </div>
                </div>
            </div>

            Samochód [marka/model / numer rejestracyjny]
            <div class="form-row">
                <div class="form-group col-md-6">
                    <div class="input-group">
                        <input readonly type="text" class="form-control"
                               value="${order.brand} ${order.model} ${order.plateNumber}">
                    </div>
                </div>
            </div>

            Data [dostarczenia / planowanej naprawy / rozpoczęcia naprawy]
            <div class="form-row">
                <div class="form-group col-md-6">
                    <div class="input-group">
                        <input readonly name="startServiceDate" type="date" class="form-control"
                               placeholder="Data dostarczenia" value="${order.startServiceDate}">
                        <input readonly name="plannedRepairDate" type="date" class="form-control"
                               placeholder="Data planowanej naprawy" value="${order.plannedRepairDate}">
                        <input readonly name="startRepairDate" type="date" class="form-control"
                               placeholder="Data rozpoczęcia naprawy" value="${order.startRepairDate}">
                    </div>
                </div>
            </div>

            Pracownik
            <div class="form-row">
                <div class="form-group col-md-6">
                    <div class="input-group">
                        <input readonly type="text" class="form-control"
                               value="${order.employeeName} ${order.employeeSurname}">
                    </div>
                </div>
            </div>

            Opis awarii
            <div class="form-row">
                <div class="form-group col-md-12">
                        <textarea readonly name="problemDescription" class="form-control"
                                  placeholder="Opis problemu / awarii" rows="3">${order.problemDescription}</textarea>
                </div>
            </div>

            Opis naprawy
            <div class="form-row">
                <div class="form-group col-md-12">
                        <textarea readonly name="repairDescription" class="form-control"
                                  placeholder="Opis problemu / awarii" rows="3">${order.repairDescription}</textarea>
                </div>
            </div>

            Koszt czesci / koszt roboczogodziny / liczba roboczogodzin
            <div class="form-row">
                <div class="form-group col-md-6">
                    <div class="input-group">
                        <input readonly type="text" name="costOfUsedParts" class="form-control"
                               placeholder="Koszt czesci" value="${order.costOfUsedParts}">
                        <input readonly type="text" name="manhourCost" class="form-control"
                               placeholder="Koszt roboczogodziny" value="${order.manhourCost}">
                        <input readonly name="numberOfManhour" type="text" class="form-control"
                               placeholder="Liczba roboczogodzin" value="${order.numberOfManhour}">
                    </div>
                </div>
            </div>

            <label for="costCustomer">Platnosc jaka ponosi klient</label>
            <div class="input-group" id="costRepairForClient">
                <input readonly name="costRepairForClient" type="text" class="form-control"
                       placeholder="Koszt dla klienta" id="costCustomer" value="${order.costRepairForClient}">
            </div>
        </div>
    </div>


    </div>
    </div>
</main>
<jsp:include page="/jsp/footer.jsp"/>
