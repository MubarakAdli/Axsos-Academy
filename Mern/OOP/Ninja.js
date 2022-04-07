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

const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();