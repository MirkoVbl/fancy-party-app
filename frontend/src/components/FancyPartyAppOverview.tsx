import {FancyPartyApp} from "../model/FancyPartyApp";
import AddPlayer from "./AddPlayer";

type FancyPartyAppOverviewProps = {
    player: FancyPartyApp[]
    addPlayer: (toAdd: FancyPartyApp) => void
}

export default function FancyPartyAppOverview(props: FancyPartyAppOverviewProps){

    return(
        <>
            <AddPlayer addPlayer={props.addPlayer}/>
        </>

    )
}
