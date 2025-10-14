<template>
    <main class="welcome-screen">
        <img src="../assets/doe_facil_log.png" alt="logo doe facil" width="300" height="200" />
        <h1>{{ nomeApp }}</h1>
        <button @click="loginCLick">Login</button>
        <br>
        <button @click="cadastroClick">Cadastro</button>
    </main>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const nomeApp = 'Doe fácil';

const loginCLick = () => {
    router.push('/login')
};

const cadastroClick = () => {
    router.push('/cadastro')
};

</script>

<style scoped>
.welcome-screen {
    display: grid;
    /* define que esse elemento é um container de grid, coloca a exibição do elementos um abaixo do outro*/
    justify-items: center;
    /* centraliza os itens dentro do grid no meio do elemento */
    align-content: center;
    border: 5px solid red;
    /* coloca uma borda vermelha de 5px na div*/
    row-gap: 10px;
    /* coloca um espaço de 5px entre cada elemento*/
        
}

button {
    background-color: black;
    /* cor de fundo do botão */
    color: beige;
    /* cor dp texto do botão */
    padding: 10px 60px;
    /* controla o espaço interno do botão entre o conteudo e borda */
    border-radius: 22px;
    /* Arredonda a extremidade do botão, não deixa com "pontas" */
    cursor: pointer;
    /* ao posicionar o mouse sobre o botão, o cursor muda */
}

h1 {
    color: black;
}
</style>