import React, {useState} from "react";
import { useEffect } from "react";
const Pokemon = (props) => {
    const [pokemon, setPokemon] = useState([]);
    const [result, setResult] = useState([]);
    
 
    useEffect(() => {
        fetch('https://pokeapi.co/api/v2/pokemon')
            .then(response => response.json())
            .then(response => setResult(response.results))
            .catch(err=>{
                console.log(err);
            });
            
    }, []);
    const handelClick=()=>{
        setPokemon(result)
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
export default Pokemon;