
import React from 'react';
import './box.css';
const BoxDisplay = (props) => {
    return (
        <>
            <div className='box'> 
                {props.color.map((item, index)=> {

                    const style={backgroundColor:item,
                                    width:100,
                                    height:100,
                    };
                    return <div   index={index} style={style} >{item}</div>
            })}</div>
        </>
    );
};

export default BoxDisplay;

