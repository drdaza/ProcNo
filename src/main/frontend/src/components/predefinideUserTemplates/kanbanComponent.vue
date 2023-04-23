<script lang="ts" setup>
import { ref } from 'vue';
import StateBoxes from '../basicComponents/StateBoxes.vue';
import CreateTaskComponent from '@/components/basicComponents/CreateTaskComponent.vue'
import { computed } from 'vue';
const props = defineProps({
    kanban: {
        type: Object as any
    }
})
const stateBoxEmitedId = ref(0)
const showModal = ref(false)

const sendToBack = computed(()=>{
    return (showModal.value===true)? 'send-to-back': ''
})
const emits = defineEmits(['addTaskEmit', 'editTaskEmit'])
const addTask = (emit:any)=>{
    stateBoxEmitedId.value = emit
    showModal.value = true
}
const emitNewTaskToAdd = (emit:any)=>{
    emits('addTaskEmit', {payload:emit, stateBox: stateBoxEmitedId.value}) 
}
const editTask = (emit:any)=>{
    emits('editTaskEmit', emit)
} 
const closeModal = ()=>{
    showModal.value = false;
}
</script>
<template>
    <div v-if="showModal===true" class="create-task-modal">
        <CreateTaskComponent @create-task-emit="emitNewTaskToAdd" @close-modal-emit="closeModal"/>
    </div>
    <div :class="['kanban-container', sendToBack]">
        <div class="state-box-space" v-for="state of kanban.container.elements">
            <StateBoxes @emit-edit-task="editTask" @emit-add-element="addTask" :state="state" />
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.create-task-modal{
    position: absolute;
    width: 60%;
    height: 50%;
    top: 25%;
	left: 25%;
    z-index: 5;
}

.send-to-back{
    z-index: 1;
    filter: brightness(50%);
    
}
.kanban-container {
    @include gridDisplay(auto-fit, 1);
    width: 100%;
    height: 100%;
    align-items: center;
    justify-items: center;

    .state-box-space{
        width: 90%;
        height: 95%;
        @include flexDisplay(row, center, center)
    }

}

@media (min-width: 800px) {
    .kanban-container {
    @include gridDisplay(1, auto-fit);
    width: 100%;
    height: 100%;
    align-items: center;
    justify-items: center;

    .state-box-space{
        width: 90%;
        height: 95%;
        @include flexDisplay(row, center, center)
    }

}
}
</style>