function alwaysHungry(arr) {
    var counter = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] == "food") {
            console.log("yummy");
        }
        else
            if (arr[i] != ("food")) {
                counter = counter + 1;
                if (counter == arr.length) {
                    console.log("I am hungry");
                }
            }
    }
}
alwaysHungry([3.14, "food", "pie", true, "food"]);
alwaysHungry([4, 1, 5, 7, 2]);