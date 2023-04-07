import axios from "axios"

export default class UserService{
    private baseUrl:String

    public constructor(){
        this.baseUrl = 'http://localhost:8080/api'
    }

    public async userInfo(username:String){
        
        const response = axios.get(this.baseUrl + `/user/${username}`,{withCredentials:true})

        const getBbody = await response;

        console.log(getBbody.data);
        

        console.log(getBbody.status);
        
        return getBbody.data;
    }
}