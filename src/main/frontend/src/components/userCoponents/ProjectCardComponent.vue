<script lang="ts" setup>
const props = defineProps({
    project: {
        type: Object,
        required: true
    }
})

const emits = defineEmits(['emitNavigationData'])

const emitNavigationData = ()=>{
    emits('emitNavigationData', { idProject: props.project.id, containerType: props.project.container.types[0].name})
}
</script>
<template>
    <v-card @click="emitNavigationData()" class="mx-auto" max-width="450">
        <v-img class="align-end text-white" height="200" src="https://thumbs.dreamstime.com/b/fondo-blanco-del-ladrillo-textura-y-de-la-pared-133036144.jpg"
            cover></v-img>
        <v-card-title>{{ project.title }}</v-card-title>
    </v-card>
</template>
<style lang="scss" scoped></style>