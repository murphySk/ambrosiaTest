$(document).ready(function(){
 var availableTags = [
    ];
   var pocitadlo=0;
   var vypis;

  $('#tags input').on('focusout',function(){
     document.getElementById("textarea").style.borderColor="#eee";
    var txt= this.value;//.replace(/[^a-zA-Z0-9\+\-\.\#]/g,'');
    if(txt) {
        if ($.inArray(txt,availableTags) == -1) {
            $(this).before('<span class="tag">'+ txt.toLowerCase() +'</span>');
             //availableTags.push(txt) ;
             this.value="";
             $.ajax({
                url: "/ambrosia/detailedObject",
                data: {tag: txt}
             });


        }else console.log("existing tag");
      

    }
    this.value="";

  }).keypress(function(e) {
    pocitadlo++;
   // console.log("1");
   // console.log(availableTags);
    if(pocitadlo==4){
        var txt=this.value;
         console.log(txt);
         $.ajax({
         type: 'GET',
         url: "/ambrosia/detailedObject2",
         data: {tag: txt},
        error: function (xhr, status) {
                                  alert(status);
                              },

         success: function(data, textStatus, xhr){

            availableTags = data;
            //console.log(availableTags);

            $( "#autocomplete" ).autocomplete({
                source: availableTags
            });
            }
         });


    }
    //console.log(pocitadlo);
    if (e.which == '13') {
       $(this).focusout();
       pocitadlo=0;
   }

  });
   
  
   $('#tags input').on('click',function(){
   
        document.getElementById("textarea").style.borderColor="#3399FF";
  });
  
      $('#tags').on('click','.tag',function(){
      document.getElementById("textarea").style.borderColor="#eee";
     if(confirm("Really delete this tag?")) $(this).remove(); 
  });
  
      $('#tags').on('keydown', function(e){
    if(e.keyCode === 8 && document.getElementById("autocomplete").value===""){
       if(confirm("Really delete this tag?")) {
         elements = document.getElementsByClassName("tag");
         var dlzka=  (elements.length-1);
         elements[0].parentNode.removeChild(elements[dlzka]);
    } }
    
  });
  

  
$( "#autocomplete" ).autocomplete({
  source: availableTags
});
  
 
 
    
});