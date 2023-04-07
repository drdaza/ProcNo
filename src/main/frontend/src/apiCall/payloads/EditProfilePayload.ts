export default class EditProfilePayload {
    private email: String;
    private name: String;
    private lastName: String

    constructor(email: String, name: String, lastName: String) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public get getEmail() {
        return this.email;
    }
    public get getName() {
        return this.name;
    }
    public get getLastName() {
        return this.lastName;
    }
    public set setEmail(email: String) {
        this.email = email;
    }
    public set setLastName(lastName: String) {
        this.lastName = lastName;
    }
    public set setName(name: String) {
        this.name = name;
    }
}