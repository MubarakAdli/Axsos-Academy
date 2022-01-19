function highPass(arr, cutoff) {
    var filteredArr = [];
    for(var i=0;i<arr.length;i++){
        if(arr[i]>5){
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); 