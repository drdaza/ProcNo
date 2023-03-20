<script lang="ts" setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const redirection = (to:string)=>{
    router.push({name: to})
}
</script>
<template>
    <div class="landing-wrapper">
        <h1>ProcNo</h1>
        <div class="button-zone">
            <v-btn :width="'50%'" :color="'green'" @click="redirection('login')">login</v-btn>
            <v-btn :width="'50%'" :color="'green'" @click="redirection('register')">register</v-btn>
        </div>
        <h1>Gestiona tu tiempo</h1>
    </div>
</template>
<style lang="scss" scoped>
@use '../assets/styles/main' as *;
.landing-wrapper{
    width: 100%;
    height: 100%;
    @include flexDisplay(column, center, center);
    gap: 2vh;
    background-color: gainsboro;
    .button-zone{
        width: 100%;
        @include flexDisplay(column, center, center);
        gap: 2vh;
    }
} 
@media (min-width: 801px) {
    .landing-wrapper{
        transition: 1s;
        border-radius: 70px;
    }
}
</style>