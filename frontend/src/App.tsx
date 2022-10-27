import React from 'react';
import './App.css';
import useFancyPartyApp from "./hooks/useFancyPartyApp";
import {HashRouter, Route, Routes} from 'react-router-dom';
import PlayerOverview from "./components/PlayerOverview";
import NavBar from "./components/NavBar";
import MainPage from "./pages/MainPage";


function App() {

    const {createNewPlayer, getAllPlayers, players, deletePlayer} = useFancyPartyApp();


    return (
        <div className="App">
            <HashRouter>
                <h1>Test</h1>
                <NavBar/>
                <Routes>
                    <Route path={"/mainpage"} element={<MainPage/>}/>
                    <Route path={"/"}
                           element={<PlayerOverview
                               players={players}
                               getAllPlayers={getAllPlayers}
                               createNewPlayer={createNewPlayer}
                               deletePlayer={deletePlayer}/>}/>
                </Routes>
            </HashRouter>
        </div>
    );
}

export default App;
