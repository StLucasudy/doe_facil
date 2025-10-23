<template>
    <div class="view">
        <section class="container glass w-auto !p-0 min-w-[30em]">

            <!-- TELA INICIAL (Histórico) -->
            <div v-if="telaAtual === 'historico'">
                <div class="bg-black flex justify-center rounded-t-3xl py-10">
                    <Button label="Nova Doação" @click="telaAtual = 'opcoes'"
                        class="!bg-[var(--p-primary-50)] !text-black !rounded-3xl w-full mx-8" icon="pi pi-plus" />
                </div>

                <div class="px-10">
                    <Button @click="router.push('/home')" icon="pi pi-arrow-left" class="!bg-[var(--p-primary-950)] !rounded-3xl mt-5" />
                    <h1 class="text-center my-6 text-2xl font-semibold py-5">Histórico de Doações</h1>

                    <ul v-for="doacao in doacoes" :key="doacao.id"
                        class="border-2 border-black m-6 p-4 rounded-xl grid grid-cols-2 gap-4 [&>div]:flex [&>div]:flex-col [&>div]:justify-center">
                        <!-- Coluna 1: Tipo + mensagem -->
                        <div>
                            <li>{{ doacao.tipo }}</li>
                            <li><small>{{ doacao.mensagem }}</small></li>
                        </div>

                        <!-- Coluna 2: Código + doador -->
                        <div class="items-end">
                            <li>Cód: #{{ doacao.id }}</li>
                            <li><small>por {{ doacao.doador }}</small></li>
                        </div>
                    </ul>
                </div>
            </div>

            <!-- OPÇÕES DE DOAÇÃO -->
            <div v-else-if="telaAtual === 'opcoes'" class="flex flex-col w-full my-10">
                <div class="flex justify-center items-center relative">
                    <Button @click="telaAtual = 'historico'"
                        class="!bg-[var(--p-primary-950)] !rounded-3xl m-6 absolute right-[41%]"
                        icon="pi pi-chevron-left" />
                    <h1 class="absolute left-[25%] w-full">Nova Doação</h1>
                </div>

                <div class="flex flex-col gap-5 mt-10">
                    <Button label="Nova doação de Bem" @click="telaAtual = 'doacaoBem'"
                        class="!bg-[var(--p-primary-950)] !rounded-3xl mx-6" icon="pi pi-plus" />
                    <Button label="Nova doação Monetária" @click="telaAtual = 'doacaoMonetaria'"
                        class="!bg-[var(--p-primary-950)] !rounded-3xl mx-6" icon="pi pi-plus" />
                </div>
            </div>

            <!-- DOAÇÃO DE BEM -->
            <div v-else-if="telaAtual === 'doacaoBem'" class="flex flex-col w-full my-10">
                <div class="flex justify-center items-center relative">
                    <Button @click="telaAtual = 'opcoes'"
                        class="!bg-[var(--p-primary-950)] !rounded-3xl m-6 absolute right-[41%]"
                        icon="pi pi-chevron-left" />
                    <h1 class="absolute left-[20%] w-full">Doação de Bem</h1>
                </div>

                <div class="mt-10 text-center flex flex-col gap-5 mx-20">
                    <FloatLabel variant="on">
                        <InputText />
                        <label>Opções de Bem</label>
                    </FloatLabel>
                    <FloatLabel variant="on">
                        <InputText />
                        <label>Descrição</label>
                    </FloatLabel>
                    <FloatLabel variant="on">
                        <InputNumber mask="integer" />
                        <label>Quantidade</label>
                    </FloatLabel>

                    <div class="flex items-center gap-3">
                        <Checkbox />
                        <label>Anônimo</label>
                    </div>

                    <FloatLabel variant="on">
                        <InputText />
                        <label>Nome do Doador</label>
                    </FloatLabel>
                    <FloatLabel variant="on">
                        <InputText />
                        <label>Nome do Colaborador</label>
                    </FloatLabel>

                    <Button label="Registrar Doação" class="!bg-[var(--p-primary-950)] !rounded-3xl mt-5"
                        icon="pi pi-check" />
                </div>
            </div>

            <!-- DOAÇÃO MONETÁRIA -->
            <div v-else-if="telaAtual === 'doacaoMonetaria'" class="flex flex-col w-full my-10">
                <div class="flex justify-center items-center relative">
                    <Button @click="telaAtual = 'opcoes'"
                        class="!bg-[var(--p-primary-950)] !rounded-3xl m-6 absolute right-[41%]"
                        icon="pi pi-chevron-left" />
                    <h1 class="absolute left-[15%] w-full">Doação Monetária</h1>
                </div>


                <div class="mt-10 text-center flex flex-col gap-5 mx-20">
                    <FloatLabel variant="on">
                        <InputNumber mask="currency" />
                        <label>Valor</label>
                    </FloatLabel>
                    <FloatLabel variant="on">
                        <InputText />
                        <label>Maneira de Doação</label>
                    </FloatLabel>

                    <div class="flex items-center gap-3">
                        <Checkbox />
                        <label>Anônimo</label>
                    </div>

                    <FloatLabel variant="on">
                        <InputText />
                        <label>Nome do Doador</label>
                    </FloatLabel>
                    <FloatLabel variant="on">
                        <InputText />
                        <label>Nome do Colaborador</label>
                    </FloatLabel>

                    <Button label="Registrar Doação" class="!bg-[var(--p-primary-950)] !rounded-3xl mt-5"
                        icon="pi pi-check" />
                </div>
            </div>

        </section>
    </div>
</template>

<script setup lang="ts">
import { Button, Checkbox, FloatLabel, InputNumber, InputText } from 'primevue';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

// controle de telas
const telaAtual = ref<'historico' | 'opcoes' | 'doacaoBem' | 'doacaoMonetaria'>('historico');

// dados fictícios
const doacoes = [
    {
        id: 1234,
        tipo: "Doação monetária",
        moeda: "BRL",
        doador: "Ana Souza",
        data: "2025-10-15T14:32:00Z",
        mensagem: "Feliz em contribuir com a causa!",
        metodo_pagamento: "Cartão de Crédito",
        status: "Confirmada"
    },
    {
        id: 4567,
        tipo: "Doação de Bem",
        moeda: "BRL",
        doador: "José",
        data: "2025-10-15T14:32:00Z",
        mensagem: "Doando com gratidão!",
        metodo_pagamento: "Cartão de Crédito",
        status: "Confirmada"
    },
    {
        id: 8910,
        tipo: "Doação monetária",
        moeda: "BRL",
        doador: "Souza",
        data: "2025-10-15T14:32:00Z",
        mensagem: "Sempre ajudando!",
        metodo_pagamento: "Cartão de Crédito",
        status: "Confirmada"
    },
];
</script>

<style scoped lang="scss"></style>
