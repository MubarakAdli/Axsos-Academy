import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams,useNavigate } from "react-router-dom";
import PlayerForm from '../components/PlayerForm';
import DeleteButton from '../components/DeleteButton';

    
const Update = (props) => {
    let navigate = useNavigate();
    const { id } = useParams();
    const [player, setPlayer] = useState();
    const [loaded, setLoaded] = useState(false);
    useEffect(() => {
        axios.get('http://localhost:8000/api/player/' + id)
            .then(res => {
                setPlayer(res.data);
                setLoaded(true);
            })
    }, []);

    const [errors, setErrors] = useState([]); 

    
    const updatePlayer = player => {
       
        axios.put('http://localhost:8000/api/player/' + id, player)
            .then(res => {console.log(res);navigate("/")})
            .catch(err=>{
                const errorResponse = err.response.data.errors; // Get the errors from err.response.data
                const errorArr = []; // Define a temp error array to push the messages in
                for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                    errorArr.push(errorResponse[key].message)
                }
                // Set Errors
                setErrors(errorArr);
            })      
    }
    
    return (
        <div>
                   { loaded && (
                       <>
                   <PlayerForm playerProp={updatePlayer} initialName={player.name}  initialPosition={player.position} 
                   myMessage={errors}   />
                   </>)}
        </div>
        // <DeleteButton authorId={author._id} successCallback={()=>navigate("/")}/>
    )
}
    
export default Update;