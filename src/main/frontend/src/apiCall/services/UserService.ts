import axios from "axios"
import type CreateTaskPayload from "../payloads/CreateTaskPayload";

export default class UserService {
    private baseUrl: String

    public constructor() {
        this.baseUrl = 'http://localhost:8080/api'
    }

    public async userInfo(username: String) {

        const response = axios.get(this.baseUrl + `/user/${username}`, { withCredentials: true })

        const getBbody = await response;

        console.log(getBbody.data);


        console.log(getBbody.status);

        return getBbody.data;
    }

    public async EditUserInfo(username: String, info: any) {

        axios.defaults.withCredentials = true;
        const response = axios.put(this.baseUrl + `/user/edit/${username}`, info)

        const getStatus = (await response).status

        return getStatus;
    }

    public async createProject(username: String, info: any, typeProject: String) {
        axios.defaults.withCredentials = true;
        const response = axios.post(this.baseUrl + `/user/createProject/${username}/${typeProject}`, info)

        const getStatus = (await response).data

        console.log(getStatus);

    }

    public async viewAllProjects(username:String){
        axios.defaults.withCredentials = true;
        const response = axios.get(this.baseUrl + `/user/allProjects/${username}`)

        const getData = (await response).data

        return getData
    }

    public async addNewTask(idProject:Number, idContainer:Number, idState:Number, payload:CreateTaskPayload){
        axios.defaults.withCredentials = true;
        const response = axios.put(this.baseUrl + `/user/project/${idProject}/container/${idContainer}/state/${idState}`, payload)

        const getData = (await response).data
        
    }

    public async changeTaskOfState(idProject:Number, idContainer:Number, idStateFrom:Number, idStateTo:Number,idTask:Number){

        axios.defaults.withCredentials = true;
        const response = axios.put(this.baseUrl + `/user/project/${idProject}/container/${idContainer}/fromState/${idStateFrom}/toState/${idStateTo}/task/${idTask}`)

        const getData = (await response).data
    } 
}