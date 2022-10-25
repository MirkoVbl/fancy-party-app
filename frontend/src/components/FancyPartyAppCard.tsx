import {FancyPartyApp} from "../model/FancyPartyApp";


type FancyPartyAppCardProps = {
    player: FancyPartyApp;

}

export default function FancyPartyAppCard(props: FancyPartyAppCardProps) {
    return (

        <div className={"cheatCard"}>


            <p><span>Name:</span><br/>{props.player.player}</p>


        </div>
    )
}