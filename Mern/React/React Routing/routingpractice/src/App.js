import logo from './logo.svg';
import './App.css';
import { BrowserRouter , Switch , Route,Link  } from 'react-router-dom';
import Home from './components/Home';
import Word from './components/Word';
import Display from './components/Display';




function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Switch>
        <Route path="/home">
          <Home/>
        </Route>
        <Route exact path="/:data">
          <Word/>
        </Route>
        <Route exact path="/:data/:txtColor/:bgColor">
          <Display/>
        </Route>
      </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
