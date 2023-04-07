<script lang="ts" setup>

const props = defineProps({
    info: {
        type: Object,
        required: true
    }
})
</script>
<template>
    <div class="user-info-wrapper">
        <div class="title-zone">
            <h1>{{ info.username }}</h1>
        </div>
        <div class="rest-info-zone">
            <h2>{{ info.email }}</h2>
            <h2>Contraseña</h2>
            <h2 v-if="info.name != null">{{ info.name }}</h2>
            <h2 v-if="info.name == null">Nombre</h2>
            <h2 v-if="info.lastName != null">{{ info.lastName }}</h2>
            <h2 v-if="info.lastName == null">Apellido</h2>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '@/assets/styles/main' as *;

.user-info-wrapper {
    @include wrapperStyle();
    @include gridDisplay(10,1);
    justify-content: center;
    align-content: center;
    .title-zone{

        display: flex;
        justify-content: center;
    }
}

@media (min-width: 800px) {
    .user-info-wrapper {
        transition: 1s;
        border-radius: 70px;
    }
}
</style>