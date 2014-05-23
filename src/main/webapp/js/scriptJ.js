$(document).ready(function(){
   var availableTags = [];
   var pocitadlo=0;
   var vypis;

function func1(){
   // console.log("ahoooj");
     var id=document.getElementById("id").innerHTML;
     $.ajax({
           type: 'GET',
           url: "/ambrosia/detailedObject3",
           data: {idObject: id},
           dataType : 'json',
           contentType:"application/json",
          error: function (xhr, status) {
                                    alert("na zaciatku je alert, ved to som predpokladala");
                                },

           success: function(data, textStatus, xhr){
               // console.log("bubacisko");
               if(jQuery.isEmptyObject(data)==false){
                  for (index = 0; index < data.length; index++) {
                          $('#tags input').before('<span class="tag">'+ data[index].tag.toLowerCase() +'</span>');
                         // console.log(data[index].tag);
                     }

                  }
              }
           });
};
window.onload=func1;
  $('#tags input').on('focusout',function(){

     var id=document.getElementById("id").innerHTML;
     document.getElementById("textarea").style.borderColor="#eee";
    var txt= this.value;//.replace(/[^a-zA-Z0-9\+\-\.\#]/g,'');
   // console.log("id");
   // console.log(id);
    if(txt) {
        if ($.inArray(txt,availableTags) == -1) {
            $(this).before('<span class="tag">'+ txt.toLowerCase() +'</span>');
             //availableTags.push(txt) ;
             this.value="";
             $.ajax({
                url: "/ambrosia/detailedObject",
                data: { tag: txt, id2: id }

             });


        }else console.log("existing tag");
      

    }
    this.value="";

  }).keypress(function(e) {
    pocitadlo++;
   // console.log("1");
   // console.log(availableTags);
    if(pocitadlo==4){
        console.log("buuu");
        var txt=this.value;
         console.log(txt);
         $.ajax({
         type: 'GET',
         url: "/ambrosia/detailedObject2",
         data: {tag: txt},
         dataType : 'json',
         contentType:"application/json",
        error: function (xhr, status) {
                                   alert("po 4 pismenkach");
                                  //alert(status);
                              },

         success: function(data, textStatus, xhr){
             if(jQuery.isEmptyObject(data)==false){
                for (index = 0; index < data.length; index++) {
                        var id=document.getElementById("id").innerHTML;
                        if(id!=data[index].objectId)
                        availableTags=availableTags.concat(data[index].tag);
                        console.log(data[index]);
                   }
                $( "#autocomplete" ).autocomplete({
                    source: availableTags
                });

                }
            }
         });


    }
    //console.log(pocitadlo);
    if (e.which == '13') {
       $(this).focusout();
       pocitadlo=0;
        while(availableTags.length > 0) {
                     availableTags.pop();
                 }

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