import AuthService from "./services/AuthService";
import UserService from "./services/UserService";
import CreationElementService from "./services/CreationElementService";

export default class Repository{
    private api: String;

    public constructor(api:String){
        this.api = api;
    }

    public chooseAuthService() {
        if(this.api === 'auth') return new AuthService()
    }
    
    public chooseUserService(){
        if(this.api === 'basic') return new UserService()
    }
    public chooseCreationElementService(){
        if(this.api === 'createElement') return new CreationElementService()
    }
}