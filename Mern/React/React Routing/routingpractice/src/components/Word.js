import React from 'react'
import { useParams } from 'react-router-dom';

const Word = () => {

    const { data } = useParams();
  return (
    <div>
    {(isNaN(data))?<h3>The word is: {data}</h3>:
    <h3>The num is: {data}</h3>}
    </div>
  )
}

export default Word