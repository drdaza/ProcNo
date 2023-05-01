import { defineStore } from "pinia";
import Repository from "@/apiCall/Repository";

export const useCreationStore = defineStore('creationElementeStore', {
    state: ()=>({
        service: new Repository('createElement').chooseCreationElementService(),
        allTypesOfElement: [] as any
    }),
    actions:{
        async listAllTypesOfElements(){
            const response = await this.service?.listAllTypesOfElements()

            this.allTypesOfElement = response
        }
    }
})