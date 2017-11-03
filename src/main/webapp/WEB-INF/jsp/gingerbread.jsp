<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: pierniki</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - pierniki</h1>
                <h3>Znaleziono wpisów: ${gingerbreads.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Liczba osób(dor-dzi-obsł)</th>
                        <th>Wiek</th>
                        <th>Firma</th>
                        <th>Godzina</th>                             
                        <th>Akcja</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="gingerbread" items="${gingerbreads}"> 
                        <tr>
                            <td>${gingerbread.date}</td>
                            <td>${gingerbread.trip.group.adultsNo} + ${gingerbread.trip.group.childrenNo} + ${gingerbread.trip.group.staffNo}</td>
                            <td>${gingerbread.trip.group.age}</td>
                            <td>${gingerbread.trip.company.name}</td>
                            <td>${gingerbread.hour}</td>                 
                            <td>Usuń Edytuj Oferta i rozliczenia</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

