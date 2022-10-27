import {Player} from "../model/Player";
import PlayerCard from "./PlayerCard";
import {FormEvent, useState} from "react";


type PlayerOverviewProps = {
    players: Player[]
    getAllPlayers: () => void
    createNewPlayer: (newPlayer: Player) => void
    deletePlayer: (id: string) => void

}

export default function PlayerOverview(props: PlayerOverviewProps){

    const [name, setName] = useState("");

    const onCreate= (e:FormEvent<HTMLFormElement>)=>{

        e.preventDefault()
        if(!name) {
            alert("Bitte gebe zuerst einen Namen ein")
            return
        }
        const newPlayer: Player = {
            playerName: name,
            id: "",
        }
        props.createNewPlayer(newPlayer)
    }


    return(
        <>
            <form onSubmit={(e)=> onCreate(e)}>
                <input name={"playerName"} placeholder={"Spielername"} onChange={event => setName(event.target.value)}/>
                <button type={"submit"}>Spieler hinzufügen</button>
            </form>
            <div className={"cards"}>
                {props.players.length <1 ?
                <h2>Spielerliste ist leer</h2>
                :
                props.players.map((p)=>
                <div className={"card"}>
                    <PlayerCard player={p} deletePlayer={props.deletePlayer}/>
                </div>)}
            </div>

        </>

    )
}
