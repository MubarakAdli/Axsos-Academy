import React, { useEffect } from 'react'
import axios from 'axios';
import './style.css';

import {
    Link
  } from "react-router-dom";
  import DeleteButton from "./DeleteButton";
  


  const PlayerList = (props) => {
    const { removeFromDom } = props;

//     useEffect(()=>{
// console.log(props.player);
//     })
    
  return (
    <>
    
    <h2><Link  to={"/"}> Manage Players </Link> | <Link  to={"/"}> Manage Players status  </Link></h2>
    <h2><Link  to={"/"}> List  </Link> | <Link  to={"/player"}> Add Player  </Link></h2>
    <table>
      <thead>
        <tr>
        <th>player</th>
        <th>Position</th>
        <th>Actions availale</th>
        </tr>
        </thead>
        <tbody>
        {props.player.map((player, i) =>
         
          
                <tr key={i}>
                <td >{player.name}</td>
                <td>{player.position}</td>
               
                <td><Link  to={"/player/"+player._id+""}>Edit</Link>
                |<DeleteButton playerId={player._id} successCallback={()=>removeFromDom(player._id)}/></td>
                
                </tr>
                
                
            )
        }</tbody>
    </table>
    
    </>
)
}
export default PlayerList;