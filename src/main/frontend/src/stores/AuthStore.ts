import { defineStore } from "pinia";
import Repository from "@/apiCall/Repository";

export const useAuthStore = defineStore('authStore',{
    state: ()=>({
        statusLogin: 0,
        roleLogin: '',
        isAuthenticate: false,
        username: ''
    }),
    actions:{
        async login(username:String, password:String){

            const encodeInfo = this.encoder(username,password)

            const repository = new Repository('auth')

            const service = repository.chooseApi()


            const response = await service?.login(encodeInfo)

            this.username = response.username
            this.roleLogin = response.role
            this.isAuthenticate = true;

            if(this.username != '') return 'auth'
        },
        encoder(username:String, password:String){
            const infoEncode:String = window.btoa(`${username}:${password}`)
            return infoEncode
        }
    }

})