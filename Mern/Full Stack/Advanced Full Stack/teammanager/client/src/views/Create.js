import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams,useNavigate } from "react-router-dom";
import PlayerForm from '../components/PlayerForm';
const Create = () => {
    let navigate = useNavigate();
    const [errors, setErrors] = useState([]); 

    const createPlayer = player => {
        axios.post('http://localhost:8000/api/player', player)
            .then(res=>{console.log(res);
                ;navigate("/")})

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
                   <PlayerForm playerProp={createPlayer} initialName=""  initialPosition=""  myMessage={errors} />
        </div>
    )}

export default Create