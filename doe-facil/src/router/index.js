import { createRouter, createWebHistory } from 'vue-router';
import LoginPage from '@/components/LoginPage.vue';
import RegisterPage from '@/components/RegisterPage.vue';
import FirstPage from '@/components/FirstPage.vue';
const routes = [
    { path: '/', component: FirstPage },
    { path: '/login', component: LoginPage },
    { path: '/cadastro', component: RegisterPage }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;