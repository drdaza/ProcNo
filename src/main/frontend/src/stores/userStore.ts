import { defineStore } from "pinia";
import Repository from "@/apiCall/Repository";

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
        }
    }
})