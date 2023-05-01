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
    
</style>