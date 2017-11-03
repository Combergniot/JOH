<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: zwiedzania</title>

        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.bootstrap4.min.css">
        <script
            src="https://code.jquery.com/jquery-2.2.4.js"
            integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>


        <style>



            .btn-secondary {
                margin-right:  7px;
            }



            body {
                /*                font-family: "Lato";*/

            }

            .container{
                width: 90%;
            }
        </style>



    </head>

    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container">


                <h1>Raport - zwiedzania</h1>
                <h3>Znaleziono wpsiów: ${seeings.size()}</h3>

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
                        <th>Akcja</th>
                    </tr>
                </thead>
                <tfoot>
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
                        <th>Akcja</th>
                    </tr>
                </tfoot>




                <tbody>
                    <c:forEach var="seeing" items="${seeings}"> 
                        <tr>
                            <td>${seeing.date}</td>
                            <td>${seeing.trip.group.adultsNo} + ${seeing.trip.group.childrenNo} + ${seeing.trip.group.staffNo}</td>
                            <td>wiek - dodać</td>
                            <td>${seeing.trip.company.name}</td>
                            <td>${seeing.hour}</td>
                            <td>${seeing.name}</td>
                            <td>${seeing.pilotage ? 'tak' : 'nie'}</td> 
                            <td>${seeing.gingerbread ? 'tak' : 'nie' }</td>
                            <td>${seeing.nalewki ? 'tak' : 'nie'}</td>
                            <td>${seeing.meetingWithCopernicus ? 'tak' : 'nie'}</td>
                            <td>namiar na pilota?</td>

                            <td>Usuń Edytuj Oferta i rozliczenia</td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td>xx</td>
                        <td>xx xx</td>
                        <td>xx</td>
                        <td>xx</td>
                        <td>xx</td>
                        <td>xx</td>
                        <td>xx</td>
                        <td>x x</td>
                        <td>x x</td>
                        <td>x</td>
                        <td>x x x</td>

                        <td>Usuń Edytuj</td>
                    </tr>
                </tbody>
            </table>

        </div> <!--  end of container-->


        <div class="zgloszenie_wrapper">
            <section id="header">
                <div id="copernicana_logo"></div>
                <div id="copernicana_address"></div>
            </section> <!--end of header-->
            
            <section id="headline">
                <div id="headline-title">Zgłoszenie nr... z dnia.....</div>
                <div id="headline-subtitle">Biuro Turystyczne COPERNICANA Anna Gajewska posiada wpis do rejestru Organizatorów Turystyki i Pośredników
Turystycznych Marszałka Województwa Kujawsko – Pomorskiego pod nr rej. 198 oraz gwarancję ubezpieczeniową
AXA Towarzystwo Ubezpieczeń i Reasekuracji S.A. o numerze 02.730.342. Biuro Turystyczne COPERNICANA Anna Gajewska podlega Turystycznemu Funduszowi Gwarancyjnemu.</div>
            </section> <!--end of headline-->
            

        </div> <!--end of zgloszenie wrapper-->














        <script>
            $(document).ready(function () {

                var table = $('#example').DataTable({
                    lengthChange: false,
                    dom: 'Bfrtip',
                    buttons: [
                        'copy', 'csv', 'excel', 'pdf', 'print'
                    ],
                    language: {
                        "processing": "Przetwarzanie...",
                        "search": "Szukaj:",
                        "lengthMenu": "Pokaż _MENU_ pozycji",
                        "info": "Pozycje od _START_ do _END_ z _TOTAL_ łącznie",
                        "infoEmpty": "Pozycji 0 z 0 dostępnych",
                        "infoFiltered": "(filtrowanie spośród _MAX_ dostępnych pozycji)",
                        "infoPostFix": "",
                        "loadingRecords": "Wczytywanie...",
                        "zeroRecords": "Nie znaleziono pasujących pozycji",
                        "emptyTable": "Brak danych",
                        "paginate": {
                            "first": "Pierwsza",
                            "previous": "Poprzednia",
                            "next": "Następna",
                            "last": "Ostatnia"
                        }


                    }
                }
                );

                table.buttons().container()
                        .appendTo('#example_wrapper .col-md-6:eq(0)');

                $('.dt-button').addClass('btn btn-secondary');



            });
        </script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/jq-2.2.4/dt-1.10.15/af-2.2.0/b-1.3.1/b-html5-1.3.1/b-print-1.3.1/r-2.1.1/se-1.2.2/datatables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap4.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.bootstrap4.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>
        <script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.colVis.min.js"></script>



        <!-- Latest compiled and minified JavaScript -->
        <!--        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>-->

    </body>

</html>

