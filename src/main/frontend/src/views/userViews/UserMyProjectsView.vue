<script lang="ts" setup>
import axios from 'axios';
import { useAuthStore } from '@/stores/AuthStore';
import {useUserStore} from '@/stores/userStore';

const authStore = useAuthStore();
const userStore = useUserStore();

const test = async()=>{
    userStore.createProject(authStore.username)
} 
</script>
<template>

    <h1>this es a user projects view</h1>
    <button @click="test()">create</button>
    
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;


</style>