<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: OLX</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - OLX</h1>
                <h3>Znaleziono wpisów: ${beers.size()}</h3>
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
                <%--todo - pewnie klasy jobOffer trzeba podmienic --%>
                <tbody>
                    <c:forEach var="olxOffer" items="${olxOffers}">
                        <tr>
                            <td>${olxOffer.jobOffer.dateAdded}</td>
                            <td>${olxOffer.jobOffer.tittle}</td>
                            <td>${olxOffer.jobOffer.position}</td>
                            <td>${olxOffer.jobOffer.workplace}</td>
                            <td>${olxOffer.jobOffer.province}</td>
                            <td>${olxOffer.jobOffer.branch}</td>
                            <td>${olxOffer.jobOffer.dataSearch}</td>
                            <td>${olxOffer.jobOffer.description}</td>
                            <td>${olxOffer.jobOffer.url}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

