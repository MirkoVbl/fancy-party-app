import {FancyPartyApp} from "../model/FancyPartyApp";
import axios from "axios";

type FancyPartyAppCardProps = {
    fancyPartyApp: FancyPartyApp[];
    addPlayer: (toAdd: FancyPartyApp) => void
    deletePlayer: (toDelete: any ) => void

}

export default function FancyPartyAppCard (props: FancyPartyAppCardProps) {

    const deleteString = "/api/fancypartyapp" + props.fancyPartyApp;

    function deletePlayer(id:string){
        axios.delete(id).then(props.deletePlayer)
    }

    return (

        <div className={""}>

            <p>{props.addPlayer.name}</p>
            <p>{props.addPlayer.name}</p>
            <button onClick={()=> deletePlayer(deleteString)}>Löschen</button>

        </div>
    )
}