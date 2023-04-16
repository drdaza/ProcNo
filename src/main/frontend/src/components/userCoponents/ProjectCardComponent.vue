<script lang="ts" setup>
const props = defineProps({
    project: {
        type: Object,
        required: true
    }
})
</script>
<template>
    <v-card class="mx-auto" max-width="450">
        <v-img class="align-end text-white" height="200" src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
            cover></v-img>
        <v-card-title>{{ project.title }}</v-card-title>
    </v-card>
</template>
<style lang="scss" scoped></style>