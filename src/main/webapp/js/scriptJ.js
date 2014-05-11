$(document).ready(function(){
 var availableTags = [
      "silvika",
      "martinko",
      "marosko"
    ];
 // $("input").keypress(function(e) {
 // if (e.which == '13') {
        //$("input").css("background-color","yellow");
 // }
//});


  $('#tags input').on('focusout',function(){   
     document.getElementById("textarea").style.borderColor="#eee";
    var txt= this.value.replace(/[^a-zA-Z0-9\+\-\.\#]/g,''); 
    if(txt) {
        if ($.inArray(txt,availableTags) == -1) {
          availableTags.push(txt) ;
        }
      
      $(this).before('<span class="tag">'+ txt.toLowerCase() +'</span>');
    }
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
  }).keypress(function(e) {

    if (e.which == '13') {
       $(this).focusout();
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