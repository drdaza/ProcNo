<script setup lang="ts">
import LoginComponent from '@/components/LoginComponent.vue';

</script>
<template>
  <main>
    <div class="login-space">
      <LoginComponent />
    </div>
  </main>
</template>
<style lang="scss" scoped>
main {
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;

  .login-space {
    width: 100%;
    height: 100vh;
  }
}
@media(min-width: 800px){
main {
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;

  .login-space {
    width: 60%;
    height: 100vh;
  }
}
}
</style>
