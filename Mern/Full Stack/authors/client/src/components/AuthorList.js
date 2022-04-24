import React from 'react'
import axios from 'axios';
import './style.css';

import {
    Link
  } from "react-router-dom";
  import DeleteButton from "./DeleteButton";
  


  const AuthorList = (props) => {
    const { removeFromDom } = props;

  return (
    <>
    <h2>Favarite authors</h2>
    <h3><Link  to={"/author/"}>Add new author</Link></h3>
    <table>
        <tr>
        <th>Author</th>
        <th>Actions availale</th>
        </tr>
        {props.author.map((author, i) =>{
                return<tr>
                <td key={i}>{author.name}</td>
               
                <td><Link  to={"/author/"+author._id+""}>Edit</Link>
                |<DeleteButton authorId={author._id} successCallback={()=>removeFromDom(author._id)}/></td>
                
                </tr>
            })
        }
    </table>
    
    </>
)
}
export default AuthorList;