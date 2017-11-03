var groupCount = 1;
function group_fields() {

    groupCount++;
    var objToAppend = document.getElementById('group_fields')
    var newGroupDiv = document.createElement("div");
    newGroupDiv.setAttribute("class", "pola-grupy removeclass" + groupCount);
    var rdiv = 'removeclass' + groupCount;
    newGroupDiv.innerHTML = '<div class="col-md-3"><div class="form-group"> \n\
<input type="text" class="form-control" id="ChildrenNr" name="childrenNr" value="" placeholder="Ile dzieci?"></div>\n\
</div><div class="col-md-3"><div class="form-group"> <input type="text" class="form-control"\n\
 id="AdultsNr" name="AdultsNr" value="" placeholder="Ilu dorosłych?"></div></div><div class="col-md-3 \n\
"><div class="form-group"> <input type="text" class="form-control" id="StaffNr" name="StaffNr"\n\
 value="" placeholder="Obsługa:"></div></div><div class="col-md-3 nopadding"><div class="form-group">\n\
<div class="input-group"> <select class="form-control" id="groupType" name="groupType"><option value="">\n\
Typ grupy</option><option value="szkolna">Grupa szkolna</option><option value="dorosli">Dorośli</option>\n\
<option value="seniorzy">Seniorzy</option></select><div class="input-group-btn">\n\
 <button class="btn btn-danger" type="button" onclick="remove_education_fields(' + groupCount + ');"> \n\
<span class="glyphicon glyphicon-minus" aria-hidden="true"></span> </button></div></div></div></div><div class="clear"></div>';

  objToAppend.appendChild(newGroupDiv)
   // objToAppend.insertBefore( newGroupDiv, objToAppend.firstChild );
    
    
}
function remove_education_fields(rid) {
    $('.removeclass' + rid).remove();
}