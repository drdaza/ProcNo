<script lang="ts" setup>
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
<style lang="scss" scoped></style>