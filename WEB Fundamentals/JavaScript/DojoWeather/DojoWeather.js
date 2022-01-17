//displaying the alert
function dis(element) {
    alert("Loading weather report");
}

// hide the fixed message
var ran = document.querySelector("footer");
function hide() {
    ran.remove();
}

//changing betwwen Celsius and Fahrenheit
function convert(selectElement){
    
    var mode =selectElement.value
    console.log(mode)
    var list = document.querySelectorAll(".degree");
    for (var i = 0; i < list.length; i++) {
        var value = parseInt(list[i].innerText)
        if (mode == "c") {
            value = (value*1.8)+32 ;
        } else {
            value = (value-32)/1.8 ;
        }
        list[i].innerText = value;
    }
}


