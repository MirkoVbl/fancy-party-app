import {Player} from "../model/Player";

type PlayerCardProps = {
    player: Player;
    deletePlayer: (id:string) => void;
}

export default function PlayerCard (props: PlayerCardProps) {

    const deleteHandler = () => {
        if(props.player.id === undefined){
            return null;
        }
        props.deletePlayer(props.player.id);
    }


    return (

        <div className={"player-card"}>

            <p>{props.player.playerName}</p>
            <button onClick={deleteHandler}>Löschen</button>

        </div>
    )
}