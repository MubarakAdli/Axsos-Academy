const pokémon = Object.freeze([
        { "id": 1,   "name": "Bulbasaur",  "types": ["poison", "grass"] },
        { "id": 5,   "name": "Charmeleon", "types": ["fire"] },
        { "id": 9,   "name": "Blastoise",  "types": ["water"] },
        { "id": 12,  "name": "Butterfree", "types": ["bug", "flying"] },
        { "id": 16,  "name": "Pidgey",     "types": ["normal", "flying"] },
        { "id": 23,  "name": "Ekans",      "types": ["poison"] },
        { "id": 24,  "name": "Arbok",      "types": ["poison"] },
        { "id": 25,  "name": "Pikachu",    "types": ["electric"] },
        { "id": 37,  "name": "Vulpix",     "types": ["fire"] },
        { "id": 52,  "name": "Meowth",     "types": ["normal"] },
        { "id": 63,  "name": "Abra",       "types": ["psychic"] },
        { "id": 67,  "name": "Machamp",    "types": ["fighting"] },
        { "id": 72,  "name": "Tentacool",  "types": ["water", "poison"] },
        { "id": 74,  "name": "Geodude",    "types": ["rock", "ground"] },
        { "id": 87,  "name": "Dewgong",    "types": ["water", "ice"] },
        { "id": 98,  "name": "Krabby",     "types": ["water"] },
        { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
        { "id": 122, "name": "Mr. Mime",   "types": ["psychic"] },
        { "id": 133, "name": "Eevee",      "types": ["normal"] },
        { "id": 144, "name": "Articuno",   "types": ["ice", "flying"] },
        { "id": 145, "name": "Zapdos",     "types": ["electric", "flying"] },
        { "id": 146, "name": "Moltres",    "types": ["fire", "flying"] },
        { "id": 148, "name": "Dragonair",  "types": ["dragon"] }
    ]);

    // 1- an array of pokémon objects where the id is evenly divisible by 3
    const idDivBy3 = pokémon.filter((item) => item.id % 3 == 0);
    console.log(idDivBy3);

    // 2- an array of pokémon objects that are "fire" type
    const fireTypes=pokémon.filter((item)=>item.types.includes("fire"));
    console.log(fireTypes);

    // 3- an array of pokémon objects that have more than one type
    const muiltiTypes=pokémon.filter((item)=>item.types.length > 1);
    console.log(muiltiTypes);

    // 4- an array with just the names of the pokémon
    const pokNames = pokémon.map((item) => item.name);
    console.log(pokNames);

    // 5- an array with just the names of pokémon with an id greater than 99
    const namesWithIdgreter99 = pokémon.filter((item) => item.id > 99).map((item) => item.name);
    console.log(namesWithIdgreter99);

    // 6- an array with just the names of the pokémon whose only type is poison
    const poisonTypesNames=pokémon.filter((item) => item.types[0]=="poison"  && item.types.length==1).map((item) => item.name);
    console.log(poisonTypesNames);

    // 7- an array containing just the first type of all the pokémon whose second type is "flying"
    const secondFlying=pokémon.filter((item) => item.types[1]=="flying");
    console.log(secondFlying);

    // 8- a count of the number of pokémon that are "normal" type
    const normalPok=pokémon.filter((item) => item.types=="normal");
    const numOfNormal=normalPok.length;
    console.log(numOfNormal);