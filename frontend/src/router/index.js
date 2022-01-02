import Vue from 'vue'
import Router from 'vue-router'
import Login from "@/components/login/Login";
import Main from "@/components/main/Main";
import FoodList from "../components/food/FoodList";
import AddFood from "../components/food/AddFood";
import EditFood from "../components/food/EditFood";

Vue.use(Router)


// Config router
const router = new Router({
    routes: [
        {
            path: '/',
            component: Login
        },
        {
            path: '/main',
            component: Main,
            children: [
                {
                    path: 'food',
                    component: FoodList,
                },
                {
                    path: 'addFood',
                    component: AddFood
                },
                {
                    path: 'editFood/:id',
                    component: EditFood
                },
            ]
        }

    ]
})

export default router