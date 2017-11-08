<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: gratka.praca.pl</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - gratka.praca.pl</h1>
                <h3>Znaleziono wpisów: ${gratkaOffers.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data dodania</th>
                        <th>Tytuł ogłoszenia</th>
                        <th>Stanowisko</th>
                        <th>Miejsce pracy</th>
                        <th>Województwo</th>
                        <th>Branża</th>
                        <th>Data pobrania</th>
                        <th>Treść oferty</th>
                        <th>URL</th>
                    </tr>
                </thead>

                <%--todo--%>

                <tbody>
                    <c:forEach var="gratkaOffer" items="${gratkaOffers}">
                        <tr>
                            <td>${gratkaOffer.jobOffer.dateAdded}</td>
                            <td>${gratkaOffer.jobOffer.tittle}</td>
                            <td>${gratkaOffer.jobOffer.position}</td>
                            <td>${gratkaOffer.jobOffer.workplace}</td>
                            <td>${gratkaOffer.jobOffer.province}</td>
                            <td>${gratkaOffer.jobOffer.branch}</td>
                            <td>${gratkaOffer.jobOffer.dataSearch}</td>
                            <td>${gratkaOffer.jobOffer.description}</td>
                            <td>${gratkaOffer.jobOffer.url}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>
</html>

