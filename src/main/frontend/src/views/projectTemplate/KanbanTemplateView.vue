<script lang="ts" setup>
import { useUserStore } from '@/stores/userStore';
import { onBeforeMount } from 'vue';
import { useRoute } from 'vue-router';
import kanbanComponent from '@/components/predefinideUserTemplates/kanbanComponent.vue';

const route = useRoute()
const userStore = useUserStore()

onBeforeMount(() => {
    userStore.findProjectInfo(parseInt(route.params.idProject as string))
})
</script>
<template>
    <kanbanComponent :kanban="userStore.temporalProject"/>
</template>
<style lang="scss" scoped></style>