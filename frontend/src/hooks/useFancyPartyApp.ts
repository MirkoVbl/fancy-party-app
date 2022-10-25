import {useEffect, useState} from "react";
import {FancyPartyApp} from "../model/FancyPartyApp";
import axios from "axios";

export default function useFancyPartyApp() {

    const [player, setPlayer] = useState([]);

    useEffect(()=> {

        getAllPlayer()

    }, [])

    const getAllPlayer = () => {
        axios.get("/api/fancypartyapp")
            .then((response) => {
                return response.data
            })
            .then((player) =>{
                setPlayer(player)
            })
            .catch(()=> console.error())
    }

    const addPlayer = (playerToAdd: FancyPartyApp) => {
        axios.post("/api/fancypartyapp", playerToAdd)
            .then(getAllPlayer)
            .catch(()=> console.error())
    }

    return {player, addPlayer}
}