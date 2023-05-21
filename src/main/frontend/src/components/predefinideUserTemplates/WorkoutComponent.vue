<script lang="ts" setup>
import { computed, ref } from 'vue';
import BoxComponent from '../basicComponents/BoxComponent.vue';
import CreateTaskComponent from '../basicComponents/CreateTaskComponent.vue';
import { reactive } from 'vue';

const props = defineProps({
    workoutPlanner: {
        type: Object as any
    }
})
const showModal = ref(false)
const newElementInfo = ref()

const sendToBack = computed(()=>{
    return (showModal.value===true)? 'send-to-back': ''
})

const closeModal = ()=>{
    showModal.value = false
}
const emits = defineEmits(['emitAddElement'])

const unfold = (emit:any)=>{
    console.log(emit);
}

const addNewElement = (emit:any)=>{
    if(!newElementInfo.value) return
    newElementInfo.value.payload = emit
    newElementInfo.value.typeOfElement ? newElementInfo.value.payload.typeElement = newElementInfo.value.typeOfElement : 'box'

    showModal.value = false

    emits('emitAddElement', newElementInfo.value)
    
}

const addElement = (emit:any)=>{
    showModal.value = true
    if (emit.typeOfElement === undefined) return
    emit.idContainer = props.workoutPlanner.id
    newElementInfo.value = emit
    
    
    // emits('emitAddElement', emit)
}
</script>
<template>
    <div v-if="showModal===true" class="create-task-modal">
        <CreateTaskComponent :title-modal="'Crear nuevo elemento'" :text-create-button="'Crear elemento'" @create-task-emit="addNewElement" @close-modal-emit="closeModal"/>
    </div>
    <div :class="['workout-planner-template-wrapper', sendToBack]">
        <h1>
            {{ workoutPlanner.title }}
        </h1>
        <div class="workout-planner-coontainer">
            <div v-for="element of workoutPlanner.container.elements" class="workouts-box-space">
                <BoxComponent @add-element-emit="addElement" @unfold-emit="unfold" :element="element" />
                
            </div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '@/assets/styles/main' as *;

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
.workout-planner-template-wrapper{
    @include wrapperStyle();
    @include flexDisplay(column, normal, center);
    width: 100%;
    height: 100%;
    gap: 2vh;
    .workout-planner-coontainer{
        @include flexDisplay(column, normal, center);
        width: 100%;
        height: 90%;
        gap: 1vh;
        .workouts-box-space{
            width: 80%;
        }
        
    }
}   

</style>