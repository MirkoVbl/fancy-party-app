import {FancyPartyApp} from "../model/FancyPartyApp";
import {ChangeEvent, FormEvent, useState} from "react";
import axios from "axios";


const url = "/api/player"

type AddPlayerProps = {
    addPlayer: (toAdd: any) => void
}

export default function AddPlayer(props: AddPlayerProps) {

    const [playerSite, setPlayerSite] = useState(0)

    const emptyPlayer: FancyPartyApp = {
        id: "",
        player: ""
    }

    const [newPlayer, setNewPlayer] = useState(emptyPlayer);

    function handleChange(event: ChangeEvent<HTMLInputElement>){

        const name = event.target.name;
        const newValue = event.target.value;

        setNewPlayer((prevPlayer) => ({...prevPlayer,
        [name]: newValue}))
    }
    const handleSubmit = (event:FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        axios.post(url,{...newPlayer})
            .then(props.addPlayer)
    }

    return (
        <form>
            <h3>Spieler hinzufügen</h3>

            <div>
                <label htmlFor={"Spielername"}>Spielername:
                    <input
                        type={"text"}
                        name={"Spielername"}
                        onChange={handleChange}
                        value={newPlayer.player}
                        placeholder={"Spielername"}
                    />
                </label>

            <button type={"submit"} name={"Spieler hinzufügen"}>Spieler hinzufügen</button>

            </div>
        </form>
    )
}