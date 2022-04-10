  
import React, { Component } from 'react';

class MyComponent extends Component{
    constructor(props) {
        super(props);
        this.state = {
            counter : this.props.age,

        };
    }   

    increaseAge = () =>{
        this.setState({counter : this.state.counter + 1})
        
    }
    
    render() {
        
        return <div>
            <h1>{ this.props.firstName },{ this.props.lastName }</h1>
            <p id="number">Age : {this.state.counter}</p>
            <p>Hair Color : {this.props.haircolor}</p>
            <button  onClick={ this.increaseAge }>Birthday button for { this.props.firstName }{ this.props.lastName }</button>
        </div>
    };

}

    
export default MyComponent;