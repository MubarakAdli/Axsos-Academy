import React, { useEffect, useState } from 'react'
import axios from 'axios';
import PlayerList from '../components/PlayerList';
import {
    Link
  } from "react-router-dom";
export default (props) => {
    const [player, setPlayer] = useState([]);
    const [loaded, setLoaded] = useState(false);
    
    useEffect(()=>{
        axios.get('http://localhost:8000/api/player')
            .then(res=>{
                // console.log(res.data);
                setPlayer(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[]);
    
    const removeFromDom = playerId => {
        setPlayer(player.filter(player => player._id !==playerId));
    }
    
    return (
        <div className="App">
            
           {loaded && <PlayerList player={player} removeFromDom={removeFromDom}/>}
        </div>
    )
}