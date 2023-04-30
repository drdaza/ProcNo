<script lang="ts" setup>
import WorkoutComponent from '@/components/predefinideUserTemplates/WorkoutComponent.vue';
import { useAuthStore } from '@/stores/AuthStore';
import { useUserStore } from '@/stores/userStore';
import { onBeforeMount } from 'vue';
import { useRoute } from 'vue-router';
const route = useRoute()
const userStore = useUserStore()
const authStore = useAuthStore()

onBeforeMount(() => {
    userStore.findProjectInfo(parseInt(route.params.idProject as string))
})

</script>
<template>
    <WorkoutComponent :workout-planner="userStore.temporalProject"/>
</template>
<style lang="scss" scoped></style>