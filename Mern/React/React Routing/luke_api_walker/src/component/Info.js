import React,{useState,useEffect} from 'react'
import axios from 'axios'
import { useParams } from "react-router";
const Info = (props) => {
    const [loaded,setLoaded]=useState(false);
    const {type,id}=useParams();
    const [people, setPeople] = useState(null);
    useEffect(()=>{
        axios.get('https://swapi.dev/api/'+type+'/'+id)
            .then(response=>{setPeople(response.data);setLoaded(true);console.log(people);console.log(response)})
            .catch(error =>console.log(error))
            
    }, [type,id]); 
    if(type =="people"){
  return (
    <div>
        
        <h1>{loaded && people.name}</h1>
        <p>Height : {loaded && people.height}</p>
        <p>Mass : {loaded && people.mass}</p>
        <p>Hair Color : {loaded && people.hair_color}</p>
        <p>Skin Color : {loaded && people.skin_color}</p>
    </div>
  )}
  else{
    return (
        <div>
            <h1>{loaded && people.name}</h1>
            <p>Climate : {loaded && people.climate}</p>
            <p>Terrain : {loaded && people.terrain}</p>
            <p>Surface Water : {loaded && people.surface_water}</p>
            <p>Population : {loaded && people.population}</p>
        </div>
      )
  }
}

export default Info