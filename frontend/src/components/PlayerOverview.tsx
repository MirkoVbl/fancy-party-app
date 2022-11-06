import {Player} from "../model/Player";
import PlayerCard from "./PlayerCard";
import {FormEvent, useState} from "react";
import {useNavigate} from "react-router-dom";


type PlayerOverviewProps = {
    players: Player[]
    getAllPlayers: () => Promise<void>
    createNewPlayer: (newPlayerName: string) => Promise<void>
}

export default function PlayerOverview(props: PlayerOverviewProps){
    const navigate = useNavigate();

    const [playerName, setPlayerName] = useState("");

    function handleSubmit(e:FormEvent<HTMLFormElement>) {
        e.preventDefault()
        props.createNewPlayer(playerName)
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
                <div className={"card"} key={"player_" + p.id}>
                    <PlayerCard player={p} getAllPlayers={props.getAllPlayers}  />
                </div>)}
            </div>
            <button onClick={() => navigate("/editplayer")}>edit</button>

            <button onClick={() => navigate("/game")}>Start</button>
        </>

    )
}
