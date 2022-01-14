function fact(num){
    var mult=1;
    for(var i=1;i<=num;i++){
        mult=mult*i;
    }
    return mult;
}
console.log(fact(12));
