<script lang="ts" setup>import { computed, ref } from 'vue';

const expand = ref(false)


const active = ()=>{
    (expand.value==false) ? expand.value=true: expand.value=false  
}

const classInspector = computed(()=>{
    return (expand.value==false) ? 'small':'medium';
})
</script>
 
<template>
    <div :class="['asidebar-wrapper', classInspector]"  >
        <h1 @click="active()">=></h1>
       <aside>
        <h1>hola</h1>
        <h1>hola</h1>
       </aside>
    </div>
</template>

<style lang="scss" scoped>
.asidebar-wrapper{
    background-color: red;
    height: 100vh;
}
.small{
    width: 50px;
    transition: 1s;
    aside{
        width: 100%;
    }
}
.medium{
    width: 250px;
    transition: 1s;
    aside{
        width: 100%;
    }
}
</style>
