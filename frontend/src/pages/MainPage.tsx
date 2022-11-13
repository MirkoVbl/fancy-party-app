import {useNavigate} from "react-router-dom";
import "./MainPageCss.css"

export default function MainPage(){

    const navigate = useNavigate();
    const navToSpielerliste = () => {
        navigate("/spielerliste")
    }

    const submitNavigate = () => {
        navToSpielerliste();
    }

    return(
            <body className={"background"}>
            <h5 className={"playIcon"}><i className="fa-regular fa-circle-play"></i></h5>
        <h5 className={"vielSpass"}>Viel Spaß beim spielen!</h5>
            <button className={"buttonstart"} onClick={submitNavigate}></button>
            </body>

    )

}