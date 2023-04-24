<script lang="ts" setup>
import { useAuthStore } from '@/stores/AuthStore';
import { useUserStore } from '@/stores/userStore';
import CreationOptionComponent from '@/components/userCoponents/CreationOptionComponent.vue';

const authStore = useAuthStore();
const userStore = useUserStore();
const test = async () => {
    userStore.createProject(authStore.username)
} 
</script>
<template>
    <div class="user-create-project-wrapper">
        <div class="option-space">
            <CreationOptionComponent />
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

.user-create-project-wrapper {
    width: 100%;
    @include flexDisplay(column, center, center);

    .option-space {
        width: 100%;
        height: 100vh;
    }
}

@media (min-width: 801px) {

    .user-create-project-wrapper {
        .option-space {
            width: 50%;
            height: 60vh;
        }
    }
}
</style>