import React from 'react';
import './App.css';
import useFancyPartyApp from "./hooks/useFancyPartyApp";
import {HashRouter, Route, Routes} from 'react-router-dom';
import MainPage from "./pages/MainPage";



function App() {

  const{addPlayer, player} = useFancyPartyApp();


  return (
    <div className="App">
      <HashRouter>
          <Routes>
              <Route path={"/"} element={<MainPage addPlayer={addPlayer} player={player} />}/>
          </Routes>
      </HashRouter>
    </div>
  );
}

export default App;
