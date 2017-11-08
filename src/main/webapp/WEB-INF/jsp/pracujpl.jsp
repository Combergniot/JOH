<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: Pracuj.pl</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - Pracuj.pl</h1>
                <h3>Znaleziono wpisów: ${pracujPlOffers.size()}</h3>
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
                <tbody>
                    <c:forEach var="pracujPlOffer" items="${pracujPlOffers}">
                        <tr>
                            <td>${pracujPlOffer.jobOffer.dateAdded}</td>
                            <td>${pracujPlOffer.jobOffer.tittle}</td>
                            <td>${pracujPlOffer.jobOffer.position}</td>
                            <td>${pracujPlOffer.jobOffer.workplace}</td>
                            <td>${pracujPlOffer.jobOffer.province}</td>
                            <td>${pracujPlOffer.jobOffer.branch}</td>
                            <td>${pracujPlOffer.jobOffer.dataSearch}</td>
                            <td>${pracujPlOffer.jobOffer.description}</td>
                            <td>${pracujPlOffer.jobOffer.url}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

