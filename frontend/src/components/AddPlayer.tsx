import {FancyPartyApp} from "../model/FancyPartyApp";
import {useState} from "react";

type AddPlayerProps = {
    addPlayer: (toAdd: FancyPartyApp) => void
}

export default function AddPlayer(props: AddPlayerProps) {

    const emptyPlayer: FancyPartyApp = {
        player: ""
    }

    const [newPlayer, setNewPlayer] = useState(emptyPlayer);

    return (

        <form onSubmit={(submit) => {
            props.addPlayer(newPlayer);
            submit.preventDefault()
            setNewPlayer(emptyPlayer)
        }}>
            <h3>Spieler hinzufügen</h3>

            <input
                type={"text"}
                placeholder={"Spieler hinzufügen"}
                value={newPlayer.player}
                onChange={(value) => setNewPlayer((old) => ({...old, [value.target.name]: value.target.value}))}
                className={"input-style"}
                name={"command"}
            />

            <button type={"submit"} name={"Spieler hinzufügen"}>Spieler hinzufügen</button>

        </form>
    )
}