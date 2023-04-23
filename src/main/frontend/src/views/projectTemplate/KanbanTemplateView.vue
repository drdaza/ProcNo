<script lang="ts" setup>
import { useUserStore } from '@/stores/userStore';
import { onBeforeMount } from 'vue';
import { useRoute } from 'vue-router';
import kanbanComponent from '@/components/predefinideUserTemplates/kanbanComponent.vue';

const route = useRoute()
const userStore = useUserStore()

onBeforeMount(() => {
    userStore.findProjectInfo(parseInt(route.params.idProject as string))
})

const addTask = (emit:any)=>{
    console.log(emit);
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