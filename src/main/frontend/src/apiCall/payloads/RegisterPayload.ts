export default class RegisterPayload{

    private userPassword:String;
    private email:String;

    public constructor(userPassword:String, email:String) {
        this.userPassword = userPassword;
        this.email = email;
    }
    
    public set setUserPassword(userPassword : String) {
        this.userPassword = userPassword;
    }

    public set setEmail(email : String) {
    this.email = email;
    }

    public get getUserPassword() : String {
        return this.userPassword;
    }
    
    public get getEmail() : String {
        return this.email;
    }
    
    

    
}