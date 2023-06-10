export default class BasicInfoProjectPayload {
    private nameProject:String
    private descriptionProject:String

    public constructor (nameProject:String, descriptionProject:String){
        this.nameProject = nameProject
        this.descriptionProject = descriptionProject
    }

    public get getNameProject(){
        return this.nameProject
    }
    public get getDescriptionProject(){
        return this.descriptionProject
    }
    public set setNameProject(nameProject:String){
        this.nameProject = nameProject
    }
    public set setDescriptionProject(descriptionProject:String){
        this.descriptionProject = descriptionProject
    }
}