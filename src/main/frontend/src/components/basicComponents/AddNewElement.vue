<script lang="ts" setup>
const emits = defineEmits(['addnewElement'])

const emitAddElement = ()=>{
    emits('addnewElement', 'add')
}
</script>
<template>
    <div @click="emitAddElement()" class="add-component-wrapper">
        <v-icon  :icon="'mdi-plus-box'" :size="'x-large'"></v-icon>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;
    .add-component-wrapper{
        width: 100%;
        height: 100%;
        @include flexDisplay(row, center, center);
        
    }
    .add-component-wrapper:hover{
        transition: 0.4s;
        color: cadetblue;
        cursor: pointer;
    }
</style>