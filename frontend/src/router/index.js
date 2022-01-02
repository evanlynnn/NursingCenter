import Vue from 'vue'
import Router from 'vue-router'
import Login from "@/components/login/Login";
import Main from "@/components/main/Main";
import FoodList from "../components/food/FoodList";
import AddFood from "../components/food/AddFood";
import EditFood from "../components/food/EditFood";
import FoodMenuList from "../components/foodMenu/FoodMenuList";
import AddFoodMenu from "../components/foodMenu/AddFoodMenu";
import EditFoodMenu from "../components/foodMenu/EditFoodMenu";

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
                {
                    path: 'foodMenu',
                    component: FoodMenuList
                },
                {
                    path: 'addFoodMenu',
                    component: AddFoodMenu
                },
                {
                    path: 'editFoodMenu/:id',
                    component: EditFoodMenu
                }
            ]
        }

    ]
})

export default router