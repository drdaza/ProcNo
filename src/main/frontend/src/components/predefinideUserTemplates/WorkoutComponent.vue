<script lang="ts" setup>
import { ref } from 'vue';
import BoxComponent from '../basicComponents/BoxComponent.vue';

const props = defineProps({
    workoutPlanner: {
        type: Object as any
    }
})

const unfold = (emit:any)=>{
    console.log(emit);
}
const addElement = (emit:any)=>{
    console.log(emit.typeOfElement);
    console.log(emit.idOfBox);
}
</script>
<template>
    <div class="workout-planner-template-wrapper">
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