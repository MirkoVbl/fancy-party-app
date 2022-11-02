import {useNavigate} from "react-router-dom";
import {getRandomQuestion} from "../services/BackendService";
import {useEffect, useState} from "react";


export default function GamePage() {

    const [question, setQuestion] = useState("")

    useEffect(() => {
        getRandomQuestion()
            .then((q)=>setQuestion(q.questionText))


    }, []);

    const navigate = useNavigate();
    const navToGame = () => {
        navigate("/")
    }

    const submitNavigate = () => {
        navToGame();
    }


    return(
        <>
            <p>{question}</p>

            <button onClick={submitNavigate}>Aufhören</button>
        </>
    )
}