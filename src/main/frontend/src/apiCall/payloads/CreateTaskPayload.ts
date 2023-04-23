export default class CreateTaskPayload {
    private name: String
    private description: String
    private typeElement: String
    private color: String
    private fontColor: String

    constructor(name: String, description: String, typeElement: String, color: String, fontColor: String) {
        this.name = name
        this.description = description
        this.typeElement = typeElement
        this.color = color
        this.fontColor = fontColor
    }

    public get getName() {
        return this.name
    }
    public get getDescription() {
        return this.description
    }
    public get getTypeElement() {
        return this.typeElement
    }
    public get getColor() {
        return this.color
    }
    public get getFontColor() {
        return this.fontColor
    }
    public set setName(name: String) {
        this.name = name
    }
    public set setDescription(description: String) {
        this.description = description
    }
    public set setTypeElement(typeElement: String) {
        this.typeElement = typeElement
    }
    public set setColor(color: String) {
        this.color = color
    }
    public set setFontColor(fontColor: String) {
        this.fontColor = fontColor
    }
}