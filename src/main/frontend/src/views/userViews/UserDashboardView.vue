<script lang="ts" setup>

import { useAuthStore } from '@/stores/AuthStore';
import UserService from '@/apiCall/services/UserService';
import { useUserStore } from '@/stores/userStore';
import { onBeforeMount } from 'vue';
import UserInfoComponent from '@/components/userCoponents/UserInfoComponent.vue';

const authStore = useAuthStore();
const userStore = useUserStore();


onBeforeMount(async () => {
    userStore.obtainBasicInfo(authStore.username)
    console.log(userStore.userBasicInfo);

})

const updateInfo = (isUpdated:boolean)=>{

    if(isUpdated) userStore.obtainBasicInfo(authStore.username)

}

</script>
<template>
    <div class="user-info-view-wrapper">
        <div class="info-space">
            <UserInfoComponent :info="userStore.userBasicInfo"
            @info-updated="updateInfo" />
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;
.user-info-view-wrapper{
    width: 100%;

    @include flexDisplay(row, center, center);

    .info-space{
        width: 100%;
        height: 100vh;
    }
}
@media (min-width: 801px) {

    .user-info-view-wrapper{
    .info-space{
      width: 50%;
      height: 90vh;
    }
  }
}
</style>