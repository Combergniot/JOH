<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <title>Raport: zwiedzania</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container-fluid mainContainer">
                <h1>Raport - zwiedzania</h1>
                <h3>Znaleziono wpisów: ${seeings.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Liczba osób</th>
                        <th>Wiek</th>
                        <th>Firma</th>
                        <th>Godzina</th>
                        <th>Program</th>
                        <th>Przewodnik</th>
                        <th>Poczęstunek piernikami</th>
                        <th>Degustacja nalewek</th>
                        <th>Spotkanie z Kopernikiem</th>
                        <th>Obsługa</th>
                        <th>Status</th>
                    </tr>
                </thead>      
                <tbody>
                    <c:forEach var="seeing" items="${seeings}"> 
                        <tr>
                            <td>${seeing.date}</td>
                            <td>
                                Dzieci:  ${seeing.trip.group.childrenNo} <br>
                                Dorośli:  ${seeing.trip.group.adultsNo} <br>
                                Obsługa:  ${seeing.trip.group.staffNo} <br>

                            </td>
                            <td>${seeing.trip.group.age}</td>
                            <td>${seeing.trip.company.name}</td>
                            <td>${seeing.hour}</td>
                            <td>${seeing.name}</td>
<!--                            <td>${seeing.pilotage ? 'tak' : 'nie'}</td> -->
                            <td>         

                                <c:forEach var="guide" items="${seeing.guides}"> 
                                    ${guide.firstName} ${guide.lastName} <br>
                                </c:forEach>           
                            </td> 
                            <td>${seeing.gingerbread ? 'tak' : 'nie' }</td>
                            <td>${seeing.nalewki ? 'tak' : 'nie'}</td>
                            <td>${seeing.meetingWithCopernicus ? 'tak' : 'nie'}</td>
                            <td>namiar na pilota?</td>
                            <td>
                                <c:set var="advance" value="${seeing.trip.advance}"/>
                                <c:set var="confirmed" value="${seeing.trip.confirmed}"/>
                                <c:if test="${advance && confirmed}"><span class="label label-success">Potwierdzona i zapłacona</span></c:if>
                                <c:if test="${!advance && !confirmed}"><span class="label label-danger">Niepotwierdzona i niezapłacona</span></c:if>
                                <c:if test="${!advance && confirmed}"><span class="label label-warning">Potwierdzona i niezapłacona</span></c:if>
                                </td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

