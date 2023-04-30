<script lang="ts" setup>
import { useAuthStore } from '@/stores/AuthStore';
import { useUserStore } from '@/stores/userStore';

const authStore = useAuthStore();
const userStore = useUserStore();
const emits = defineEmits(['emitKanban', 'emitWorkout'])

const emitOption = (typeOfProject:String)=>{
    if(typeOfProject === 'workoutPlanner') emits('emitWorkout', typeOfProject)
    if(typeOfProject === 'Kanban') emits('emitKanban', typeOfProject)
}
const test = async () => {
    userStore.createProject(authStore.username, 'Kanban')
} 
</script>
<template>
    <div class="options-wrapper">
        <div class="title-zone">
            <h1>Crear una nueva plantilla</h1>
        </div>
        <div class="creation-options-zone">
            <div class="creation-option" @click="emitOption('Kanban')">Kanban</div>
            <div class="creation-option">Hoja en blanco</div>
            <div class="creation-option"  @click="emitOption('workoutPlanner')">Entrenamientos</div>
            <div class="creation-option">Mas...Proximamente</div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.options-wrapper {
    @include wrapperStyle();
    @include gridDisplay(10, 1);

    .title-zone {
        width: 80%;
        @include flexDisplay(row, center, center);
        @include border(2, 1, 3, 1);
        border: white solid 2px;
        align-self: center;
        justify-self: center;
    }

    .creation-options-zone {
        width: 80%;
        @include flexDisplay(column, center, center);
        @include border(4, 1, 8, 1);
        row-gap: 4vh;
        justify-self: center;

        .creation-option {
            width: 100%;
            @include flexDisplay(column, center, center);
            font-weight: bolder;
            border: white solid 2px;

        }
    }

}

@media (min-width: 800px) {
    .options-wrapper {
        transition: 1s;
        border-radius: 70px;
    }
}</style>