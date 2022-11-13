import { useEffect, useState} from "react";
import {getRandomPunishment, getResult} from "../services/BackendService";
import {useNavigate, useParams} from "react-router-dom";
import {Punishment} from "../model/Punishment";
import {Vote} from "../model/Vote";
import {Player} from "../model/Player";
import {toast} from "react-toastify";
import "./ResultPage.css"

type ResultPageProps = {
    players: Player[];
}
export default function ResultPage(props: ResultPageProps){

    const { questionId } = useParams()

    const[punishment, setPunishment] = useState<Punishment>()
    const[result, setResult] = useState("")


    useEffect(()=>{
        if (typeof questionId !== 'string') {
            throw toast('Question ID fehlt!')
        }
        getRandomPunishment()
            .then((p: Punishment) => setPunishment(p))
        getResult(questionId)
            .then((r: Vote[])=> setResult(getPlayerWithMostVotes(r)))
        // eslint-disable-next-line
    }, []);

    const navigate = useNavigate();

    const navToGame = () => {
        navigate("/game")
    }

    const submitNavigate = () => {
        navToGame();
    }

    function getPlayerWithMostVotes(votes: Vote[]): string {
        const voteCounts = votes
            .map(v => v.answerId)
            .reduce((carry: Record<string, number>, answerId) => {
                carry[answerId] = (carry[answerId] ?? 0) + 1;
                return carry;
            }, {})

        const playersSortedByVotes = props.players
            .map(player => ({player, voteCount: voteCounts[player.id] ?? 0}))
            .sort((a, b) => b.voteCount - a.voteCount)

        if (playersSortedByVotes.length < 2) {
            throw new Error('Nicht genug Spieler');
        }

        return playersSortedByVotes
            .filter(p => p.voteCount === playersSortedByVotes[0].voteCount)
            .map(p => p.player.playerName)
            .join(', ');
    }

    return(
        <>
            <p className={"punish"}>Das Ergebnis ist: </p><br/>
            <p className={"punishResult"}>{result}</p><br/>
            <div className={"punishText"}>{punishment?.punishmentText}</div><br/>

            <button className={"nextRoundButton"} onClick={submitNavigate}>Nächste Runde</button>
        </>
    )
}