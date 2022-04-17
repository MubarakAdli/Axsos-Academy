import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter,
  Link, 
  Route, 
  Switch
} from "react-router-dom";
import Info from './component/Info';
import Home from './component/Home';
function App() {
  return (
    <BrowserRouter forceRefresh={true} >
    
      <Switch>
      <Route exact path="/:type/:id">
          <Info />
        </Route>
        <Route exact path="/">
          <Home />
        </Route>
        
      </Switch>
    
    </BrowserRouter>
  );
}

export default App;