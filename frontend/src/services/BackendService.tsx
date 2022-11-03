import axios, {AxiosError} from "axios";
import {Vote} from "../model/Vote";

export function getAllPlayer() {
        return axios.get("/api/fancypartyapp")
            .then(res => res.data)
            .catch(() => console.error())
    }

export function createNewPlayer(playerName: string) {
        return axios.post("/api/fancypartyapp", {playerName})
            .catch(() => console.error())
    }

export function deletePlayer(id: string) {
        return axios.delete("/api/fancypartyapp/" +id)
    }

export function getRandomQuestion(){
        return axios.get("/api/questions/random")
            .then(res => res.data)
            .catch((err: AxiosError) => console.error(err.message))
    }

export function voteForPlayer(vote: Vote){
        return axios.post("/api/votes", vote)
            .then(res => res.data)
            .catch((err: AxiosError) => console.error(err.message))
    }

export function getResult(id: string){
        return axios.get("api/result/" +id)
            .then(res => res.data)
            .catch((err: AxiosError) => console.error(err.message))
    }

