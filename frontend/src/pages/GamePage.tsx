import {useNavigate} from "react-router-dom";

export default function GamePage() {


    const navigate = useNavigate();
    const navToGame = () => {
        navigate("/game")
    }

    const submitNavigate = () => {
        navToGame();
    }

    return(
        <>


        </>
    )
}