<script lang="ts" setup>
import { ref } from 'vue';

const props = defineProps({
    typesOfElements: {
        type: Array as any
    }
})
const infoElement = ref('')
const emits = defineEmits(['emitSelection'])
const selection = ()=>{    
    emits('emitSelection', infoElement.value)
}
</script>
<template>
    <div class="create-elements-wrapper">
        <select v-model="infoElement" name="" id="" @change="selection()">
            <option :value="typeOfElement.name" v-for="typeOfElement of typesOfElements">{{ typeOfElement.name }}</option>
        </select>
    </div>
</template>
<style lang="scss" scoped>
@use '@/assets/styles/main' as *;
.create-elements-wrapper {
    @include flexDisplay(row, center, center);
    border: 2px solid black;
    border-radius: 5px;
    width:100%;
    select{
        text-align: center;
    }
}
.create-elements-wrapper:hover {
    border: 2px solid cadetblue;
    cursor: pointer;
    select:hover{
        color: cadetblue;
        cursor: pointer;
    }
}
</style>