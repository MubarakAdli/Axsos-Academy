var op = "";
var firstNum = "";
var secondNum = "";

function calculate() {
    secondNum = getDisplay().innerText;
    console.log(firstNum, secondNum, op)
    if (op == "+") {
        getDisplay().innerText = parseFloat(firstNum) + parseFloat(secondNum);
    }
    else if (op == "-") {
        getDisplay().innerText = parseFloat(firstNum) - parseFloat(secondNum);
    }
    else if (op == "*") {
        getDisplay().innerText = parseFloat(firstNum) * parseFloat(secondNum);
    }
    else if (op == "/") {
        getDisplay().innerText = parseFloat(firstNum) / parseFloat(secondNum);
    }

    reset();
}

function press(val) {
    var displayEl = getDisplay();
    var oldValue = displayEl.innerText;

    if (op != "" && firstNum == "") {
        firstNum = oldValue;
        displayEl.innerText = "0";
        oldValue = "0";
    }

    if (oldValue == "0") {
        displayEl.innerText = val;
    } else {
        displayEl.innerText += val;
    }
}

function setOP(currentOp) {
    op = currentOp;
}

function clr() {
    getDisplay().innerText = "0"
    reset();
}

function reset() {
    op = ""
    firstNum = ""
    secondNum = ""
}

function getDisplay() {
    return document.getElementById('display');
}
