import './App.css';
import {useState} from "react";

const user = {
  name: 'Hedy Lamarr',
  imageUrl: 'https://i.imgur.com/yXOvdOSs.jpg',
  imageSize: 90,
};

function MyButton({count, onClick}) {
  return (
      <button onClick={onClick}>Clicked {count} times</button>
  );
}

function App() {
  const [count, setCount] = useState(0);

  function handleCLick() {
    setCount(count + 1);
  }

  return (
      <div className="App">
        <header className="App-header">
          <p>Edit <code>src/App.js</code> and save to reload.</p>
          <a
              className="App-link"
              href="https://ja.react.dev/"
              target="_blank"
              rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
  );
}

export default App;
