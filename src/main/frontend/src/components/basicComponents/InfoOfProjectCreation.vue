<script lang="ts" setup>
import BasicInfoProjectPayload from '@/apiCall/payloads/BasicInfoProjectPayload';
import { reactive } from 'vue';

let infoForNewProject = reactive({
    nameProject : '',
    descriptionProject: ''
})

const emits = defineEmits(['creationProjectInfo', 'closeModal'])

const emitInfoProject = ()=>{
    emits('creationProjectInfo', infoForNewProject)
}

const emitCloseModal = ()=>{
    emits('closeModal')
}
</script>
<template>
    <div class="wrapper-info-creation-project">
        <div class="close-icon">
            <v-icon :icon="'mdi-close'" @click="emitCloseModal()"></v-icon>
        </div>

        <h1>Información del proyecto</h1>
        <div class="input-zone">
            <input class="info-element" type="text" placeholder="Nombre del proyecto" v-model="infoForNewProject.nameProject">
            <input class="info-element" type="text" placeholder="Descripción del proyecto" v-model="infoForNewProject.descriptionProject">
        </div>

        <div class="button-zone">
            <v-btn :width="'40%'" :color="'green'" @click="emitInfoProject()">Confirmar</v-btn>
            <v-btn :width="'40%'" :color="'red'" @click="emitCloseModal()">Cancelar</v-btn>
        </div>
        
    </div>
</template>
<style lang="scss">
@use '../../assets/styles/main' as *;

.wrapper-info-creation-project {
    @include wrapperStyle();
    @include flexDisplay(column, normal, center);
    border-radius: 10px;
    gap: 1vh;
    border: solid black;

    .close-icon {
        width: 95%;
        @include flexDisplay(row, flex-end, center)
    }

    .input-zone {
        width: 100%;
        @include flexDisplay(column, center, center);
        gap: 1vh;

        .info-element{
            background-color: white;
            box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
            width: 90%;
            height: 6vh;
            text-align: center;
        }

    }

    .button-zone{
        width: 100%;
        @include flexDisplay(row, space-evenly, center);
    }
    
}
</style>