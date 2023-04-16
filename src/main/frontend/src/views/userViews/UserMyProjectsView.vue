<script lang="ts" setup>
import { useAuthStore } from '@/stores/AuthStore';
import { useUserStore } from '@/stores/userStore';
import { onBeforeMount } from 'vue';
import ProjectCardComponent from '@/components/userCoponents/ProjectCardComponent.vue';

const authStore = useAuthStore();
const userStore = useUserStore();

onBeforeMount(async () => {
    userStore.viewAllProjects(authStore.username)
})

</script>
<template>
    <div class="projects-grid">
        
        <div v-for="project of userStore.userAllProjects">
            <ProjectCardComponent :project="project" />
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.projects-grid {
    width: 100%;
    height: 100%;
    @include gridDisplay(2, 2);
    align-items: center;
}
</style>