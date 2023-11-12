import logo from './logo.svg';
import './App.css';
import { useState} from "react";

function MyButton() {
    const [count, setCount] = useState(0);

  function handleClick() {
    setCount(count + 1);
  }

  return (
      <button onClick={handleClick}>
        Clicked { count } times
      </button>
  );
}

const user = {
  name: 'cosmin cosan',
  imageUrl: 'https://tapptitude.com/wp-content/uploads/2022/02/Cosmin-Cosan-1.png',
  imageSize: 90
}

function App() {
  return (
      <div>
        <h1> { user.name } </h1>

        <img
            className = "deer"
            src = { user.imageUrl }
            alt = { 'photo of' + user.name }
            style = {{
              width: user.imageSize,
              height: user.imageSize
            }}
        />

        <MyButton/>
      </div>
  );
}

export default App;

