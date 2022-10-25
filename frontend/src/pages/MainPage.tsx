import FancyPartyAppOverview from "../components/FancyPartyAppOverview";
import {FancyPartyApp} from "../model/FancyPartyApp";

type FancyPartyAppOverviewProps = {
    players: FancyPartyApp[]
    addPlayer: (toAdd: FancyPartyApp) => void
    deletePlayer: (id: string) => void

}

export default function MainPage(props: FancyPartyAppOverviewProps){
    
    return (
        <>
            <main>
                <span> <p>Fancy Party App</p></span>
            </main>
            
            <FancyPartyAppOverview players={props.players} addPlayer={props.addPlayer} deletePlayer={props.deletePlayer} />
        </>
    )
}