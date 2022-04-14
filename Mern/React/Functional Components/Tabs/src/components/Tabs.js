import React,{useState}from 'react'
import './style.css';
const Tabs = (props) => {
    const [tabName,setTabName]=useState("")
    const handelName=(e,name)=>{
        setTabName(name +" "+ "content is showing")
    }
  return (
    <div>
        <ul>
        {props.items.map((item,i) =>
            <li key={i} onClick={(e) => handelName(e, item)} value={item}>
                <button type="button" >{item}</button>
            </li>
            
        )}
        </ul>
        <p>{tabName}</p>
    </div>
  )
}

export default Tabs