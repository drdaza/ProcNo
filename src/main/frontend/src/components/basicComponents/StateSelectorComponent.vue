<script lang="ts" setup>
import { ref } from 'vue';

const props = defineProps({
    states:{
        type: Object as any
    }
})
const stateSelectedId = ref()

const emits = defineEmits(['emitStateToSelected','closeModalEmit'])

const closeModalEmit = ()=>{
    emits('closeModalEmit')
}

const stateSelected = ()=>{    
    emits('emitStateToSelected', stateSelectedId.value)
}
</script>
<template>
    <div class="state-selector-wrapper">
        <div class="close-icon">
            <v-icon :icon="'mdi-close'" @click="closeModalEmit()"></v-icon>
        </div>
        <h3>seleccione el estado de la tarea</h3>
        <select class="info-task"  v-model="stateSelectedId" name="" id="" @onchange="stateSelected()">
            <option v-for="state of states" :value="state.id">{{ state.name }}</option>
        </select>
        <div class="button-zone">
            <v-btn :width="'40%'" :color="'green'" @click="stateSelected()">Confirmar</v-btn>

        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.state-selector-wrapper{
    @include wrapperStyle();
    @include flexDisplay(column, normal, center);
    border-radius: 10px;
    gap: 1vh;
    .close-icon {
        width: 95%;
        @include flexDisplay(row, flex-end, center)
    }
    .info-task{
            background-color: white;
            box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
            width: 90%;
            height: 6vh;
            text-align: center;
            
        }
    .button-zone{
        width: 100%;
        @include flexDisplay(row, space-evenly, center);
    }
}
</style>