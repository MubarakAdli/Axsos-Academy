function removetxt(element){
    element.remove();
}
function alert(element){
    console.log("Ninja was liked");
}

function loginFunction(element){
    var old = element.innerText
    if (old == "Logout") {
        element.innerText = "Login"
    } else {
        element.innerText = "Logout"
    }   
}