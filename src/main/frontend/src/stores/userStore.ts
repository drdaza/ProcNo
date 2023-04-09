import { defineStore } from "pinia";
import Repository from "@/apiCall/Repository";
import type EditProfilePayload from "@/apiCall/payloads/EditProfilePayload";

export const useUserStore = defineStore('userInfo',{
    state: ()=>({
        userBasicInfo:{},
        userAllProjects:[] as any[]
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
        async createProject(username:String){
            const repository = new Repository('basic')
            const service = repository.chooseUserService()

            const info = {
                title: 'my project',
                description: 'is a new project'
            }
            await service?.createProject(username, info);
        },
        async viewAllProjects(username:String){
            const repository = new Repository('basic')
            const service = repository.chooseUserService()

            const response = await service?.viewAllProjects(username);

            this.userAllProjects = response;

            return response;
        },
        encoder(info: String, password: String) {
            const infoEncode: String = window.btoa(`${info}:${password}`)
            return infoEncode
        }
    }
})