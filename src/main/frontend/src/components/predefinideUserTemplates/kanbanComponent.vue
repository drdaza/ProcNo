<script lang="ts" setup>
import { ref } from 'vue';
import StateBoxes from '../basicComponents/StateBoxes.vue';
import CreateTaskComponent from '@/components/basicComponents/CreateTaskComponent.vue'
import { computed } from 'vue';
import { reactive } from 'vue';
import StateSelectorComponent from '../basicComponents/StateSelectorComponent.vue';
const props = defineProps({
    kanban: {
        type: Object as any
    }
})
const stateBoxEmitedId = ref(0)
const showModal = ref(false)
const showModalChangeState = ref(false)
let stateFromIdAndTaskId = reactive({
    idStateFrom: 0,
    idStateTo: 0,
    idTask: 0
})


const sendToBack = computed(()=>{
    return (showModal.value===true)? 'send-to-back': ''
})
const emits = defineEmits(['addTaskEmit', 'editTaskEmit', 'emitChangeTaskState'])
const addTask = (emit:any)=>{
    stateBoxEmitedId.value = emit
    showModal.value = true
}
const emitNewTaskToAdd = (emit:any)=>{
    emits('addTaskEmit', {payload:emit, stateBox: stateBoxEmitedId.value}) 
}
const editTask = (emit:any)=>{
    stateFromIdAndTaskId.idStateFrom= emit.idState
    stateFromIdAndTaskId.idTask = emit.idTask
    showModalChangeState.value = true
} 
const closeModal = ()=>{
    showModal.value = false
    showModalChangeState.value = false
}

const changeTaskState = (emit:any)=>{
    stateFromIdAndTaskId.idStateTo = emit
    emits('emitChangeTaskState', stateFromIdAndTaskId)
    
}
</script>
<template>
    <div v-if="showModal===true" class="create-task-modal">
        <CreateTaskComponent @create-task-emit="emitNewTaskToAdd" @close-modal-emit="closeModal"/>
    </div>
    <div v-if="showModalChangeState === true" class="change-task-state-modal">
        <StateSelectorComponent @emit-state-to-selected="changeTaskState" @close-modal-emit="closeModal" :states="kanban.container.elements"/>
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
.change-task-state-modal{
    position: absolute;
    width: 40%;
    height: 25%;
    top: 25%;
	left: 30%;
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