<script lang="ts" setup>
import { computed, ref, watchEffect} from 'vue';
import { useAuthStore } from '@/stores/AuthStore';

const AuthStore = useAuthStore()
let username = ref('')
let email = ref('')
let repeatEmail = ref('')
let password = ref('')
let repeatPassword = ref('')
let register = ref(false)

const rulesUsername = [
    (value: string) => !!value || 'Username is required.',
    (value: string) => value.length <= 20 || 'Username must be less than 20 characters.',
    (value: string) => /[^0-9]/.test(value) || "Username can not contain only digits.",
    (value: string) => value.length > 3 || 'Username must not be less than 3 characters.'
];
const rulesPassword = [
    (value: string) => !!value || 'Password is required.',
    (value: string) => /\w\d+/.test(value) == true || "Password should contain digits and alphanumerics.",
    (value: string) => value.length >= 8 || 'Password must not be less than 8 characters.'
];
const rulesEmail = [
    (value: string) => !!value || 'Email is Required',
    (value: string) => /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/.test(value) || 'Should be an email'
]


watchEffect(()=>{
    if(email.value != '' && password.value!='') register.value=true
})

const canRegister = computed(()=>{
    return (register.value && email.value===repeatEmail.value && password.value===repeatPassword.value) ? false : true
})

const makeRegister =()=>{
    AuthStore.register(username.value,password.value,email.value)
}
</script>
<template>
    <div class="register-wrapper">
        <h1>ProcNo</h1>
        <p>primera frase</p>
        <div class="input-zone">
            <div class="wrapper-text-field">
                <v-text-field 
                    v-model="username"
                    :bg-color="'white'" 
                    :clearable="true" 
                    :variant="'solo'" 
                    label="Enter your username"
                    :rules="rulesUsername"
                    counter="20"
                    >
                </v-text-field>
            </div>
            <div class="wrapper-text-field">
                <v-text-field 
                    v-model="email"
                    :bg-color="'white'" 
                    :clearable="true" 
                    :variant="'solo'" 
                    label="Enter your Email"
                    :rules="rulesEmail"
                    counter="20"
                    type="email"
                    >
                </v-text-field>
            </div>
            <div class="wrapper-text-field">
                <v-text-field 
                    v-model="repeatEmail"
                    :bg-color="'white'" 
                    :clearable="true" 
                    :variant="'solo'" 
                    label="Repeat your Email"
                    :rules="rulesEmail"
                    counter="20"
                    type="email"
                    >
                </v-text-field>
            </div>
            <div class="wrapper-text-field">
                <v-text-field 
                    v-model="password"
                    :bg-color="'white'" 
                    :clearable="true" 
                    :variant="'solo'" 
                    label="Enter your password"
                    :rules="rulesPassword"
                    counter="20"
                    type="password"
                    >
                </v-text-field>
            </div>
            <div class="wrapper-text-field">
                <v-text-field 
                    v-model="repeatPassword"
                    :bg-color="'white'" 
                    :clearable="true" 
                    :variant="'solo'" 
                    label="Repeat your password"
                    :rules="rulesPassword"
                    counter="20"
                    type="password"
                    >
                </v-text-field>
            </div>
        </div>
        <div class="button-zone">
            <v-btn :width="'50%'" :color="'green'" :disabled="canRegister" @click="makeRegister()">Register</v-btn>
        </div>
    </div>
</template>
<style lang="scss">
@use '../assets/styles/main' as *;
.register-wrapper{
    width: 100%;
    height: 100%;
    @include flexDisplay(column, center, center);
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
@media (min-width: 801px) {
    .register-wrapper{
        transition: 1s;
        border-radius: 70px;
    }
}
    
</style>