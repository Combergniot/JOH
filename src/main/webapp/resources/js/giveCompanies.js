$(document).ready( function(){
    

    function giveCompaniesAjax() {
        console.log('gibecompanies');
        $.ajax({
            url : 'company',
            dataType: 'json',
            success: function(json) {
        jQuery.each(json, function(i, ob) {
            console.log(i, ob);
           
            $('#result').append("<p>" + ob.id +" / "+ ob.name +"</p>");
        })},
            error: function(){
                $('#result').html("Error!");
            }
            
        });
    } 
    
    $('#but').click(function(){
        console.log('klik!');
        giveCompaniesAjax();
    })
    
     
    
    
   
    
    
    
    
});


