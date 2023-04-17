<script lang="ts" setup>
const props = defineProps({
    elements: {
        type: Array
    }
})
</script>
<template>
    <div class="container-wrapper">
        
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/styles/main' as *;
.container-wrapper{
    width: 100%;
    @include gridDisplay(2, 2);
}
    
</style>