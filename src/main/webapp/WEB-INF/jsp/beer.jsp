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
                <h1>Raport - Olbracht</h1>
                <h3>Znaleziono wpisów: ${beers.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Liczba osób</th>
                        <th>Wiek</th>
                        <th>Firma</th>
                        <th>Godzina</th>
                        <th>Przekąski</th>
                        <th>Zwiedzanie</th>
                        <th>Degustacja</th>
                        <th>Akcja</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="beer" items="${beers}">
                        <tr>
                            <td>${beer.date}</td>
                            <td>${beer.trip.group.adultsNo} + ${beer.trip.group.childrenNo} + ${beer.trip.group.staffNo}</td>
                            <td>${beer.trip.group.age}</td>
                            <td>${beer.trip.company.name}</td>
                            <td>${beer.hour}</td>
                            <td>${beer.snacks ? 'tak' : 'nie'}</td>
                            <td>${beer.sightseeing ? 'tak' : 'nie'}</td>
                            <td>${beer.tasting ? 'tak' : 'nie'}</td>
                            <td>Usuń Edytuj Oferta i rozliczenia</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

