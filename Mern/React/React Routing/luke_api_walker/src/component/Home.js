import React,{useState} from 'react'
import { useHistory } from "react-router-dom";
const types = [
    'people',
    'planets'
];
const Home = () => {
    const [selectedType, setSelectedType] = useState(types[0]);
    const [id,setID]=useState("")
    const history=useHistory();
    const handleSubmit=(e)=>{
        e.preventDefault();
        history.push('/'+selectedType+"/"+id)
    }
  return (
    <div>
        <form onSubmit={handleSubmit}>
            <select value={selectedType} onChange={e => setSelectedType(e.target.value)}>
                
                { types.map( (type, idx) => 
                    <option key={idx} value={type}>{type}</option>
                )}
            </select>
            <label> ID :
                <input type="text"  onChange={e => setID(e.target.value)}/> 
            </label>
            <button>Search</button>
        </form>
    </div>
  )
}

export default Home