import React, { useState } from 'react';
import './App.css';
import ColorForm from './components/ColorForm';
import BoxDisplay from './components/BoxDisplay';
function App() {
  const [currentColor, setCurrentColor] = useState([]);
  const newColor = ( newColor ) => {
    setCurrentColor( currentColor.concat(newColor) );
  }
  return (
      <header className="App">
        
        <ColorForm onNewColor={ newColor } />
        
        <BoxDisplay color={ currentColor } />
        
      </header>
    
  );
}

export default App;
