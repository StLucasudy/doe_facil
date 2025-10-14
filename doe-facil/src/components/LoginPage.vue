<template>
        <img src="./assets/doe_facil.svg">
        <h1>{{ nomeApp }}</h1>
        <button>Login</button>
        <button>Cadastro</button>
</template>

<script setup>
    const nomeApp = 'Doe fácil';
</script>

<style scoped>

    h1 {
     color: rgb(255, 255, 255);
    }
</style>