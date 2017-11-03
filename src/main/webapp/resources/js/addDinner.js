var dinnerCount = 1;
function dinner_fields() {

    dinnerCount++;
    var objToAppend = document.getElementById('dinner-fields')
    var newGroupDiv = document.createElement("div");
    newGroupDiv.setAttribute("class", "dinner-row removeDinner" + dinnerCount);
    var rdiv = 'removeDinner' + dinnerCount;
    newGroupDiv.innerHTML = '<div class="col-md-4"><select class="chosen-select form-control"  id="mealsType" data-placeholder="Typ posiłku..."><option value="0"></option><option value="1">Śniadanie</option><option value="2">Obiad</option><option value="3">Kolacja</option></select></div> <div class="col-md-4"><div class="input-group registration-date-time"><span class="input-group-addon"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span><input class="form-control" type="date"><span class="input-group-addon"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span><input class="form-control" type="time"></div></div> <div class="col-md-4"><div class="input-group"><select class="chosen-select form-control" id=restaurants data-placeholder="Wybierz miejsce..."><option value="0"></option><option value="1">Chleb i wino</option><option value="2">Ciasna</option><option value="3">Ciżemka</option><option value="4">Fort IV</option><option value="5">Gessler "U Kucharzy"</option><option value="6">Gęsia Szyja</option><option value="7">Jan Olbracht Browar Staromiejski</option><option value="8">Jimmys Steakhouse</option><option value="9">Karczma Spichrz</option><option value="10">Kuranty</option><option value="11">Luizjana</option><option value="12">Manekin</option><option value="13">Metropolis</option><option value="14">Mistrz i Małgorzata</option><option value="15">Oberża</option><option value="16">Odessa</option><option value="17">Osetia</option><option value="18">Piąta Klepka</option><option value="19">Prowansja</option><option value="20">Pueblo</option><option value="21">Róża i Zen</option><option value="22">Sowa</option><option value="23">Staromiejska</option><option value="24">Szeroka No 9</option></select><div class="input-group-btn"><button class="btn btn-danger" type="button"  onclick="remove_dinner_fields(' + dinnerCount + ');"/><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button></div></div></div></div><div class="clear"></div>';


  objToAppend.appendChild(newGroupDiv)
    
   // objToAppend.insertBefore( newGroupDiv, objToAppend.firstChild );
    
    
}
function remove_dinner_fields(rid) {
    $('.removeDinner' + rid).remove();
}