<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <title>Raport główny</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container-fluid mainContainer">
                <h1>JobOfferHunter raportuje</h1>
                <h3>Znaleziono wpisów: ${jobOffers.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data dodania</th>
                        <th>Portal</th>
                        <th>Tytuł ogłoszenia</th>
                        <th>Stanowisko</th>
                        <th>Miejsce pracy</th>
                        <th>Województwo</th>
                        <th>Branża</th>
                        <th>Data pobrania</th>
                        <th>Treść ogłoszenia</th>
                        <th>Adres URL</th>
                        <th>Opcje</th>
                    </tr>
                </thead>

                <%--todo - do zmian!--%>
                <tbody>
                    <c:forEach var="offer" items="${jobOffers}">
                        <tr>
                            <td>${offer.jobOffer.dateAdded}</td>
                            <td>${offer.jobOffer.webPage}</td>
                            <td>${offer.jobOffer.tittle}</td>
                            <td>${offer.jobOffer.position}</td>
                            <td>${offer.jobOffer.workplace}</td>
                            <td>${offer.jobOffer.province}</td>
                            <td>${offer.jobOffer.branch}</td>
                            <td>${offer.jobOffer.dataSearch}</td>
                            <td>${offer.jobOffer.description}</td>
                            <td>${offer.jobOffer.url}</td>
                            <td>Opcje</td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

