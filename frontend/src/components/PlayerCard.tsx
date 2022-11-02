import {Player} from "../model/Player";
import {deletePlayer} from "../services/BackendService";

type PlayerCardProps = {
    player: Player;
    getAllPlayers: () => Promise<void>
}

export default function PlayerCard (props: PlayerCardProps) {

    const deleteHandler = () => {
        if(props.player.id === undefined){
            return null;
        }
        deletePlayer(props.player.id)
            .then(props.getAllPlayers);
    }


    return (

        <div className={"player-card"}>

            <p>{props.player.playerName}</p>
            <button onClick={deleteHandler}>Löschen</button>

        </div>
    )
}