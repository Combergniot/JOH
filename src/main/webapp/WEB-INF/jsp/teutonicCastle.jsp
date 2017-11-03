<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Raport: Zamek Krzyżacki</title>
    <jsp:include page="stylesheets.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container mainContainer">
    <h1>Raport - Zamek Krzyżacki</h1>
    <h3>Znaleziono wpisów: ${castle.size()}</h3>
    <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Data</th>
            <th>Liczba osób</th>
            <th>Wiek</th>
            <th>Firma</th>
            <th>Godzina</th>
            <th>Zwiedzanie</th>
            <th>Komturia</th>
            <th>Pokaz walk</th>
            <th>Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="teutonicCastle" items="${castle}">
            <tr>
                <td>${teutonicCastle.date}</td>
                <td>${teutonicCastle.trip.group.adultsNo} + ${teutonicCastle.trip.group.childrenNo}
                    + ${teutonicCastle.trip.group.staffNo}</td>
                <td>${teutonicCastle.trip.group.age}</td>
                <td>${teutonicCastle.trip.company.name}</td>
                <td>${teutonicCastle.hour}</td>
                <td>${teutonicCastle.sightseeing ? 'tak' : 'nie'}</td>
                <td>${teutonicCastle.komturia ? 'tak' : 'nie'}</td>
                <td>${teutonicCastle.fightShow ? 'tak' : 'nie'}</td>
                <td>Usuń Edytuj Oferta i rozliczenia</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div> <!--  end of container-->
<jsp:include page="scriptLinks.jsp"></jsp:include>
</body>
</html>

