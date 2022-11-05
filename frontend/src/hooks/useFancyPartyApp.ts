import {useEffect, useState} from "react";
import axios from "axios";
import  {deletePlayer} from "../services/BackendService";


export default function useFancyPartyApp() {

    const [players, setPlayers] = useState([]);

    useEffect(()=> {

        getAllPlayers()

    }, [])

    const getAllPlayers = () => {
        return axios.get("/api/players")
            .then(res => res.data)
            .then(d => setPlayers(d))
            .catch(()=> console.error())
    }

    const createNewPlayer = (playerName: string) => {
        return axios.post("/api/players", {playerName})
            .then(getAllPlayers)
            .catch(()=> console.error())
    }
    const removePlayer = (id:  string) => {
            deletePlayer(id)
            .then(()=> getAllPlayers)
            .catch(()=> console.error())
    }

    return {players,getAllPlayers, createNewPlayer, removePlayer}
}