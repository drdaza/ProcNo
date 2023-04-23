<script lang="ts" setup>
import AddNewElement from './AddNewElement.vue'
const props = defineProps({
    state: {
        type: Object as any
    }
})

const emits = defineEmits(['emitAddElement'])

const emitAddElement = () => {
    emits('emitAddElement', props.state.id)
}
</script>
<template>
    <div class="state-box-wrapper" >
        <div class="title-state-box-zone">
            <h3>{{ state.name }}</h3>
        </div>
        <div class="body-state-box-zone">
            <div class="task-boxes-space" v-for="taskBox of state.subElements"></div>
            <div class="add-zone">
                <AddNewElement @addnew-element="emitAddElement"/>
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
    background-color: v-bind('state.typeOfElement.color');
    border-radius: 70px;

    .body-state-box-zone {
        width: 100%;
        height: 100%;
        @include flexDisplay(row, flex-start, flex-start);
        background-color: v-bind('state.typeOfElement.color');
        border-radius: 70px;

        .add-zone {
            width: 30%;
            height: 30%;
            border: black 2px dashed;
        }

        .add-zone:hover{
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
        background-color: v-bind('state.typeOfElement.color');
        border-radius: 70px;

        .body-state-box-zone {
            width: 100%;
            height: 100%;
            @include flexDisplay(column, normal, center);
            background-color: v-bind('state.typeOfElement.color');
            border-radius: 70px;

            .add-zone {
                width: 60%;
                height: 20%;
                border: black 2px dashed;
            }
        }
    }
}</style>