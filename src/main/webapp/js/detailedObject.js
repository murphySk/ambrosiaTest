$(document).ready(function(){
  $("#lessTitle").click(function(){
    $("#tags").slideToggle();
    if($("#lessTitle").text() == "More information"){
        console.log("More zbehla")
        $("#lessTitle").text("Less information");
    }
    else if($("#lessTitle").text() == "Less information"){
        console.log("Less zbehla")
        $("#lessTitle").text("More information");
    }
  });
});