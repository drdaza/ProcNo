<script lang="ts" setup>
import StateBoxes from '../basicComponents/StateBoxes.vue';

const props = defineProps({
    kanban: {
        type: Object as any
    }
})
const test = (emit:any)=>{
    console.log(emit); 
} 
</script>
<template>
    <div class="kanban-container">
        <div class="state-box-space" v-for="state of kanban.container.elements">
            <StateBoxes @emit-add-element="test" :state="state" />
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

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