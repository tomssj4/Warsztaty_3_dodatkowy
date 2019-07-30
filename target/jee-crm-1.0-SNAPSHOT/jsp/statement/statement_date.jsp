<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 19.07.19
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsp/header.jsp"/>
<main role="main" class="flex-shrink-0">
    <br>
    <br>
    <br>
    <div class="rounded border p-5">
        <h4 class="cover-heading">Zestawienie : ${statementName} </h4>
        <p>
        <form method="get" action="${pageContext.request.contextPath}/statement/statement">
            <input type="hidden" value="${statementName}" name="statementName">
            <input type="hidden" value="${statement}" name="statement">

            <div class="form-row">
                <div class="form-group col-md-3">
                    <label for="dateFrom">Data od </label>
                    <input name="dateFrom" type="date" class="form-control" placeholder="Data od" id="dateFrom">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-3">
                    <label for="dateTo">Data do </label>
                    <input name="dateTo" type="date" class="form-control" placeholder="Data do" id="dateTo"
                           value="${dateTo}">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <button type="submit" class="btn btn-primary" name="action" value="create">Przejdz dalej</button>
                </div>
            </div>
        </form>
    </div>

    </p>
    </div>
</main>
<jsp:include page="/jsp/footer.jsp"/>
