import {useNavigate} from "react-router-dom";

export default function MainPage(){

    const navigate = useNavigate();
    const navToSpielerliste = () => {
        navigate("/spielerliste")
    }

    const submitNavigate = () => {
        navToSpielerliste();
    }

    return(
        <>
        <h5>Viel Spaß beim spielen</h5>
            <button onClick={submitNavigate}>Spielerliste</button>
        </>
    )

}