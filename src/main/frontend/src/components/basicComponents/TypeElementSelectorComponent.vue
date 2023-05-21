<script lang="ts" setup>
import { useCreationStore } from '@/stores/creationElementStore';
import { onBeforeMount } from 'vue';
import AddNewElement from './AddNewElement.vue'
import CreateElementComponentVue from './CreateElementComponent.vue'
import { ref } from 'vue';

const creationElementStore = useCreationStore()
const typeOfElementSelection = ref()

onBeforeMount( async () => {
    await creationElementStore.listAllTypesOfElements()
})

const emits = defineEmits(['addElementEmit'])

const addNewElement = ()=>{
    if(typeOfElementSelection.value != '') emits('addElementEmit', typeOfElementSelection.value)
}
const chooseTypeOfElement = (emit:any)=>{
    typeOfElementSelection.value = emit
}
</script>
<template>
    <div class="type-element-selector-wrapper">
        <CreateElementComponentVue :types-of-elements="creationElementStore.allTypesOfElement" @emit-selection="chooseTypeOfElement"/>
        <AddNewElement @addnew-element="addNewElement()"/>
    </div>
</template>
<style lang="scss" scoped>
@use '@/assets/styles/main' as *;

.type-element-selector-wrapper{
    @include flexDisplay(row, space-around, center);
    width: 100%;
}

</style>