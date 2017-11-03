<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: posiłki</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        <jsp:include page="favicon.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - posiłki</h1>
                <h3>Znaleziono wpisów: ${meals.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Liczba osób</th>
                        <th>Wiek</th>
                        <th>Firma</th>
                        <th>Godzina</th>
                        <th>Posiłek</th>
                        <th>Miejsce</th>
                        <th>Akcja</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="meal" items="${meals}"> 
                        <tr>
                            <td>${meal.date}</td>
                            <td>${meal.trip.group.adultsNo} + ${meal.trip.group.childrenNo} + ${meal.trip.group.staffNo}</td>
                            <td>${meal.trip.group.age}</td>
                            <td>${meal.trip.company.name}</td>
                            <td>${meal.hour}</td>
                            <td>${meal.mealType}</td>
                            <td>${meal.place}</td>
                            <td>Usuń Edytuj Oferta i rozliczenia</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>

    </body>

</html>

