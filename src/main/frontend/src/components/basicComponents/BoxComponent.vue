<script lang="ts" setup>
import { ref } from 'vue'

const props = defineProps({
    element: {
        type: Object as any
    }
})
const dropdown = ref(false)
const emits = defineEmits(['unfoldEmit', 'reduceEmit'])
const unfoldEmit = () => {
    (dropdown.value == false) ? dropdown.value = true : dropdown.value = false
    emits('unfoldEmit', props.element.id)
}
</script>
<template>
    <div class="dropdown-box-wrapper">
        <div class="title-zone">
            <h1>{{ element.name }}</h1>
        </div>

        <div class="icon-space">
            <v-icon @click="unfoldEmit()" icon="mdi-chevron-down" />
        </div>

    </div>
    <div class="info-element" v-if="dropdown == true">
        <h1>subelement</h1>
        <h1>subelement</h1>
        <h1>subelement</h1>
        <h1>subelement</h1>
        <h1>subelement</h1>
        <h1>subelement</h1>
    </div>
</template>
<style lang="scss" scoped>
@use '@/assets/styles/main' as *;

.dropdown-box-wrapper {
    width: 100%;
    height: 8vh;
    @include gridDisplay(1, 10);
    border: 2px solid black;
    background-color: v-bind('element.color');

    .title-zone {
        width: 100%;
        @include flexDisplay(row, center, center);
        @include border(1, 1, 1, 10)
    }

    .icon-space {
        @include flexDisplay(row, center, center);
        @include border(1, 10, 1, 11);
    }


}

.info-element {
    background-color: red;
    width: 100%;

}
</style>