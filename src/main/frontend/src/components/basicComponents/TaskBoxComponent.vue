<script lang="ts" setup>
const props =defineProps({
    task: {
        type: Object as any,
        required: true
    }
})

const emits = defineEmits(['editTaskEmit'])

const editTastEmit = ()=>{
    emits('editTaskEmit', props.task.id)
}
</script>
<template>
    <div class="task-box-wrapper">
        <div class="principal-zone">
            <h3>{{ task.name }}</h3>
            <v-icon :icon="'mdi-dots-vertical'" :size="'xs'" @click="editTastEmit()"></v-icon>
        </div>
        <div class="description-zone">
            <p v-for="info of task.info">{{ info.content }}</p>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.task-box-wrapper{
    @include flexDisplay(column, normal, center);
    width: 100%;
    height: 100%;
    background-color: v-bind('task.color');
    color: v-bind('task.fontColor');
    .principal-zone{
        width: 100%;
        display: grid;
        grid-template-columns: 90% 10%;
        align-items: center;
        h3{
            text-align: center;
        }
    }
}
.task-box-wrapper:hover{
    transition: 0.3s;
    filter: brightness(150%);
    cursor: pointer;
}
</style>