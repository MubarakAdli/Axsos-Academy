import './App.css';
import MyComponent from './components/MyComponent';
function App() {
  return (
    <div className="App">
      <MyComponent firstName={"Doe"} lastName={"Jane"} age={45} hairColor={"black"}/>
      <MyComponent firstName={"Smith"} lastName={"Jone"} age={88} hairColor={"brown"}/>
      <MyComponent firstName={"Fillmore"} lastName={"Millard"} age={50} hairColor={"brown"}/>
      <MyComponent firstName={"Smith"} lastName={"Maria"} age={62} hairColor={"brown"}/>
    </div>
  );
}

export default App;