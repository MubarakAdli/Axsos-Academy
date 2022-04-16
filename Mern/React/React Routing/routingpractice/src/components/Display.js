import React from 'react'
import { useParams } from 'react-router-dom'

const Display = () => {

    const {txtColor}=useParams();
    const {bgColor}=useParams();
    const{data}=useParams();
  return (
    <div>
    {(isNaN(data))?<h3 style={{color: txtColor, backgroundColor:bgColor}}>The word is: {data}</h3>:
    <h3 style={{color: txtColor, backgroundColor:bgColor}}>The num is: {data}</h3>}
    </div>
  )
}

export default Display