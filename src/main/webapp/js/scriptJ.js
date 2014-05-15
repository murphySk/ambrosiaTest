$(document).ready(function(){
 var availableTags = [
      "silvika",
      "martinko",
      "marosko"
    ];
   var pocitadlo=0;
   var vypis;

  $('#tags input').on('focusout',function(){   
     document.getElementById("textarea").style.borderColor="#eee";
    var txt= this.value;//.replace(/[^a-zA-Z0-9\+\-\.\#]/g,'');
    if(txt) {
        if ($.inArray(txt,availableTags) == -1) {
            $(this).before('<span class="tag">'+ txt.toLowerCase() +'</span>');
             availableTags.push(txt) ;
             this.value="";
             console.log(txt);
             var param = "?txt=";
             var params = param.concat(txt);
             console.log(params);
             var urll = "/ambrosia/detailedObject";
             var url = urll.concat(params);
              console.log(url);
               xmlhttp = new XMLHttpRequest();
               xmlhttp.open("GET", url, true);
               xmlhttp.send();

        }else console.log("existing tag");
      

    }
    this.value="";

  }).keypress(function(e) {         //po napisani 3 pismen ta hodi na metodu v kontroleri, tam sa ten text dostane-vypise do cmd, ale nevrati sa spat
    pocitadlo++;
    if(pocitadlo==4){
        var txt=this.value;
         console.log(txt);
         var param = "?txt=";
         var params = param.concat(txt);
        //console.log(params);
         var urll = "/ambrosia/detailedObject2";
         var url = urll.concat(params);
        //console.log(url);
          xmlhttp2 = new XMLHttpRequest();
          xmlhttp2.open("GET", url, true);
         vypis= xmlhttp2.send();
         console.log(vypis);        

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