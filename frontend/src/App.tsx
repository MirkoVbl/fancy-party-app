import React from 'react';
import './App.css';
import useFancyPartyApp from "./hooks/useFancyPartyApp";
import {HashRouter, Route, Routes} from 'react-router-dom';
import PlayerOverview from "./components/PlayerOverview";
import NavBar from "./components/NavBar";
import MainPage from "./pages/MainPage";
import GamePage from "./pages/GamePage";
import ResultPage from "./pages/ResultPage";


function App() {

    const {createNewPlayer, getAllPlayers, players,} = useFancyPartyApp();

    return (
        <div className="App">
            <HashRouter>
                <h1>Fancy Party App</h1>
                <NavBar/>
                <Routes>
                    <Route path={"/"} element={<MainPage/>}/>
                    <Route path={"/game"} element={<GamePage players={players}/>}/>
                    <Route path={"/result/:questionId"} element={<ResultPage players={players}/>}/>
                    <Route path={"/spielerliste"}
                           element={<PlayerOverview
                               players={players}
                               getAllPlayers={getAllPlayers}
                               createNewPlayer={createNewPlayer}/>}/>

                </Routes>
            </HashRouter>
        </div>
    );
}

export default App;
