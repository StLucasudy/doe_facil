<template>
  <div class="flex no-wrap min-h-dvh items-stretch">

    <div class="flex flex-col items-center justify-center w-full bg-cover">

      <div class="flex flex-col items-center justify-center rounded-3xl glass relative">
        <div class="flex flex-col justify-center items-center">
          <img src="../../assets/img/doe_facil_log.png" alt="Logo Doar Fácil" class="w-[100px] mx-40 my-5">
          <h3 class="!font-extrabold !text-[var(--p-primary-700)] p-5 textShadow">
            {{ textoExibido }}<span v-if="!finalizado" class="cursor">|</span>
          </h3>
          <!-- @autor: Gabriel -->
        </div>

        <div v-if="login" class="flex flex-col gap-5 w-full items-center">
          <FloatLabel class="w-[75%]" variant="on">
            <InputMask v-model="username" name="login" mask="99.999.999/9999-99" />
            <label> CNPJ </label>
          </FloatLabel>

          <FloatLabel class="w-[75%]" variant="on">
            <Password v-model="password" toggleMask name="senha" class="w-[100%]" :feedback="false"
              @keyup.enter="entrar" />
            <label for="user"> Senha </label>
          </FloatLabel>

          <div class="flex gap-10 w-[72.5%]">
            <Button @click="login = false" label="VOLTAR" class="w-1/2 !rounded-3xl" icon="pi pi-chevron-left"></Button>
            <Button @click="entrar" type="button" label="LOGIN" :loading="loading" icon="pi pi-sign-in"
              class="w-1/2 !bg-[var(--p-primary-950)] !rounded-3xl"></Button>
          </div>
        </div>

        <div v-else-if="cadastro" class="flex flex-col gap-5">
          <FloatLabel variant="on">
            <InputText />
            <label>Nome da ONG</label>
          </FloatLabel>

          <FloatLabel variant="on">
            <InputText />
            <label>Objetivo da ONG</label>
          </FloatLabel>

          <FloatLabel variant="on">
            <InputMask mask="99.999.999/9999-99" />
            <label>CPNJ</label>
          </FloatLabel>

          <FloatLabel variant="on">
            <InputText />
            <label>CEP</label>
          </FloatLabel>



          <FloatLabel variant="on">
            <Password toggleMask name="senha" class="w-full" :feedback="false" />
            <label>Senha</label>
          </FloatLabel>

          <FloatLabel variant="on">
            <Password toggleMask :feedback="false" class="w-full" />
            <label>Confirme sua senha</label>
          </FloatLabel>

          <div class="flex gap-10">
            <Button label="VOLTAR" class="!rounded-3xl" icon="pi pi-chevron-left" @click="cadastro = false" />
            <Button label="PRÓXIMO" class="!bg-[var(--p-primary-950)] !rounded-3xl" icon="pi pi-chevron-right" @click="proximaEtapa = true, cadastro = false" />
          </div>
        
        </div>

        <div v-else-if="proximaEtapa" class="flex flex-col gap-5 w-[75%]">
          <FloatLabel variant="on">
            <InputText />
            <label>E-mail</label>
          </FloatLabel>
          <FloatLabel variant="on">
            <InputText />
            <label>Telefone</label>
          </FloatLabel>
          <FloatLabel variant="on">
            <InputText />
            <label>Nome do responsável</label>
          </FloatLabel>
          <FloatLabel variant="on">
            <InputMask mask="999.999.999-99" />
            <label>CPF</label>
          </FloatLabel>

          <div class="flex gap-10">
            <Button label="VOLTAR" class="!rounded-3xl" icon="pi pi-chevron-left" @click="proximaEtapa = false, cadastro = true" />
            <Button label="CADASTRAR" class="!bg-[var(--p-primary-950)] !rounded-3xl" icon="pi pi-plus" @click="cadastrar" />
          </div>

        </div>

        <div v-else class="flex flex-col gap-5 w-[75%]">
          <Button label="LOGIN" class="!bg-[var(--p-primary-950)] !rounded-3xl" @click="login = true" />
          <Button label="CADASTRO" class="!bg-[var(--p-primary-950)] !rounded-3xl" @click="cadastro = true" />
        </div>

      </div>
    </div>
  </div>

  <Toast position="bottom-right" />
</template>

<script setup lang="ts">
import Password from "primevue/password";
import Button from "primevue/button";
import { onMounted, ref, type Ref } from "vue";
import { api } from "@/plugins/axios";
import Toast from "primevue/toast";
import { useToast } from "primevue/usetoast";
import { FloatLabel, InputMask, InputText } from "primevue";
import { tituloProjeto } from "@/utils";
import { useRouter } from "vue-router";

const toast = useToast();
const router = useRouter();

const username: Ref<string> = ref("");
const password: Ref<string> = ref("");
const loading: Ref<boolean> = ref(false);

const login = ref<boolean>(false)
const cadastro = ref<boolean>(false)
const proximaEtapa = ref<boolean>(false)

const entrar = async () => {
  // if (
  //   username.value.trim().length === 0 ||
  //   password.value.trim().length === 0
  // ) {
  //   toast.add({
  //     severity: "warn",
  //     summary: "Existem campos vazios!",
  //     detail: "Preencha corretamente todos os campos",
  //     life: 3000
  //   });
  //   return;
  // }

  // loading.value = true;

  // try {
  //   loading.value = true;

  //   const userData = {
  //     cpf: username.value,
  //     password: password.value,
  //   };

  //   await api.post("/login", userData);
  // } catch (error: any) {
  //   console.log(error.response.data.message);

  // } finally {
  //   loading.value = false;
  // }

  login.value = false;
  router.push("/home");
};

const cadastrar = () => {
  toast.add({
    severity: "success",
    summary: "ONG cadastrada com sucesso!",
    detail: "Você já pode fazer o login na plataforma.",
    life: 3000
  });
  
  setTimeout(() => {
    login.value = false
    cadastro.value = false
    proximaEtapa.value = false
  }, 3250);
}

const textos = ["Doar é fácil", `${tituloProjeto}`];

const textoExibido = ref("");
let indiceTextoAtual = 0;
let indiceCaractere = 0;
let apagando = false;
let finalizado = false;

const velocidadeDigitacao = 100; // Velocidade de digitação (ms)
const velocidadeApagacao = 50; // Velocidade de apagar (ms)
const pausaEntreTextos = 1500; // Pausa entre os textos (ms)

function escreverTexto() {
  if (finalizado) return;

  const textoAtual = textos[indiceTextoAtual];

  if (apagando) {
    textoExibido.value = textoAtual.substring(0, indiceCaractere - 1);
    indiceCaractere--;
  } else {
    textoExibido.value = textoAtual.substring(0, indiceCaractere + 1);
    indiceCaractere++;
  }

  let tempoEspera = apagando ? velocidadeApagacao : velocidadeDigitacao;

  if (!apagando && indiceCaractere === textoAtual.length) {
    if (indiceTextoAtual === textos.length - 1) {
      // Estamos no último texto -> NÃO apagar, apenas finalizar
      finalizado = true;
      return;
    } else {
      // Se não é o último texto, aguardar e começar a apagar
      tempoEspera = pausaEntreTextos;
      apagando = true;
    }
  } else if (apagando && indiceCaractere === 0) {
    // Terminou de apagar, passar para o próximo texto
    indiceTextoAtual++;
    apagando = false;
  }

  setTimeout(escreverTexto, tempoEspera);
}

onMounted(() => {
  escreverTexto();
});

</script>

<style scoped></style>
