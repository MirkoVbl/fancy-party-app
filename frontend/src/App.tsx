import React from 'react';
import './App.css';
import useFancyPartyApp from "./hooks/useFancyPartyApp";
import {HashRouter, Route, Routes} from 'react-router-dom';
import PlayerOverview from "./components/PlayerOverview";
import NavBar from "./components/NavBar";
import MainPage from "./pages/MainPage";
import EditPage from "./pages/EditPage";
import BackendService from "./services/BackendService";


function App() {

    const {createNewPlayer, getAllPlayers, players, deletePlayer} = useFancyPartyApp();
    const backendService = new BackendService();

    return (
        <div className="App">
            <HashRouter>
                <h1>Fancy Party App</h1>
                <NavBar/>
                <Routes>
                    <Route path={"/"} element={<MainPage/>}/>
                    <Route path={"/editplayer"}
                           element={<EditPage
                               players={players}
                               deletePlayer={deletePlayer}/>}/>
                    <Route path={"/spielerliste"}
                           element={<PlayerOverview
                               backendService={backendService}
                               players={players}
                               getAllPlayers={getAllPlayers}
                               createNewPlayer={createNewPlayer}/>}/>

                </Routes>
            </HashRouter>
        </div>
    );
}

export default App;
