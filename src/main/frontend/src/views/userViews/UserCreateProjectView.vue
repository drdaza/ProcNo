<script lang="ts" setup>
import { useAuthStore } from '@/stores/AuthStore';
import {useUserStore} from '@/stores/userStore';

const authStore = useAuthStore();
const userStore = useUserStore();
const test = async()=>{
    userStore.createProject(authStore.username)
} 
</script>
<template>
    <div>
        <button @click="test()">create</button>
    </div>
</template>
<style lang="scss" scoped>
    
</style>