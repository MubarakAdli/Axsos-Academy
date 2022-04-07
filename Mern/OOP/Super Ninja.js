class Ninja {
    constructor(name){
        this.name=name;
        this.health=10;
        this.speed=3;
        this.strength=3;
    }

    sayName(){
        console.log(`name: ${ this.name }`);
        
    }

    showStats(){
        console.log(`name: ${ this.name }`);
        console.log(`health: ${ this.health }`);
        console.log(`speed: ${ this.speed }`);
        console.log(`strength: ${ this.strength }`);
        
    }
    
    drinkSake(){
        this.health += 10;
        
    }

}

class Sensei extends Ninja{
    constructor(name){
        super(name);
        this.health=100;
        this.speed=30;
        this.strength=30;
        this.wisdom=10;
    }

    speakWisdom(){
        this.drinkSake();
        console.log("wise message");
    }
}

const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
superSensei.showStats();