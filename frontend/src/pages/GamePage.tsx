import {useNavigate} from "react-router-dom";
import {getRandomQuestion, deleteResult, voteForPlayer} from "../services/BackendService";
import {useEffect, useState} from "react";
import {Player} from "../model/Player";
import {Question} from "../model/Question";
import "./GamePage.css"

type GamePageProps = {
    players: Player[];
}

export default function GamePage(props: GamePageProps) {

    const [question, setQuestion] = useState<Question>()
    const [currentPlayer, setCurrentPlayer] = useState<Player>()
    const [remainingPlayers, setRemainingPlayers] = useState<Player[]>(props.players
        .map(player => ({player, sortValue: Math.random()}))
        .sort((a, b) => a.sortValue - b.sortValue)
        .map(({player}) => player))


    useEffect(() => {
        if (props.players.length === 0) {
            throw new Error("Keine Spieler vorhanden!");
        }

        getRandomQuestion()
            .then((q: Question) => {
                setQuestion(q);
                deleteResult(q.id);
            })
        nextPlayerOrResult();
        // eslint-disable-next-line
    },[]);

    const navigate = useNavigate();

    const submitNavigateToMainPage = () => {
        navigate("/")
    }

    function nextPlayerOrResult() {
        if (remainingPlayers.length === 0) {
            navigate("/result/" + question?.id);
            return;
        }
        const nextPlayer = remainingPlayers.slice(-1)[0];
        setCurrentPlayer(nextPlayer)
        setRemainingPlayers(remainingPlayers.filter(p => p.id !== nextPlayer.id))
    }

    function vote(player: Player){
        if (!question || !currentPlayer) {
            return;
        }
        voteForPlayer({
            answerId: player.id,
            questionId: question.id,
            voterId: currentPlayer.id,
        }).then(() => nextPlayerOrResult());
        nextPlayerOrResult();

    }

    return(
        <div>
            <div className={"questiontext"}>{question?.questionText} </div>
            <div className={"playerName"}>{currentPlayer?.playerName}</div>
            <div className={"playerVoteText"}>stimme jetzt ab!</div>
            {props.players.map((p)=>
            <button className={"playerVoteButton"} key={"player_" + p.id} onClick={() => vote(p)}>{p.playerName}</button>)}

            <button className={"aufhoerenButton"} onClick={submitNavigateToMainPage}>Aufhören</button>
        </div>
    )
}