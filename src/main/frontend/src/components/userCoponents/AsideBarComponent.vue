<script lang="ts" setup>
import { computed, ref } from 'vue';
import openMenuIcon from '../icons/OpenMenuIcon.vue'
import userIcon from '../icons/UserIcon.vue'
import MyProjectsIcon from '../icons/MyProjectsIcon.vue'
import MyFavoritesIcon from '../icons/MyFavoritesIcon.vue'
import NewProjectIcon from '../icons/NewProjectIcon.vue'
import TrashProjectIcon from '../icons/TrashProjectIcon.vue'
const expand = ref(false)


const active = () => {
    (expand.value == false) ? expand.value = true : expand.value = false
}

const classInspector = computed(() => {
    return (expand.value == false) ? 'small' : 'medium';
})
const arrowMenuChanger = computed(() => {
    return (expand.value == false) ? 'rotate' : 'normal';
}) 
</script>
 
<template>
    <div :class="['asidebar-wrapper', classInspector]">
        <openMenuIcon :class="arrowMenuChanger" @click="active()"></openMenuIcon>

        <aside>
            <div class="appear-transition" v-if="classInspector == 'small'">

                <i><userIcon/></i>
                <i><MyProjectsIcon/></i>
                <i><MyFavoritesIcon/></i>
                <i><NewProjectIcon/></i>
                
                <div class="trash-zone">
                    <i><TrashProjectIcon/></i>
                </div>
            </div>
            
            <div class="appear-transition" v-if="classInspector == 'medium'">
                <h1>Usuario</h1>
                <h1>Mis Proyectos</h1>
                <h1>Favoritos</h1>
                <h1>Nueva plantilla</h1>
                <h1>papelera</h1>
            </div>

        </aside>
    </div>
</template>

<style lang="scss" scoped>
.asidebar-wrapper {
    background-color: red;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-end;
    height: 100vh;
}

.small {

    width: 50px;
    transition: 0.5s;

    aside {
        width: 100%;

    }

    .rotate {
        transition: 1s;
        transform: rotate(180deg);
    }

}
.appear-transition{
    animation-duration: 1s;
    animation-name: arrow-menu;
    display: flex;
        flex-direction: column;
        align-items: center;
}
@keyframes arrow-menu{
    from {
        opacity: 0;
    }
    to{
        opacity: 100%;
    }
}
.medium {
    width: 250px;
    transition: 0.5s;

    aside {
        width: 100%;
    }

    .normal {
        transition: 1s;

    }
}</style>
