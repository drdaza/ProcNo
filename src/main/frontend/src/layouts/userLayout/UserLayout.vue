<script lang="ts" setup>
import { RouterLink, RouterView } from 'vue-router'
import AsideBarComponent from '@/components/userCoponents/AsideBarComponent.vue'
import { useRouter } from 'vue-router';
import router from '@/router';

const roouter = useRouter()

const navegateTo = (routeToNavegate: String) => {
    console.log(routeToNavegate);
    router.push({ name: routeToNavegate.toString() })
}
</script>
<template>
    <main>
        <AsideBarComponent @emit-route="navegateTo" />
        <section class="views-section">
            <RouterView />
        </section>
    </main>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;

main {
    width: 100%;
    @include flexDisplay(row, normal, normal);

    .views-section{
        width: 100%;
        @include flexDisplay(row, center, center);
    }
}
</style>