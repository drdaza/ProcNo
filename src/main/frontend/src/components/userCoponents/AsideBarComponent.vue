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

const emits = defineEmits(['emitRoute'])

const emitRoute = (routeToNavigate: String)=>{
    emits('emitRoute', routeToNavigate)
}
</script>
 
<template>
    <div :class="['asidebar-wrapper', classInspector]">
        <openMenuIcon :class="arrowMenuChanger" @click="active()"></openMenuIcon>

        <aside>
            <div class="appear-transition" v-if="classInspector == 'small'">

                <i @click="emitRoute('dashbboardUser')"><userIcon/></i>
                <i @click="emitRoute('myProjects')"><MyProjectsIcon/></i>
                <i @click="emitRoute('favorites')"><MyFavoritesIcon/></i>
                <i @click="emitRoute('newProject')"><NewProjectIcon/></i>
                
                <div class="trash-zone">
                    <i @click="emitRoute('trash')"><TrashProjectIcon/></i>
                </div>
            </div>
            
            <div class="appear-transition" v-if="classInspector == 'medium'">
                <h1 @click="emitRoute('dashbboardUser')">Usuario</h1>
                <h1 @click="emitRoute('myProjects')">Mis Proyectos</h1>
                <h1 @click="emitRoute('favorites')">Favoritos</h1>
                <h1 @click="emitRoute('newProject')">Nueva plantilla</h1>
                <h1 @click="emitRoute('trash')">papelera</h1>
            </div>

        </aside>
    </div>
</template>

<style lang="scss" scoped>
.asidebar-wrapper {
    background-color: gainsboro;
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
