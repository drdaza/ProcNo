<script lang="ts" setup>
import { RouterLink } from 'vue-router';
import LandingComponent from '../components/LandingComponent.vue'
</script>
<template>
  <main>
    <div class="landing-space">
        <LandingComponent/>
    </div>
  </main>
</template>

<style lang="scss" scoped>
@use '../assets/styles/main' as *;
main {
  width: 100%;
  height: auto;
  @include flexDisplay(row, center, center);

  .landing-space{
    width: 100%;
    height: 100vh;
  }
}
@media (min-width: 801px) {
  main{
    height: 100vh;
    .landing-space{
      width: 40%;
      height: 60vh;
    }
  }
}
</style>