import axios from "axios";

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
        return axios.delete("/api/fancypartyapp" +id)
            .catch(() => console.error())
    }
}