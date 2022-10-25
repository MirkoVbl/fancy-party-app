import FancyPartyAppOverview from "../components/FancyPartyAppOverview";
import {FancyPartyApp} from "../model/FancyPartyApp";

type FancyPartyAppOverviewProps = {
    player: FancyPartyApp[]
    addPlayer: (toAdd: FancyPartyApp) => void
}

export default function MainPage(props: FancyPartyAppOverviewProps){
    
    return (
        <>
            <main>
                <span> <p>Fancy Party App</p></span>
            </main>
            
            <FancyPartyAppOverview player={props.player} addPlayer={props.addPlayer} />
        </>
    )
}