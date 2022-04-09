import React, { Component } from 'react';
    
    
class MyComponent extends Component {
    render() {
        return <div>
            <h1>{this.props.firstName} {this.props.lastName}</h1>
            <h4>{this.props.age}</h4>
            <h4>{this.props.hairColor}</h4>
        </div>;
    }
}
    
export default MyComponent;