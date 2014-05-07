$(document).ready(function(){
  $("#lessTitle").click(function(){
    $("#detailedInfo").slideToggle();
    if($("#lessTitle").text() == "More information"){
        console.log("More zbehla")
        $("#lessTitle").text("Less information");
    }
    else if($("#lessTitle").text() == "Less information"){
        console.log("Less zbehla")
        $("#lessTitle").text("More information");
    }
  });
  $.getJSON('/ambrosia/js/test.json', function(data) {
    console.log(data.meno);
    $("#skuska").text(data.meno.length);
  })
});