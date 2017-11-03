<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Raport: Olbracht</title>
    <jsp:include page="stylesheets.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <h1>Raport - Rejs po Wiśle</h1>
    <h3>Znaleziono wpisów: ${cruises.size()}</h3>
    <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Data</th>
            <th>Liczba osób</th>
            <th>Wiek</th>
            <th>Firma</th>
            <th>Godzina</th>
            <th>Wanda</th>
            <th>Katarzynka</th>
            <th>Łodzie Flisacze</th>
            <th>Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cruise" items="${cruises}">
            <tr>
                <td>${cruise.date}</td>
                <td>${cruise.trip.group.adultsNo} + ${cruise.trip.group.childrenNo} + ${cruise.trip.group.staffNo}</td>
                <td>${cruise.trip.group.age}</td>
                <td>${cruise.trip.company.name}</td>
                <td>${cruise.hour}</td>
                <td>${cruise.wanda ? 'tak' : 'nie'}</td>
                <td>${cruise.katarzynka ? 'tak' : 'nie'}</td>
                <td>${cruise.lodzieFlisacze ? 'tak' : 'nie'}</td>
                <td>Usuń Edytuj Oferta i rozliczenia</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div> <!--  end of container-->
<jsp:include page="scriptLinks.jsp"></jsp:include>
</body>

</html>

