import axios, {AxiosError} from "axios";
import {Vote} from "../model/Vote";

export function getAllPlayers() {
    return axios.get("/api/players")
        .then(res => res.data)
        .catch(() => console.error())
}

export function createNewPlayer(playerName: string) {
    return axios.post("/api/players", {playerName})
        .catch(() => console.error())
}

export function deletePlayer(id: string) {
    return axios.delete("/api/players/" +id)
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
    return axios.get("api/results/" +id)
        .then(res => res.data)
        .catch((err: AxiosError) => console.error(err.message))
}

export function deleteResult(id: string){
    return axios.delete("api/results/" +id)
        .then(res => res.data)
        .catch((err: AxiosError) => console.error(err.message))
}

export function getRandomPunishment(){
    return axios.get("/api/punishments/random")
        .then(res => res.data)
        .catch((err: AxiosError) => console.error(err.message))
}

