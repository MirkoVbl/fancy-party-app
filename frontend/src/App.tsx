import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import {Simulate} from "react-dom/test-utils";


function App() {

  const[helloMessage, setHelloMessage] = useState("")

    useEffect(()=>{
        fetchHelloMessage()
    }, [])

    function fetchHelloMessage(){
      axios.get("/api/hello")
          .then(response => response.data)
          .then(data => setHelloMessage(data))
          .then((error) => console.log(error))

    }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          {helloMessage}
        </p>

      </header>
    </div>
  );
}

export default App;
