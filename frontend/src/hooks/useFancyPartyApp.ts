import {useEffect, useState} from "react";
import axios from "axios";

export default function useFancyPartyApp() {

    const [players, setPlayers] = useState([]);

    useEffect(()=> {

        getAllPlayers()

    }, [])

    const getAllPlayers = () => {
        return axios.get("/api/fancypartyapp")
            .then(res => res.data)
            .then(d => setPlayers(d))
            .catch(()=> console.error())
    }

    const createNewPlayer = (playerName: string) => {
        return axios.post("/api/fancypartyapp", {playerName})
            .then(getAllPlayers)
            .catch(()=> console.error())
    }
    const deletePlayer = (id:  String) => {
        return axios.delete("/api/fancypartyapp/" +id)
            .then(getAllPlayers)
            .catch(()=> console.error())
    }

    return {players,getAllPlayers, createNewPlayer, deletePlayer}
}