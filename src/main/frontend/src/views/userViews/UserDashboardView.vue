<script lang="ts" setup>
import { useAuthStore } from '@/stores/AuthStore';

const authStore = useAuthStore();


</script>
<template>
    <h1>hi {{ authStore.username }}</h1>
</template>