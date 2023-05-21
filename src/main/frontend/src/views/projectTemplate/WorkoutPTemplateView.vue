<script lang="ts" setup>
import CreateTaskPayload from '@/apiCall/payloads/CreateTaskPayload';
import WorkoutComponent from '@/components/predefinideUserTemplates/WorkoutComponent.vue';
import { useAuthStore } from '@/stores/AuthStore';
import { useUserStore } from '@/stores/userStore';
import { onBeforeMount } from 'vue';
import { useRoute } from 'vue-router';
const route = useRoute()
const userStore = useUserStore()
const authStore = useAuthStore()

onBeforeMount(() => {
    userStore.findProjectInfo(parseInt(route.params.idProject as string))
})

const addNewElementToWorkoutTemplate = (emit:any) => {    
    userStore.addNewTask(authStore.username, parseInt(route.params.idProject as string), emit.idContainer, emit.idOfBox, new CreateTaskPayload('test', 'estos es un test', emit.typeOfElement, 'green', 'black') )
    userStore.findProjectInfo(parseInt(route.params.idProject as string))
} 
</script>
<template>
    <WorkoutComponent :workout-planner="userStore.temporalProject"
        @emit-add-element="addNewElementToWorkoutTemplate"/>
</template>
<style lang="scss" scoped></style>