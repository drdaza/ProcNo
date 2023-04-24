<script lang="ts" setup>
import { useAuthStore } from '@/stores/AuthStore';
import { useUserStore } from '@/stores/userStore';
import { onBeforeMount } from 'vue';
import ProjectCardComponent from '@/components/userCoponents/ProjectCardComponent.vue';
import { useRouter } from 'vue-router';

const authStore = useAuthStore();
const userStore = useUserStore();
const router = useRouter();

onBeforeMount(async () => {
    userStore.viewAllProjects(authStore.username)
})

const navigateTo = (navigationData: any) => {
    router.push({ name: 'projectView', params: { idProject: navigationData.idProject, typeContainer: navigationData.containerType } })
}
</script>
<template>
    <div class="my-projects-wrapper">
        <h1>Mis proyectos</h1>
        <div class="projects-grid">

            <div v-for="project of userStore.userAllProjects">
                <ProjectCardComponent @emit-navigation-data="navigateTo" :project="project" />
            </div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.my-projects-wrapper {
    @include flexDisplay(column, normal, center);
    width: 100%;

    .projects-grid {
        width: 100%;
        height: 80%;
        @include gridDisplay(auto-fit, 1);
        align-items: center;
    }
}

@media (min-width: 800px) {
    .my-projects-wrapper {
        @include flexDisplay(column, normal, center);
        width: 100%;

        .projects-grid {
            width: 100%;
            height: 100%;
            @include gridDisplay(auto-fit, 2);
            align-items: center;
        }
    }
}</style>