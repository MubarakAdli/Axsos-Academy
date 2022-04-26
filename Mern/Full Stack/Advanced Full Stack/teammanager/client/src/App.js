import logo from './logo.svg';
import './App.css';
import Main from './views/Main';
import Update from './views/Update';


import React from 'react';

import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Create from './views/Create';
function App() {
  return (
    <div className="App">
<BrowserRouter>
    <div className="App">
    <Routes>
      
      <Route path="/player/" element={ <Create />} />
      <Route path="/" element={ <Main />} />
      <Route path="/player/:id/" element={<Update />}/>
     
      </Routes>
    </div>
  </BrowserRouter>
    </div>
  );
}

export default App;

