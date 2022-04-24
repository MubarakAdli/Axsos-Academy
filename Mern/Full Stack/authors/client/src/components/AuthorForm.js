import React, { useState } from 'react'
import axios from 'axios';
import {
    Link
  } from "react-router-dom";
  import { useNavigate } from "react-router-dom";

export default (props) => {

    const [name, setName] = useState(props.initialName); 
    const navigate = useNavigate();
    const onSubmitHandler = e => {
        //prevent default behavior of the submit
        e.preventDefault();
        props.authorProp({name})
        //make a post request to create a new person
        // axios.post('http://localhost:8000/api/author', {
        //     name,
           
        // })
        //     .then(res=>console.log(res))
        //     .then(()=>navigate("/"))
        //     .catch(err=>console.log(err))
        
    }

    return (
        <>
        <h3>Favarite Authors</h3>
        <h4><Link  to={"/"}> Home  </Link></h4>
        
        <form onSubmit={onSubmitHandler}>
            <p>
                <label>Name:</label><br/>
                <input type="text" onChange={(e)=>setName(e.target.value)} value={name}/>
            </p>
            <input type="submit"/>
            <Link  to={"/"}> Cancel  </Link>
        </form>
        </>
    )
}