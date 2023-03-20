<script lang="ts" setup>
import AsideBarComponent from '@/components/userCoponents/AsideBarComponent.vue';
import { useAuthStore } from '@/stores/AuthStore';

const authStore = useAuthStore();


</script>
<template>
    <main>
    <AsideBarComponent/>
    <h1>hi {{ authStore.username }}</h1>
    </main>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;
main{
    width: 100%;
    @include flexDisplay(row, normal, normal)
}

</style>