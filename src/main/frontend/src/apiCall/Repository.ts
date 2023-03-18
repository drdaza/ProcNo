import AuthService from "./services/AuthService";

export default class Repository{
    private api: String;

    public constructor(api:String){
        this.api = api;
    }

    public chooseApi() {
        if(this.api === 'auth') return new AuthService()
    }
    
}