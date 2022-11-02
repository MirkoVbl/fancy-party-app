import {Player} from "../model/Player";
import PlayerCard from "./PlayerCard";
import {FormEvent, useState} from "react";
import {useNavigate} from "react-router-dom";
import BackendService from "../services/BackendService";


type PlayerOverviewProps = {
    players: Player[]
    getAllPlayers: () => Promise<void>
    createNewPlayer: (newPlayerName: string) => Promise<void>
    backendService: BackendService
}

export default function PlayerOverview(props: PlayerOverviewProps){
    const navigate = useNavigate();

    const [playerName, setPlayerName] = useState("");

    function handleSubmit(e:FormEvent<HTMLFormElement>) {
        e.preventDefault()
        props.backendService.createNewPlayer(playerName)
            .then(() => props.getAllPlayers())
            .then(() => setPlayerName(""));
    }

    return(
        <>
            <form onSubmit={(e)=> handleSubmit(e)}>
                <input
                    name={"playerName"}
                    placeholder={"Spielername"}
                    value={playerName}
                    onChange={(e) => setPlayerName(e.target.value)}
                />
                <button type={"submit"}>Spieler hinzufügen</button>
            </form>
            <div className={"cards"}>
                {props.players.length < 1 ?
                <h2>Spielerliste ist leer</h2>
                :
                props.players.map((p)=>
                <div className={"card"}>
                    <PlayerCard player={p} getAllPlayers={props.getAllPlayers} backendService={props.backendService} />
                </div>)}
            </div>
            <button onClick={() => navigate("/editplayer")}>edit</button>
        </>

    )
}
