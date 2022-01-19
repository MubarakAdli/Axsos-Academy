
function reverse(arr) {
    var newarr = []
    for (var i = 0; i < arr.length; i++) {
        newarr.push(arr[arr.length - 1 - i])
    }
    return newarr;
}

var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result);