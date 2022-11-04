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

    const submitNavigateToMainPage = () => {
        navigate("/")
    }

    const submitNavigateTestResult = () => {
        navigate("/result")
    }

    return(
        <>
            <p>{question}</p>

            <button onClick={submitNavigateTestResult}>Result Test</button>

            <button onClick={submitNavigateToMainPage}>Aufhören</button>
        </>
    )
}