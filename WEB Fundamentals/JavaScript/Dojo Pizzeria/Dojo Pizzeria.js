function pizzaOven(crustType,sauceType,cheeses,toppings){
var pizza={};
pizza.crustType=  "deep dish";
pizza.sauceType= "traditional";
pizza.cheeses= "cmozzarella";
pizza.toppings= ["pepperoni", "sausage"]
return pizza;
}

var pizza1=pizzaOven("deep dish","traditional","mozzarella",["pepperoni", "sausage"]);
console.log(pizza1);

var pizza2=pizzaOven("hand tossed","marinara",["mozzarella", "feta"],["mushrooms", "olives", "onions"]);
console.log(pizza2);

var mypizza=pizzaOven("thick","traditional","feta",["pepperoni","olives", "sausage"]);
console.log(mypizaa);

var mypizza2=pizzaOven("tthin","marinara","ozzarella",["pepperoni","olives"]);
console.log(mypizaa2);