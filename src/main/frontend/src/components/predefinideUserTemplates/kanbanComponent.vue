<script lang="ts" setup>
import { ref } from 'vue';

const props = defineProps({
    kanban:{
        type: Object as any
    }
})

</script>
<template>
    <div class="kanban-container">
        <div class="state-box" v-for="state of kanban.container.elements">
            <h4>{{ state.name }}</h4>
        </div>

    </div>
<!-- {{ kanban.title }} -->
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;
.kanban-container{
    @include gridDisplay(1, auto-fit);
    width: 100%;
    height: 100%;
   
}
</style>