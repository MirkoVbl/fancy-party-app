import {useEffect, useState} from "react";
import {Player} from "../model/Player";
import axios from "axios";
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;

export default function useFancyPartyApp() {

    const [players, setPlayers] = useState([]);

    useEffect(()=> {

        getAllPlayers()

    }, [])

    const getAllPlayers = () => {
        axios.get("/api/fancypartyapp")
            .then(res => res.data)
            .then(d => setPlayers(d))
            .catch((error))
    }

    const createNewPlayer = (player: Player) => {
        axios.post("/api/fancypartyapp", player)
            .then(getAllPlayers)
            .catch(()=> console.error())
    }
    const deletePlayer = (id:  String) => {
        axios.delete("/api/fancypartyapp/" +id)
            .then(getAllPlayers)
            .catch(()=> console.error())
    }

    return {players,getAllPlayers, createNewPlayer, deletePlayer}
}