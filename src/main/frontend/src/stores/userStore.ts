import { defineStore } from "pinia";
import Repository from "@/apiCall/Repository";
import type EditProfilePayload from "@/apiCall/payloads/EditProfilePayload";
import type CreateTaskPayload from "@/apiCall/payloads/CreateTaskPayload";

export const useUserStore = defineStore('userInfo',{
    state: ()=>({
        userBasicInfo:{},
        userAllProjects:[] as any[], 
        temporalProject: {} as any 
    }),
    actions:{
        async obtainBasicInfo(username : String){
            const repository = new Repository('basic')

            const service = repository.chooseUserService()

            const response = await service?.userInfo(username)

            this.userBasicInfo = response
        },
        async editBasicInfo(username:String, info:EditProfilePayload){
            
            const encodeName:String = this.encoder(info.getName, '1234')
            const encodeLastName:String = this.encoder(info.getLastName, '1234')
            const encodeEmail:String = this.encoder(info.getEmail, '1234')
            
            const encodeInfo = {
                name: encodeName,
                lastName: encodeLastName,
                email: encodeEmail
            }
            const repository = new Repository('basic')

            const service = repository.chooseUserService()

            const response = await service?.EditUserInfo(username, encodeInfo)
            
            return response
        },
        async createProject(username:String, typeProject:String){
            const repository = new Repository('basic')
            const service = repository.chooseUserService()

            const info = {
                title: 'my project',
                description: 'is a new project'
            }
            await service?.createProject(username, info, typeProject);

            await service?.viewAllProjects(username)
        },
        async viewAllProjects(username:String){
            const repository = new Repository('basic')
            const service = repository.chooseUserService()

            const response = await service?.viewAllProjects(username);

            this.userAllProjects = response;

            return response;
        },
        async addNewTask(username:String, idProject:Number, idContainer:Number, idState:Number, payload:CreateTaskPayload){
            const repository = new Repository('basic')
            const service = repository.chooseUserService()

            const response = await service?.addNewTask(idProject,idContainer,idState,payload)

            await this.viewAllProjects(username)

            this.findProjectInfo(idProject)
        },
        async changeTaskOfState(username:String,idProject:Number, idContainer:Number, idStateFrom:Number, idStateTo:Number,idTask:Number){
            const repository = new Repository('basic')
            const service = repository.chooseUserService()

            const response = await service?.changeTaskOfState(idProject, idContainer, idStateFrom, idStateTo, idTask)

            await this.viewAllProjects(username)

            this.findProjectInfo(idProject)

        },
        findProjectInfo(idProject:Number){
            const element:any = this.userAllProjects.find(project => project.id === idProject)

            this.temporalProject = element
        },
        encoder(info: String, password: String) {
            const infoEncode: String = window.btoa(`${info}:${password}`)
            return infoEncode
        }
    }
})