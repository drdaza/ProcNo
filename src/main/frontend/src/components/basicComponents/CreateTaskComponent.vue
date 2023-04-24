<script lang="ts" setup>
import { reactive } from 'vue';

const payload = reactive({
    name: '',
    description: '',
    typeElement: 'box',
    color: '',
    fontColor: ''
})
const emits = defineEmits(['closeModalEmit', 'createTaskEmit'])

const closeModalEmit = ()=>{
    emits('closeModalEmit')
}
const createTaskEmit = ()=>{
    emits('createTaskEmit', payload)
}
</script>
<template>
    <div class="creation-task-wrapper">
        <div class="close-icon">
            <v-icon :icon="'mdi-close'" @click="closeModalEmit()"></v-icon>
        </div>

        <h1>Crear nueva tarea</h1>
        <div class="input-zone">
            <input v-model="payload.name" class="info-task" placeholder="Titulo" type="text">
            <input v-model="payload.description" class="info-task" placeholder="Descripción" type="text">
            <label class="info-task" for="color"> Color de fondo: <input v-model="payload.color" type="color" name="color" id=""></label>
            <label class="info-task" for="font-color"> Color de fuente: <input v-model="payload.fontColor" type="color" name="font-color" id=""></label>
        </div>

        <div class="button-zone">
            <v-btn :width="'40%'" :color="'green'" @click="createTaskEmit()">Crear Tarea</v-btn>
            <v-btn :width="'40%'" :color="'red'" @click="closeModalEmit()">Cancelar</v-btn>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.creation-task-wrapper {
    @include wrapperStyle();
    @include flexDisplay(column, normal, center);
    border-radius: 10px;
    gap: 1vh;

    .close-icon {
        width: 95%;
        @include flexDisplay(row, flex-end, center)
    }

    .input-zone {
        width: 100%;
        @include flexDisplay(column, center, center);
        gap: 1vh;

        .info-task{
            background-color: white;
            box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
            width: 90%;
            height: 6vh;
            text-align: center;
            
        }
        label{
                @include flexDisplay(row, space-around, center)
        }
    }

    .button-zone{
        width: 100%;
        @include flexDisplay(row, space-evenly, center);
    }
}
</style>
