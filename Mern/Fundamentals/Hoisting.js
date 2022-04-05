// 1
var hello;
console.log(hello); // logs undefined
hello='world';

// 2
var needle;
needle="haystack";
test();
function test() {
var needle;
needle="magnet";
console.log(needle); // 'logs magnet'
}

// 3
var brendan;
brendan = "super cool";
function print() {
    brendan = "only okay";
    console.log(brendan); 
}
console.log(brendan); // logs 'super cool'

// 4
var food;
food = "chicken";
console.log(food); // logs 'chicken'
eat();
function eat() {
    var food;  
    food = "half-chicken";
    console.log(food); // logs 'half-chicken'
    food = "gone";
}

// 5

// 6
var genre;
console.log(genre); // logs undefined
genre = "disco";
rewind();
function rewind() {
    var genre;
    genre = "rock";
    console.log(genre); // logs 'rock'
    genre = "r&b";
    console.log(genre); // logs 'r&b'
}
console.log(genre); // logs 'disco'

// 7
dojo = "san jose";
console.log(dojo); // logs 'san jose'
learn();
function learn() {
    var dojo;
    dojo = "seattle";
    console.log(dojo); // logs 'seattle'
    dojo = "burbank";
    console.log(dojo); // logs 'burbank'
}
console.log(dojo); // logs 'san jose'

// 8
console.log(makeDojo("Chicago", 65));
console.log(makeDojo("Berkeley", 0));
function makeDojo(name, students) {
    const dojo = {};
    dojo.name = name;
    dojo.students = students;
    if (dojo.students > 50) {
        dojo.hiring = true;
    } else if (dojo.students <= 0) {
        dojo = "closed for now"; // throws error assignment (dojo is a constant variable)
    }
    return dojo;
}