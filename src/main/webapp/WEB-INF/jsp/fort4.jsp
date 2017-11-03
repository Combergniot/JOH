<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: Fort IV</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - Fort IV</h1>
                <h3>Znaleziono wpisów: ${forts4.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Liczba osób</th>
                        <th>Wiek</th>
                        <th>Firma</th>
                        <th>Godzina</th>
                        <th>Pochodnie</th>
                        <th>Podchody</th>
                        <th>Ognisko</th>
                        <th>Kiełbaski</th>                     
                        <th>Akcja</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="fort4" items="${forts4}"> 
                        <tr>
                            <td>${fort4.date}</td>
                            <td>${fort4.trip.group.adultsNo} + ${fort4.trip.group.childrenNo} + ${fort4.trip.group.staffNo}</td>
                            <td>${fort4.trip.group.age}</td>
                            <td>${fort4.trip.company.name}</td>
                            <td>${fort4.hour}</td>
                            <td>${fort4.torches ? 'tak' : 'nie' }</td>
                            <td>${fort4.hareAndHounds ? 'tak' : 'nie' }</td>
                            <td>${fort4.bonfire ? 'tak' : 'nie' }</td>
                            <td>${fort4.kielbaski ? 'tak' : 'nie' }</td>                      
                            <td>Usuń Edytuj Oferta i rozliczenia</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

