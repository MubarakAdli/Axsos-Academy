import React, { useEffect, useState } from 'react'
import axios from 'axios';
import AuthorList from '../components/AuthorList';
import {
    Link
  } from "react-router-dom";
export default (props) => {
    const [author, setAuthor] = useState([]);
    const [loaded, setLoaded] = useState(false);
    
    useEffect(()=>{
        axios.get('http://localhost:8000/api/author')
            .then(res=>{
                setAuthor(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[]);
    
    const removeFromDom = authorId => {
        setAuthor(author.filter(author => author._id !==authorId));
    }
    
    return (
        <div className="App">
            
           {loaded && <AuthorList author={author} removeFromDom={removeFromDom}/>}
        </div>
    )
}