<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: Planetarium</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - Planetarium</h1>
                <h3>Znaleziono wpisów: ${planets.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Liczba osób</th>
                        <th>Wiek</th>
                        <th>Firma</th>
                        <th>Godzina</th>
                        <th>Seans</th>
                        <th>Akcja</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="planetarium" items="${planets}"> 
                        <tr>
                            <td>${planetarium.date}</td>
                            <td>${planetarium.trip.group.adultsNo} + ${planetarium.trip.group.childrenNo} + ${planetarium.trip.group.staffNo}</td>
                            <td>${planetarium.trip.group.age}</td>
                            <td>${planetarium.trip.company.name}</td>
                            <td>${planetarium.hour}</td>
                            <td>${planetarium.seance}</td>
                            <td>Usuń Edytuj Oferta i rozliczenia</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>
</html>

