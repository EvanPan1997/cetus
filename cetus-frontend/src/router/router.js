import {createMemoryHistory, createRouter} from "vue-router"
import Main from "@/components/Main.vue";
import HomeLayout from "@/layout/HomeLayout.vue";

const routes = [
    {
        path: '/',
        component: HomeLayout,
        redirect: '/main',
        children: [
            {
                path: 'main',
                component: Main
            }
        ]
    }
]

const router = createRouter({
    history: createMemoryHistory(),
    routes,
})

export default router