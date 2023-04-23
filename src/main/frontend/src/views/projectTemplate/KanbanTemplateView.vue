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
    const payload = new CreateTaskPayload('pasear al perro', 'pasear', 'box', 'red','white')

    userStore.addNewTask(authStore.username, parseInt(route.params.idProject as string), userStore.temporalProject.id, emit, payload)
}
const editTask = (emit:any)=>{
    console.log(emit.idState);
    console.log(emit.idTask);
    
}
</script>
<template>
    <kanbanComponent @add-task-emit="addTask" @edit-task-emit="editTask" :kanban="userStore.temporalProject"/>
</template>
<style lang="scss" scoped></style>