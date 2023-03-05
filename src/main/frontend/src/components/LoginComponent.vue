<script lang="ts" setup>
import { computed, ref } from 'vue';

let username = ref('');
let password = ref('');

const props = defineProps({
    title: {
        type: String,
        default: 'ProcNo'
    },
    firstPhrase: {
        type: String,
        default: 'Optimiza tu vida y forma de trabajo'
    },
    passwordPhrase: {
        type: String,
        default: 'Olvidaste tu contraseña?'
    }
});

const rulesUsername = [
    (value: string) => !!value || 'Username is required.',
    (value: string) => value.length <= 20 || 'Username must be less than 20 characters.',
    (value: string) => /[^0-9]/.test(value) || "Username can not contain only digits.",
    (value: string) => value.length > 3 || 'Username must not be less than 3 characters.'
];
const rulesPassword = [
    (value: string) => !!value || 'Password is required.',
    (value: string) => /\w\d+/.test(value) == true || "Password should contain digits and alphanumerics.",
    (value: string) => value.length > 8 || 'Password must not be less than 8 characters.'
];
</script>
<template>
    <div class="login-wrapper">
        <h1>{{ title }}</h1>
        <p>{{ firstPhrase }}</p>
        <div class="input-zone">
            <div class="wrapper-text-field">
                <v-text-field 
                    v-model="username"
                    :bg-color="'white'" 
                    :clearable="true" 
                    :variant="'solo'" 
                    label="Username"
                    :rules="rulesUsername"
                    counter="20"
                    >
                </v-text-field>
                
            </div>
            <div class="wrapper-text-field">
                <v-text-field 
                    v-model="password"
                    :bg-color="'white'" 
                    :clearable="true" 
                    :variant="'solo'" 
                    label="Password" 
                    type="password"
                    :rules="rulesPassword">
                </v-text-field>
            </div>
        </div>
        <p>{{ passwordPhrase }}</p>
        <div class="button-zone">
            <v-btn :width="'50%'" :color="'green'">Iniciar sesión</v-btn>
        </div>
    </div>
</template>
<style lang="scss" scoped>
.login-wrapper {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: gainsboro;

    .input-zone {
        width: 80%;
        .wrapper-text-field {
            width: 100%;
            margin-top: 3vh;
            overflow: hidden;
        }
    }
    .button-zone{
        width: 100%;
        display: flex;
        justify-content: center;
    }
}
@media (min-width: 800px) {
    .login-wrapper{
        transition: 1s;
        border-radius: 70px;
    }
}
</style>