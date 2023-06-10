<script lang="ts" setup>
import { useAuthStore } from '@/stores/AuthStore'
import { useUserStore } from '@/stores/userStore'
import CreationOptionComponent from '@/components/userCoponents/CreationOptionComponent.vue'
import infoOfProjectCreation from '@/components/basicComponents/infoOfProjectCreation.vue'
import { ref } from 'vue';

const authStore = useAuthStore()
const userStore = useUserStore()
const showModal = ref(false)
const typeOfProject = ref('')

const createProject = (emit:any)=>{
    if(!emit.nameProject || !emit.descriptionProject) return
    userStore.createProject(authStore.username,emit, typeOfProject.value)
    showModal.value = false
}
const closeModal = ()=>{
    showModal.value = false
   
}
const test = (emit:any)=>{
    typeOfProject.value = emit
    showModal.value = true
}
</script>
<template>  
     <div v-if="showModal===true" class="create-task-modal">
        <infoOfProjectCreation @close-modal="closeModal" @creation-project-info="createProject"/>
    </div>
    <div class="user-create-project-wrapper">
        <div class="option-space">
            <CreationOptionComponent @emit-workout="test" @emit-kanban="test"/>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.create-task-modal{
    position: absolute;
    width: 60%;
    height: 30%;
    top: 25%;
	left: 25%;
    z-index: 5;
}
.user-create-project-wrapper {
    height: 100%;
    width: 100%;
    @include flexDisplay(column, center, center);

    .option-space {
        width: 100%;
        height: 100vh;
    }
}

@media (min-width: 801px) {

    .user-create-project-wrapper {
        .option-space {
            width: 50%;
            height: 60vh;
        }
    }
}
</style>