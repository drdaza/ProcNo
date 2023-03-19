<script lang="ts" setup>
import RegisterComponent from '@/components/RegisterComponent.vue';
</script>
<template>
  <main>
    <div class="register-space">
      <RegisterComponent/>
    </div>
  </main>
</template>

<style lang="scss">
@use '../assets/styles/main' as *;
main {
  width: 100%;
  height: auto;
  @include flexDisplay(row, center, center);

  .register-space{
    width: 100%;
    height: 150vh;
  }
}
@media (min-height: 586px){
  main {
  .register-space{
    height: 100vh;
  }
}
}
@media (min-width: 801px) {
  main{
    height: 100vh;
    .register-space{
      width: 50%;
      height: 90vh;
    }
  }
}
</style>
