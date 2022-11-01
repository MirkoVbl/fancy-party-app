import axios, {AxiosError} from "axios";
import {Vote} from "../model/Vote";

export default class BackendService {
    getAllPlayer() {
        return axios.get("/api/fancypartyapp")
            .then(res => res.data)
            .catch(() => console.error())
    }

    createNewPlayer(playerName: string) {
        return axios.post("/api/fancypartyapp", {playerName})
            .catch(() => console.error())
    }

    deletePlayer(id: string) {
        return axios.delete("/api/spielerliste/" +id)
            .catch(() => console.error())
    }

    getRandomQuestion(){
        return axios.get("/api/questions/random")
            .then(res => res.data)
            .catch((err: AxiosError) => console.error(err.message))
    }

    voteForPlayer(vote: Vote){
        return axios.post("/api/votes", vote)
            .then(res => res.data)
            .catch((err: AxiosError) => console.error(err.message))
    }

    getResult(id: string){
        return axios.get("api/result/" +id)
            .then(res => res.data)
            .catch((err: AxiosError) => console.error(err.message))
    }
}