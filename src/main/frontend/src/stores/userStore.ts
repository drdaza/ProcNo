import { defineStore } from "pinia";
import Repository from "@/apiCall/Repository";
import type EditProfilePayload from "@/apiCall/payloads/EditProfilePayload";

export const useUserStore = defineStore('userInfo',{
    state: ()=>({
        userBasicInfo:{}
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
        encoder(info: String, password: String) {
            const infoEncode: String = window.btoa(`${info}:${password}`)
            return infoEncode
        }
    }
})