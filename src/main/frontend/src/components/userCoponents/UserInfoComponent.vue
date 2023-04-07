<script lang="ts" setup>
import { useAuthStore } from '@/stores/AuthStore';
import { useUserStore } from '@/stores/userStore';
import EditProfilePayload from "@/apiCall/payloads/EditProfilePayload";
import { reactive } from 'vue';
import { ref } from 'vue';

const userStore = useUserStore();
const authStore = useAuthStore();

const props = defineProps({
    info: {
        type: Object,
        required: true
    }
})

const element = reactive({
    email: props.info.email,
    name: props.info.name,
    lastName: props.info.lastName
})

const canEditUser = ref(false)

const emits = defineEmits(['infoUpdated'])

const updateEmit = ()=>{
    emits('infoUpdated', true)
}

const edit = () => {
    (canEditUser.value == false) ? canEditUser.value = true : canEditUser.value = false
}

const sendNewInfoProfile = async ()=>{
    const infoProfile = new EditProfilePayload(element.email, element.name,element.lastName)
    const response = await userStore.editBasicInfo(authStore.username, infoProfile)

    console.log(response);
    
    if(response == 202){
        updateEmit()
        edit()
    }
}
</script>
<template>
    <div class="user-info-wrapper">
        <div class="title-zone">
            <h1>{{ info.username }}</h1>
        </div>
        <div v-if="canEditUser == true" class="secondary-info-zone">
            <input v-model="element.email" class="info-input" type="text"/>
            <input class="info-input" type="text"/>
            <input v-model="element.name" class="info-input" type="text"/>
            <input v-model="element.lastName" class="info-input" type="text"/>
        </div>
        <div v-if="canEditUser == false" class="secondary-info-zone">
            <div class="info-user">{{ info.email }}</div>
            <div class="info-user">Contraseña</div>
            <div class="info-user" v-if="info.name != null">{{ info.name }}</div>
            <div class="info-user" v-if="info.name == null">Nombre</div>
            <div class="info-user" v-if="info.lastName != null">{{ info.lastName }}</div>
            <div class="info-user" v-if="info.lastName == null">Apellido</div>
        </div>
        <div v-if="canEditUser == true" class="button-zone">
            <v-btn :width="'40%'" :color="'green'" @click="sendNewInfoProfile()">Aceptar</v-btn>
            <v-btn :width="'40%'" :color="'green'" @click="edit()">Cancelar</v-btn>
        </div>
        <div v-if="canEditUser == false" class="button-zone">
            <v-btn :width="'80%'" :color="'green'" @click="edit()">Editar</v-btn>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '@/assets/styles/main' as *;

.user-info-wrapper {
    @include wrapperStyle();
    @include gridDisplay(10, 1);

    .title-zone {
        width: 80%;
        @include flexDisplay(row, center, center);
        @include border(1, 1, 2, 1);
        border: white solid 2px;
        align-self: center;
        justify-self: center;
    }

    .secondary-info-zone {
        width: 80%;
        @include flexDisplay(column, center, center);
        @include border(4, 1, 8, 1);
        row-gap: 4vh;
        justify-self: center;

        .info-user {
            width: 100%;
            @include flexDisplay(column, center, center);
            font-weight: bolder;
            border: white solid 2px;
        }

        .info-input{
            width: 100%;
            background-color: white;
            text-align: center;
        }
    }

    .button-zone {
        width: 80%;
        @include border(9, 1, 11, 1);
        @include flexDisplay(row, space-around, center);
        align-self: center;
        justify-self: center;
    }
}

@media (min-width: 800px) {
    .user-info-wrapper {
        transition: 1s;
        border-radius: 70px;
    }
}
</style>