import React, { useState } from 'react'
import axios from 'axios';
import {
    Link
  } from "react-router-dom";
  import { useNavigate } from "react-router-dom";

  import './style.css';
//   position
export default (props) => {

    const [name, setName] = useState(props.initialName); 
    const [position, setPosition] = useState(props.initialPosition);
    const navigate = useNavigate();
    // const [errors, setErrors] = useState([]); 
    const {myMessage}=props;

    const onSubmitHandler = e => {
        //prevent default behavior of the submit
        e.preventDefault();
        props.playerProp({name,position})
        //make a post request to create a new person
        // axios.post('http://localhost:8000/api/player', {
        //     name,
           
        // })
        //     .then(res=>console.log(res))
        //     .then(()=>navigate("/"))
        //     .catch(err=>console.log(err))
        
    }

    return (
        <>
        <h2><Link  to={"/"}> Manage Players </Link> | <Link  to={"/"}> Manage Players status  </Link></h2>
        <main>
        <h2><Link  to={"/"}> List  </Link> | <Link  to={"/"}> Add Player  </Link></h2>
        <h1>Add a player</h1>
        
        <form onSubmit={onSubmitHandler}>
        { myMessage && myMessage.map((err, index) => <p key={index}>{err}</p>)}
            <p>
                <label>Name:</label><br/>
                <input type="text" onChange={(e)=>setName(e.target.value)} value={name}/>
            </p>

            <p>
                <label>position:</label><br/>
                <input type="text" onChange={(e)=>setPosition(e.target.value)} value={position}/>
            </p>
            <div className='butStyle'>
            <input type="submit"/>
            <Link className='dlbut' to={"/"}> Cancel  </Link>
            </div>
        </form>
        </main>
        </>
    )
}