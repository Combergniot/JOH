<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <title>Rejestracja grup</title>

        <jsp:include page="stylesheets.jsp"></jsp:include>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

            <link rel="stylesheet" href="resources/css/style.css">
            <link rel="stylesheet" href="resources/css/jquery-ui.css">
            <link rel="stylesheet" href="resources/css/chosen.css">
            <script src="resources/js/chosen.jquery.js"></script>
            <script src="resources/js/datapicker.js"></script>
            <script src="resources/js/menuAnimation.js"></script>
            <script src="resources/js/choosen.js"></script>
            <script src="resources/js/addGroup.js"></script>
            <script src="resources/js/addDinner.js"></script> 
            <script src="resources/js/giveCompanies.js"></script> 
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>

            <div class="container mainContainer">
                <h1>Dodaj zgłoszenie</h1>


                <div class="col-md-12 well">
                    <!--        Kontakt-->
                    <legend id="anch1">Data</legend>

                    <form class="form-horizontal" action="addTrip"  method="post" modelAttribute="downloadFileForm">

                        <!-- Kontakt: data wycieczki-->

                        <div class="form-group tripdates text-center">
                            <label class="col-md-1 control-label"> Od:</label>
                            <div class="col-md-5">
                                <input id="tripStartDate" name="tripStartDate" class="form-control input-md" type="date" required>
                            </div>
                            <label class="col-md-1 control-label"> Do:</label>
                            <div class="col-md-5">
                                <input id="tripEndDate" name="tripEndDate" class="form-control input-md" type="date" required>
                            </div>
                        </div>

                        <legend id="anch2">Kontakt</legend>
                        <!-- Kontakt: Firma-->
                        <div class="existing-company col-lg-6">

                            <div class="existing-company-select-wrapper">
                                <select name="company" class="chosen-select form-control"  id="mealsType" data-placeholder="Typ posiłku...">
                                    <option value="0"></option>
                                    <option value="1">Firma jeden</option>
                                    <option value="2">Firma dwa</option>
                                    <option value="3">Kolacja</option>
                                </select>
                            </div>



                        </div> <!--end of existing company-->

                        <div class="col-md-4 col-lg-6">
                            <button id="addCompanyButton" class="btn btn-primary">Dodaj firmę</button>
                        </div>
                        <div id="newCompanyFormWrapper" class="new-company col-md-4 col-lg-6">
                            <script>
                                $('#addCompanyButton').click(function (event) {
                                    event.preventDefault();
                                    $('#newCompanyFormWrapper').slideToggle();
                                    $('#addCompanyButton').slideToggle();
                                });

                            </script> 

                            <div class="form-group">
                                <label class="col-md-4 control-label">Firma</label>  
                                <div class="col-md-6">
                                    <input id="companyName" name="companyName" class="form-control input-md" placeholder="Wprowadź nazwę firmy" type="text" >
                                </div>
                            </div>

                            <!-- Kontakt: Imie i nazwisko-->
                            <div class="form-group">
                                <label class="col-md-4 control-label">Imię i nazwisko</label>  
                                <div class="col-md-6">
                                    <input name="firstNamelastName" class="form-control input-md" placeholder="Imię i nazwisko" type="text" >
                                </div>
                            </div>

                            <!-- Kontakt: telefon-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Telefon</label>  
                                <div class="col-md-6">
                                    <input name="phoneNo" class="form-control input-md" placeholder="Telefon" type="text" >
                                </div>
                            </div>

                            <!-- Kontakt: email-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">E-mail</label>  
                                <div class="col-md-6">
                                    <input name="e-mail" class="form-control input-md" placeholder="E-mail" type="text" >
                                </div>
                            </div>
                            <div class="col-md-10 text-center">
                                <div class="btn-group" role="group" aria-label="...">
                                    <button id="saveNewCompany" type="button" class="btn btn-success">Zapisz</button>
                                    <button id="closeNewCompanyForm" type="button" class="btn btn-danger">Zamknij</button>
                                </div>
                                <script>
                                    $('#saveNewCompany').click(function (event) {
                                        event.preventDefault();
                                        console.log('Saving new company');
                                        // post company data with ajax here
                                        $('#newCompanyFormWrapper').slideToggle();
                                        // display success message
                                        // update company selector
                                    });

                                    $('#closeNewCompanyForm').click(function (event) {
                                        event.preventDefault();
                                        $('#newCompanyFormWrapper').slideToggle();
                                        $('#addCompanyButton').slideToggle();
                                    });
                                </script>
                            </div>


                        </div> <!--end of new company-->

                        <!--    Grupa:    -->
                        <div>.</div>
                        <legend id="anchx" class="">Grupa</legend>

                        <div class="panel-body" id="group_fields">

                            <div class="pola-grupy">

                                <!--Grupa:Ile dzieci        -->
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <input name="childrenNr" type="text" class="form-control" id="ChildrenNr" placeholder="Ile dzieci?">
                                    </div>
                                </div>

                                <!--Grupa: Ilu dorosłych?        -->
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <input name="AdultsNr" type="text" class="form-control" id="AdultsNr" placeholder="Ilu dorosłych?">
                                    </div>
                                </div>

                                <!--Grupa: Obsługa        -->
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <input name="StaffNr" type="text" class="form-control" id="StaffNr" placeholder="Obsługa:">
                                    </div>
                                </div>

                                <!--Grupa: typ grupy-->
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <select name="groupType" class="chosen-select form-control" id="groupType" data-placeholder="Wybierz typ grupy">
                                                <option value="0" disabled selected>Typ grupy</option>
                                                <option value="szkolna">Grupa szkolna</option>
                                                <option value="dorosli">Dorośli</option>
                                                <option value="seniorzy">Seniorzy</option>
                                            </select>
                                            <div class="input-group-btn">
                                                <button class="btn btn-success" type="button" onclick="group_fields();"> 
                                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>  <!-- end of pole grupy-->


                        <!--    Wyżywienie            -->

                        <!--<div class="col-md-12"> -->
                        <legend id="anch3" class="">Wyżywienie</legend>    


                        <div class="panel-body" id="dinner_fields">

                            <div id="dinner-fields">

                                <div class="dinner-row">


                                    <!--Wyżywienie: typ posiłku    -->
                                    <div class="col-md-4">

                                        <select name="mealsType" class="chosen-select form-control"  id="mealsType" data-placeholder="Typ posiłku...">
                                            <option value="0"></option>
                                            <option value="śniadanie">Śniadanie</option>
                                            <option value="obiad">Obiad</option>
                                            <option value="kolacja">Kolacja</option>
                                        </select>

                                    </div> 

                                    <!-- Wyżywienie: termin   -->
                                    <div class="col-md-4">

                                        <div class="input-group registration-date-time">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
                                            <input name="feedDate" class="form-control" type="date">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
                                            <input name="feedHour" class="form-control" type="time">
                                        </div>
                                    </div> 


                                    <div class="col-md-4">
                                        <div class="input-group">
                                            <select name="feedingPlace" class="chosen-select form-control" id=restaurants data-placeholder="Wybierz miejsce...">
                                                <option value="0"></option>
                                                <option value="Chleb i wino">Chleb i wino</option>
                                                <option value="Ciasna">Ciasna</option>
                                                <option value="Ciżemka">Ciżemka</option>
                                                <option value="Fort IV">Fort IV</option>
                                                <option value="Gessler U Kucharzy">Gessler "U Kucharzy"</option>
                                                <option value="Gęsia Szyja">Gęsia Szyja</option>
                                                <option value="Jan Olbracht Browar Staromiejski">Jan Olbracht Browar Staromiejski</option>
                                                <option value="Jimmy's Steakhouse">Jimmy's Steakhouse</option>
                                                <option value="Karczma Spichrz">Karczma Spichrz</option>
                                                <option value="Kuranty">Kuranty</option>
                                                <option value="Luizjana">Luizjana</option>
                                                <option value="Manekin">Manekin</option>
                                                <option value="Metropolis">Metropolis</option>
                                                <option value="Mistrz i Małgorzata">Mistrz i Małgorzata</option>
                                                <option value="Oberża">Oberża</option>
                                                <option value="Odessa">Odessa</option>
                                                <option value="Osetia">Osetia</option>
                                                <option value="Piąta Klepka">Piąta Klepka</option>
                                                <option value="Prowansja">Prowansja</option>
                                                <option value="Pueblo">Pueblo</option>
                                                <option value="Róża i Zen">Róża i Zen</option>
                                                <option value="Sowa">Sowa</option>
                                                <option value="Staromiejska">Staromiejska</option>
                                                <option value="Szeroka No 9">Szeroka No 9</option>
                                            </select>
                                            <div class="input-group-btn">
                                                <button class="btn btn-success" type="button"  onclick="dinner_fields();"> <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> </button>         
                                            </div>

                                        </div>

                                    </div> 
                                </div>
                                <!--</div>-->
                            </div> <!--    end of dinner-row-->


                        </div> <!--    end of dinner-fields-->

                        <!-- Nocleg              -->

                        <legend id="anch4" class="">Nocleg</legend>
                        <div class="form-horizontal">


                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label">Termin</label>
                                <div class="col-md-2">
                                    <input name="acomDateStart" class="form-control input-md" type="date">
                                </div>
                                <div class="col-md-2">
                                    <input name="acomDateEnd" class="form-control input-md" type="date">
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Hotel</label>  
                                <div class="col-md-4">
                                    <select name="acomHotel" class="chosen-select form-control" id="hotels" data-placeholder="Wybierz...">
                                        <option value="0"></option>
                                        <option value="1">1231</option>
                                        <option value="2">Akropol</option>
                                        <option value="3">Ambasada</option>
                                        <option value="4">Ange Hostel</option>
                                        <option value="5">Atena</option>
                                        <option value="6">Barbarka</option>
                                        <option value="7">B&amp;B</option>
                                        <option value="8">Bulwar</option>
                                        <option value="9">Camping Tramp</option>
                                        <option value="10">Copernicus</option>
                                        <option value="11">Czarna Róża</option>
                                        <option value="12">Daglezja</option>
                                        <option value="13">Dom Pielgrzyma</option>
                                        <option value="14">Dwa Księżyce</option>
                                        <option value="15">Filmar</option>
                                        <option value="16">Fort IV</option>
                                        <option value="17">Freedom</option>
                                        <option value="18">Gościniec Silver</option>
                                        <option value="19">Gotyk</option>
                                        <option value="20">Green Hostel</option>
                                        <option value="21">Gromada</option>
                                        <option value="22">Heban</option>
                                        <option value="23">Hotelik w centrum</option>
                                        <option value="24">Ibis</option>
                                        <option value="25">Imbir</option>
                                        <option value="26">jaPierniczę</option>
                                        <option value="27">Kopernik</option>
                                        <option value="28">MCSM</option>
                                        <option value="29">Mercure</option>
                                        <option value="30">Miłosz</option>
                                        <option value="31">Nicolaus</option>
                                        <option value="32">Olender</option>
                                        <option value="33">Orange</option>
                                        <option value="34">Pałac Romantyczny</option>
                                        <option value="35">Petite Fleur</option>
                                        <option value="36">Pod Orłem</option>
                                        <option value="37">Polonia</option>
                                        <option value="38">Przystanek</option>
                                        <option value="39">Reflex</option>
                                        <option value="40">Retman</option>
                                        <option value="41">Rubbens&amp;Monet</option>
                                        <option value="42">Solaris</option>
                                        <option value="43">Spichrz</option>
                                        <option value="44">Toruń Główny</option>
                                    </select>
                                </div>
                            </div> 

                            <!-- Text area-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textarea">Uwagi</label>  
                                <div class="col-md-4">
                                    <textarea name="acomRemarks" class="form-control" id="textarea" class="form-control input-md"></textarea>
                                </div>
                            </div> 


                        </div>


                        <legend id="anch5" class="">Usługi przewodnickie i pilockie</legend>
                        <div class=row>

                            <div class="col-md-2">

                                <select name="tourType" class="chosen-select form-control"  id="tourType" data-placeholder="Program...">
                                    <option value="0"></option>
                                    <option value="1">Zwiedzanie tradycyjne</option>
                                    <option value="2">Toruń Frywolny</option>
                                </select>
                            </div>



                            <div class="col-md-4">

                                <div class="input-group registration-date-time">
                                    <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
                                    <input class="form-control" name="attractionDate" id="registration-date" type="date">
                                    <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
                                    <input class="form-control" name="attractionTime" id="registration-time" type="time">
                                    <!--
                                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
                                        <input class="form-control" name="registration_time" id="registration-time" type="time">
                                    -->
                                </div> 

                            </div>

                            <div class="col-md-3">

                                <select name="pilotName" multiple class="chosen-select form-control" id="guides" data-placeholder="Przewodnik...">
                                    <option value="0"></option>
                                    <option value="1">Asmolkova Tatiana</option>
                                    <option value="2">Białkowski Łukasz</option>
                                    <option value="3">Brewka Kasia</option>
                                    <option value="4">Budzichowska Małgorzata</option>
                                    <option value="5">Bukowski Paweł</option>
                                    <option value="6">Brzeziński Artur</option>
                                    <option value="7">Dąbrowska Paulina</option>
                                    <option value="8">Dzianisława Wiktoria</option>
                                    <option value="9">Filipczyk Bartosz</option>
                                    <option value="10">Flis Kamila</option>
                                    <option value="11">Flis Karol</option>
                                    <option value="12">Gierańczyk Wieńczysław</option>
                                    <option value="13">Giegielewicz Andrzej</option>
                                    <option value="14">Grzegorczyk Mateusz</option>
                                    <option value="15">Górski Bartłomiej</option>
                                    <option value="16">Jabłońska Agnieszka</option>
                                    <option value="17">Jędrzejewska Justyna</option>
                                    <option value="18">Kociński Paweł</option>
                                    <option value="19">Kowalkowski Adam</option>
                                    <option value="20">Kozłowska Anna</option>
                                    <option value="21">Litkowska Małgorzata</option>
                                    <option value="22">Ławański Paweł</option>
                                    <option value="23">Magalski Mateusz</option>
                                    <option value="24">Manelska Anna</option>
                                    <option value="25">Melerska Iwona</option>
                                    <option value="26">Miedzińska Karolina</option>
                                    <option value="27">Nemere-Czachowska Kinga</option>
                                    <option value="28">Olszewska Anna</option>
                                    <option value="29">Olszewski Wojtek</option>
                                    <option value="30">Opalińska Renata</option>
                                    <option value="31">Orłowska Klaudia</option>
                                    <option value="32">Pilarski Paweł</option>
                                    <option value="33">Piórkowska Joanna</option>
                                    <option value="34">Prarat Monika</option>
                                    <option value="35">Regosz Anna</option>
                                    <option value="36">Sobiech Max</option>
                                    <option value="37">Sekuła Andrzej</option>
                                    <option value="38">Skonieczna Anna</option>
                                    <option value="39">Słupkowska Monika</option>
                                    <option value="40">Tryl Magda</option>
                                    <option value="41">Tylicka Maja</option>
                                    <option value="42">Wijatkowska Ewa</option>
                                    <option value="43">Wołoszyk Przemek</option>
                                    <option value="44">Wudarski Łukasz</option>
                                    <option value="45">Zgurzyńska Ewa</option>
                                </select>


                            </div>


                            <div class="col-md-3">

                                <select name="attractions[]" multiple class="chosen-select form-control"  id="additionalAttraction" data-placeholder="Dodatkowe atrakcje...">
                                    <option value="0"></option>
                                    <option value="1">Poczęstunek piernikami</option>
                                    <option value="2">Degustacja nalewek i pierników</option>
                                    <option value="3">Spotkanie z katem</option>
                                    <option value="4">Spotkanie z Kopernikiem</option>
                                </select>
                            </div>


                        </div>

                        <legend id="anch6" class="">Atrakcje</legend>
                        <div class="row">
                            <!--Atrakcje: Główne atrakcje    -->
                            <div class="col-md-4">

                                <select id="mainAttractionType" name="mainAttractionType" data-placeholder="Wybierz...">
                                    <option value="0"></option>
                                    <option value="planetarium">Planetarium</option>
                                    <option value="piernikarnia">Piernikarnia</option>
                                    <option value="rejs">Rejs po Wiśle</option>
                                    <option value="fort">Fort</option>
                                    <option value="mlyny">Młyny Wiedzy</option>
                                    <option value="olbracht">Olbracht</option>
                                    <option value="zamek">Zamek Krzyżacki</option>
                                </select>

                            </div>

                            <!-- Atrakcje: Data i godzina   -->
                            <div class="col-md-4">

                                <div class="input-group registration-date-time">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
                                    <input class="form-control" type="date">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
                                    <input class="form-control" type="time">
                                </div>

                            </div>

                            <!-- Atrakcje: Pod selektory   -->
                            <div class="col-md-4">

                                <div class="form-group">
                                    <div class="input-group">

                                        <select id="mainAttractionChained" name="mainAttractionChained" data-placeholder="Wybierz...">
                                            <option value="0"></option>
                                            <option value="1" class="planetarium">Planetarium - seans</option>
                                            <option value="2" class="planetarium">Geodium</option>
                                            <option value="3" class="planetarium">Orbitarium</option>
                                            <!--        <optgroup class="piernikarnia" label="Piernikarnia Doroty">   -->
                                            <option value="4" class="piernikarnia">Piernikarnia Doroty</option>
                                            <!--        <optgroup class="piernikarnia" label="Muzeum Toruńskiego Piernika">   -->
                                            <option value="5" class="piernikarnia">Muzeum Toruńskiego Piernika</option>
                                            <!--        <optgroup class="piernikarnia" label="Żywe Muzeum Piernika"> -->
                                            <option value="6" class="piernikarnia">Żywe Muzeum Piernika</option>
                                            <option value="7" class="rejs">Wanda</option>
                                            <option value="8" class="rejs">Katarzynka</option>
                                            <option value="9" class="rejs">Łodzie Flisacze</option>
                                            <option value="10" class="fort">Zwiedzanie - strój</option>
                                            <option value="11" class="fort">Zwiedzanie - cywil</option>
                                            <option value="12" class="fort">Zwiedzanie z duchami</option>
                                            <option value="13" class="fort">Ognisko z kiełbaskami</option>
                                            <option value="14" class="fort">Podchody</option>
                                            <option value="15" class="fort">Gry i zabawy</option>
                                            <option value="16" class="mlyny">Zwiedzanie</option>
                                            <option value="17" class="mlyny">Warsztaty</option>
                                            <option value="18" class="zamek">Zwiedzanie</option>
                                            <option value="19" class="zamek">Komturia</option>
                                            <option value="19" class="zamek">Pokaz walk</option>
                                            <option value="20" class="olbracht">Degustacja</option>
                                            <option value="21" class="olbracht">Zwiedzanie</option>
                                            <option value="22" class="olbracht">Zakąski</option>
                                    </div>
                                </div>
                            </div>



                                    <%--<div class="input-group-btn">--%>
                                    <%--<button class="btn btn-success" type="button"  onclick="mainAttraction_fields();">--%>
                                    <%--<span class="glyphicon glyphicon-plus"></span></button>--%>
                                    <%--</div>--%>
             <%----%>

                        </div>







                </div>   <!--end of well-->















                <!--    Cały formularz pewnie pójdzie na sam koniec-->
                <button class ="btn btn-primary" type="submit">Prześlij</button>
            </form>





        </div> <!--        end of main form wrapper-->
        <div id="result"></div>
        <button id="but">Klik</button>


    <jsp:include page="scriptLinks.jsp"></jsp:include>

</body>

</html>

