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
    <h1>Raport - Dodatkowe Atrakcje</h1>
    <h3>Znaleziono wpisów: ${additionalAttracions.size()}</h3>
    <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
        <thead>
        <tr>

            <%--Todo - trochę tych --%>
            <th>Data</th>
            <th>Liczba osób</th>
            <th>Wiek</th>
            <th>Firma</th>
            <th>Godzina</th>
            <th>Bunkier</th>
            <th>Dom Legend</th>
            <th>Katedra </th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="additionalAttraction" items="${additionalAttractions}">
            <tr>
                <td>${additionalAttraction.date}</td>
                <td>${additionalAttraction.trip.group.adultsNo} + ${additionalAttraction.trip.group.childrenNo}
                    + ${additionalAttraction.trip.group.staffNo}</td>
                <td>${additionalAttraction.trip.group.age}</td>
                <td>${additionalAttraction.trip.company.name}</td>
                <td>${additionalAttraction.hour}</td>
                <td>${additionalAttraction.bunkier ? 'tak' : 'nie'}</td>
                <td>${additionalAttraction.domLegend ? 'tak' : 'nie'}</td>
                <td>${additionalAttraction.katedra ? 'tak' : 'nie'}</td>
                <%--i tak dalej...--%>

                <td>Usuń Edytuj Oferta i rozliczenia</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div> <!--  end of container-->
<jsp:include page="scriptLinks.jsp"></jsp:include>
</body>

</html>

