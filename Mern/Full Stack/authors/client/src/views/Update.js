import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams,useNavigate } from "react-router-dom";
import AuthorForm from '../components/AuthorForm';
import DeleteButton from '../components/DeleteButton';

    
const Update = (props) => {
    let navigate = useNavigate();
    const { id } = useParams();
    const [author, setAuthor] = useState();
    const [loaded, setLoaded] = useState(false);
    useEffect(() => {
        axios.get('http://localhost:8000/api/author/' + id)
            .then(res => {
                setAuthor(res.data);
                setLoaded(true);
            })
    }, []);
    
    const updateAuthor = author => {
       
        axios.put('http://localhost:8000/api/author/' + id, author)
            .then(res => {console.log(res);navigate("/")})
            .catch(err => console.error(err));
    }
    
    return (
        <div>
                   { loaded && (
                       <>
                   <AuthorForm authorProp={updateAuthor} initialName={author.name}  />
                   </>)}
        </div>
        // <DeleteButton authorId={author._id} successCallback={()=>navigate("/")}/>
    )
}
    
export default Update;