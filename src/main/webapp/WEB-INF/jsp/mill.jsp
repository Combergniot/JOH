<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Raport: Młyny Wiedzy</title>
    <jsp:include page="stylesheets.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container mainContainer">
    <h1>Raport - Młyny Wiedzy</h1>
    <h3>Znaleziono wpisów: ${mills.size()}</h3>
    <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Data</th>
            <th>Liczba osób</th>
            <th>Wiek</th>
            <th>Firma</th>
            <th>Godzina</th>
            <th>Zwiedzanie</th>
            <th>Warsztaty</th>
            <th>Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mill" items="${mills}">
            <tr>
                <td>${mill.date}</td>
                <td>${mill.trip.group.adultsNo} + ${mill.trip.group.childrenNo}
                    + ${mill.trip.group.staffNo}</td>
                <td>${mill.trip.group.age}</td>
                <td>${mill.trip.company.name}</td>
                <td>${mill.hour}</td>
                <td>${mill.sightseeing ? 'tak' : 'nie'}</td>
                <td>${mill.workshops ? 'tak' : 'nie'}</td>
                <td>Usuń Edytuj Oferta i rozliczenia</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div> <!--  end of container-->
<jsp:include page="scriptLinks.jsp"></jsp:include>
</body>
</html>

