import {Player} from "../model/Player";
import {useNavigate} from "react-router-dom";

type EditPageProps = {
    players: Player[]
    deletePlayer: (id: string) => void

}
export default function EditPage(props: EditPageProps){


    const navigate = useNavigate();
    const navToSpielerliste = () => {
        navigate("/spielerliste")
    }

    const submitNavigate = () => {
        navToSpielerliste();
    }

    return(
        <div>
            <div className={"cards"}>
            {props.players.length <1 ?
                <h2>Spieler Gelöscht</h2>
                :
                props.players.map((p)=>
                    <div className={"card"}>
                        {}
                    </div>)}
        </div>
            <button onClick={submitNavigate}>zurück</button>
        </div>

    )
}