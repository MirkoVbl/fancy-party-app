import {FancyPartyApp} from "../model/FancyPartyApp";
import AddPlayer from "./AddPlayer";
import FancyPartyAppCard from "./FancyPartyAppCard";


type FancyPartyAppOverviewProps = {
    players: FancyPartyApp[]
    addPlayer: (toAdd: FancyPartyApp) => void
    deletePlayer: (toDelete: string) => void

}

export default function FancyPartyAppOverview(props: FancyPartyAppOverviewProps){


    return(
        <>
            <AddPlayer addPlayer={props.addPlayer}/>

    <div>
        <FancyPartyAppCard fancyPartyApp={props.players} addPlayer={props.addPlayer}  deletePlayer={props.deletePlayer}/>
    </div>
        </>

    )
}
