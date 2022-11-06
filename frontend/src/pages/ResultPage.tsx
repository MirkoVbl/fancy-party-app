import {useEffect, useState} from "react";
import {getRandomPunishment} from "../services/BackendService";
import {useNavigate} from "react-router-dom";

export default function ResultPage(){

    const[punishment, setPunishment] = useState("")

    useEffect(()=>{
        getRandomPunishment()
            .then((p) => setPunishment(p.punishmentText))

    }, []);

    const navigate = useNavigate();

    const navToGame = () => {
        navigate("/game")
    }

    const submitNavigate = () => {
        navToGame();
    }

    return(
        <>
            <p>{punishment}</p>

            <button onClick={submitNavigate}>Nächste Runde</button>
        </>
    )
}