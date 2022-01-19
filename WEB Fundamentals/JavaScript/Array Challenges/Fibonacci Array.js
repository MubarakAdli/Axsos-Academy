function fibonacciArray(n) {
    var fibArr = [0, 1];
    for (var i = 0; i < n - 2; i++) {
        fibArr[i + 2] = fibArr[i + 1] + fibArr[i]
    }
    return fibArr;
}
var result = fibonacciArray(10);
console.log(result); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]