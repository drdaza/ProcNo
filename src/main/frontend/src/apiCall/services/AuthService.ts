import axios from "axios";
import type RegisterPayload from "../payloads/RegisterPayload";

export default class AuthService{
    private baseUrl:String;

    public constructor(){
        this.baseUrl = 'http://localhost:8080/api';
    }

    public async register(registerInfo: RegisterPayload){
        
        const json:Map<String,String> = new Map<String,String>()

        json.set('usernameAndPass', registerInfo.getUserPassword)
        json.set('emailAndPass', registerInfo.getEmail)

        const response = axios.post(this.baseUrl+'/register',json)

        const getBody = await response

        return getBody
    }

    public async login(loginInfo:String) {
        const response = await axios.get(`${this.baseUrl}/login`, {
            headers: {
              Authorization: `Basic ${loginInfo}`
            },
            withCredentials: true
          });
        const getBody = response;

        console.log(response.status);
        
        return getBody.data
    }
    
    public get getBaseUrl() : String {
        return this.baseUrl;
    }
    
    public set setBaseUrl(baseUrl : string) {
        this.baseUrl = baseUrl;
    }
    
    
}