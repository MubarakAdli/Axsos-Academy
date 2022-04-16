import React, {useState,useEffect} from "react"
import axios from 'axios';
const Poke = (props) => {
    const [pokemon, setPokemon] = useState([]);
    const [result, setResult] = useState(null);
    
    useEffect(() => {
        axios.get('https://pokeapi.co/api/v2/pokemon')
        .then(response=>{setResult(response.data.results)})
}, []);
    const handelClick=()=>{
        setPokemon(result)
        console.log(pokemon)
    }
    return (
        <div>
            <button onClick={handelClick}>Fetch pokemon</button>
            {pokemon.length > 0 && pokemon.map((pokemon, index)=>{
                return (<div key={index}>{pokemon.name}</div>)
            })}
        </div>
    );
}
export default Poke;