import { defineStore } from "pinia";
import Repository from "@/apiCall/Repository";
import RegisterPayload from "@/apiCall/payloads/RegisterPayload";

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
        async register(username:String, password:String,email:String){

            const firstEncode = this.encoder(username,password)
            const secondEncode = this.encoder(email,password)

            const payLoad = new RegisterPayload(firstEncode,secondEncode)

            console.log(payLoad.getUserPassword);
            console.log(window.atob(payLoad.getEmail));
            
        },
        encoder(username:String, password:String){
            const infoEncode:String = window.btoa(`${username}:${password}`)
            return infoEncode
        }
    }

})