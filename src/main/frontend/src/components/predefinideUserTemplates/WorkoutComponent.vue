<script lang="ts" setup>
const props = defineProps({
    workoutPlanner: {
        type: Object as any
    }
})
</script>
<template>
    <h1>
       {{ workoutPlanner.title }}
    </h1>
</template>