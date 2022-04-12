import React,{useState} from "react";

const ColorForm = (props) =>{
    const [color, setColor] = useState("");
    const handleSubmit = (e) => {
        e.preventDefault();
        props.onNewColor( color );
    };
    return(
        <div>
            <form onSubmit={ handleSubmit }>
            color
            <input
                placeholder="Enter color here"
                onChange={ (e) => setColor(e.target.value) }
                value={ color }
            ></input>
            <input type="submit" value="Add" />
        </form>
        </div>
        );
    
    }

export default ColorForm;