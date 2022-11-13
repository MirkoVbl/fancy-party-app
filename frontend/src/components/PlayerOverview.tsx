import {Player} from "../model/Player";
import PlayerCard from "./PlayerCard";
import {FormEvent, useState} from "react";
import {useNavigate} from "react-router-dom";
import "./PlayerOverview.css"
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';


type PlayerOverviewProps = {
    players: Player[]
    getAllPlayers: () => Promise<void>
    createNewPlayer: (newPlayerName: string) => Promise<void>
}

export default function PlayerOverview(props: PlayerOverviewProps){
    const navigate = useNavigate();

    const [playerName, setPlayerName] = useState("");

    function handleSubmit(e:FormEvent<HTMLFormElement>) {
        e.preventDefault()
        props.createNewPlayer(playerName)
            .then(() => props.getAllPlayers())
            .then(() => setPlayerName(""));
    }

    const addPlayerToast = () => {
        toast.success("Spieler hinzugefügt", {
            position: "top-center",
            autoClose: 1000,
            hideProgressBar: true,
            closeOnClick: true,
            pauseOnHover: false,
            draggable: false,
            progress: undefined,
            theme: "dark",
        });}

    return(

        <div>
            <ToastContainer
                position="top-center"
                autoClose={1000}
                hideProgressBar
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss={false}
                draggable={false}
                pauseOnHover={false}
                theme="dark"
                />

            <form onSubmit={(e)=> handleSubmit(e)}>
                <input
                    className={"playerInput"}
                    name={"playerName"}
                    placeholder={"SPIELERNAME"}
                    value={playerName}
                    onChange={(e) => setPlayerName(e.target.value)}
                />
                <button className={"spielerHinzufuegenButton"} type={"submit"} onClick={addPlayerToast}>Spieler hinzufügen</button>
            </form>
            <div className={"cards"}>
                {props.players.length < 1 ?
                <h2 className={"emptyPlayerlist"}>Spielerliste ist leer</h2>
                :
                props.players.map((p)=>
                <div className={"card"} key={"player_" + p.id}>
                    <PlayerCard player={p} getAllPlayers={props.getAllPlayers}  />
                </div>)}
            </div>

            <button className={"startButton"} onClick={() => navigate("/game")}>Start</button>

        </div>


    )
}
