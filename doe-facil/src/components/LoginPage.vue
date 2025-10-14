<template>
    <main class="myClass">
        <h1>Tela de login</h1>
        <input type="text" id="myCnpj" placeholder="CNPJ"/>
        <input type="text" id="mySenha" placeholder="Senha"/>
        <button @click="execLogin">entrar</button>
    </main>
</template>

<script setup>

    const execLogin = () => {

    }

</script>

<style scoped>

    .myClass {
        display: grid;
        justify-items: center;
        align-content: center;
        border: 5px solid red;
        row-gap: 10px;
        padding: 10px;  
    }

    button {
        background-color: black;
        color: beige;
    }
    
</style>