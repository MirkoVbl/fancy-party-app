import {Player} from "../model/Player";
import PlayerCard from "./PlayerCard";
import {ChangeEvent, FormEvent, useState} from "react";


type PlayerOverviewProps = {
    players: Player[]
    getAllPlayers: () => void
    createNewPlayer: (newPlayer: Player) => void
    deletePlayer: (id: string) => void

}

export default function PlayerOverview(props: PlayerOverviewProps){

    const emptyPlayer: Player ={
        playerName: "",
        id: ""
    }
    const [player, setPlayer] = useState(emptyPlayer);

    function handleChange(event : ChangeEvent<HTMLInputElement>){

        const name = event.target.name;
        const newValue = event.target.value;

        setPlayer((prevPlayer) => ({...prevPlayer,
            [name]:newValue}))

    }


    function handleSubmit(e:FormEvent<HTMLFormElement>) {
        e.preventDefault()
        props.createNewPlayer(player)
    }



    return(
        <>
            <form onSubmit={(e)=> handleSubmit(e)}>
                <input name={"playerName"} placeholder={"Spielername"} onChange={handleChange}/>
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
