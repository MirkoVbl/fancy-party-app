import {Player} from "../model/Player";
import {deletePlayer} from "../services/BackendService";
import "./PlayerCard.css"
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';


type PlayerCardProps = {
    player: Player;
    getAllPlayers: () => Promise<void>
}

export default function PlayerCard (props: PlayerCardProps) {

    const deleteHandler = () => {
        if(props.player.id === undefined){
            return null;
        }
        deletePlayer(props.player.id)
            .then(props.getAllPlayers);
    }

    const deleteToast = () => {
        toast.success("Spieler gelöscht", {
            position: "top-center",
            autoClose: 1000,
            hideProgressBar: true,
            closeOnClick: true,
            pauseOnHover: false,
            draggable: false,
            progress: undefined,
            theme: "dark",
        });}

    return (

        <div className={"player-card"} >
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

            <p className={"specialP"}>{props.player.playerName}</p>
            <button className={"buttonBackground"} onClick={deleteHandler} onClickCapture={deleteToast} ><i className="fa-solid fa-user-xmark"></i></button>
        </div>
    )
}