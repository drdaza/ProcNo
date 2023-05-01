import axios from "axios";

export default class CreationElementService{
    private baseUrl:String

    public constructor(){
        this.baseUrl = "http://localhost:8080/api"
        axios.defaults.withCredentials = true
    }

    public async listAllTypesOfElements (){
        const response = axios.get(this.baseUrl + '/typeOfElement')

        const getBody = (await response).data

        return getBody
    }
}