<script lang="ts" setup>
import { useUserStore } from '@/stores/userStore';
import { onBeforeMount } from 'vue';
import { useRoute } from 'vue-router';
import kanbanComponent from '@/components/predefinideUserTemplates/kanbanComponent.vue';
import CreateTaskPayload from '@/apiCall/payloads/CreateTaskPayload';
import { useAuthStore } from '@/stores/AuthStore';

const route = useRoute()
const userStore = useUserStore()
const authStore = useAuthStore()

onBeforeMount(() => {
    userStore.findProjectInfo(parseInt(route.params.idProject as string))
})

const addTask = (emit:any)=>{
    const payload = new CreateTaskPayload(emit.payload.name, emit.payload.description, 'box', emit.payload.color,emit.payload.fontColor)

    userStore.addNewTask(authStore.username, parseInt(route.params.idProject as string), userStore.temporalProject.id, emit.stateBox, payload)
}
const editTask = (emit:any)=>{
    console.log(emit.idState);
    console.log(emit.idTask);
    
}
const changeTaskState = (emit:any)=>{
    userStore.changeTaskOfState(authStore.username,  parseInt(route.params.idProject as string), userStore.temporalProject.container.id, emit.idStateFrom, emit.idStateTo, emit.idTask)
}
</script>
<template>
    <kanbanComponent @emit-change-task-state="changeTaskState" @add-task-emit="addTask" @edit-task-emit="editTask" :kanban="userStore.temporalProject"/>
</template>
<style lang="scss" scoped></style>