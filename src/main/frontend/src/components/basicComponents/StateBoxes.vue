<script lang="ts" setup>
import { ref } from 'vue'
import AddNewElement from './AddNewElement.vue'
import TaskBoxComponent from './TaskBoxComponent.vue'
const props = defineProps({
    state: {
        type: Object as any
    }
})
const emits = defineEmits(['emitAddElement','emitEditTask'])

const emitAddElement = () => {
    emits('emitAddElement', props.state.id)
}
const editTask = (idTask:Number)=>{
    emits('emitEditTask',{idState:props.state.id, idTask:idTask})
}
</script>
<template>
    <div class="state-box-wrapper">
        <div class="title-state-box-zone">
            <h3>{{ state.name }}</h3>
        </div>
        <div class="body-state-box-zone">
            <div class="task-boxes-space" v-for="taskBox of state.subElements">
                <TaskBoxComponent :task="taskBox" @edit-task-emit="editTask"/>
            </div>
            <div class="add-zone">
                <AddNewElement @addnew-element="emitAddElement" />
            </div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.state-box-wrapper {
    width: 100%;
    height: 100%;
    @include flexDisplay(column, normal, center);
    background-color: v-bind('state.color');
    border-radius: 10px;

    .body-state-box-zone {
        width: 95%;
        height: 95%;
        @include flexDisplay(row, flex-start, flex-start);
        gap: 2%;
        flex-wrap: wrap;
        background-color: v-bind('state.color');
        border-radius: 10px;

        .add-zone {
            width: 30%;
            height: 30%;
            border: black 2px dashed;
        }

        .task-boxes-space {
            width: 30%;
            height: 30%;
            border: 1px solid black;
            border-radius: 10px;
            overflow: hidden;
        }

        .add-zone:hover {
            transition: 0.5s;
            border-color: cadetblue;
        }
    }
}



@media (min-width: 800px) {
    .state-box-wrapper {
        width: 100%;
        height: 100%;
        @include flexDisplay(column, normal, center);
        background-color: v-bind('state.color');
        border-radius: 10px;

        .body-state-box-zone {
            width: 100%;
            height: 100%;
            @include flexDisplay(column, normal, center);
            gap: 2%;
            background-color: v-bind('state.color');
            border-radius: 10px;

            .add-zone {
                width: 60%;
                height: 20%;
                border: black 2px dashed;
            }

            .task-boxes-space {
                width: 60%;
                height: 20%;
                border: 1px solid black;
                
            }
        }
    }
}
</style>