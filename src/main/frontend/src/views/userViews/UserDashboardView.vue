<script lang="ts" setup>

import { useAuthStore } from '@/stores/AuthStore';
import UserService from '@/apiCall/services/UserService';

const authStore = useAuthStore();

const userServiceTest:UserService = new UserService();

userServiceTest.userInfo(authStore.username);

</script>
<template>

    <h1>hi {{ authStore.username }}</h1>

    
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;


</style>