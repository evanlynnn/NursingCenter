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
import CustomerList from "../components/customer/CustomerList";
import AddCustomer from "../components/customer/AddCustomer";
import CheckIn from "../components/customer/CheckIn";
import AddCheckIn from "../components/customer/AddCheckIn";
import Retreat from "../components/customer/Retreat";
import NursingConfig from "../components/nursing/NursingConfig";
import CustomizeNursing from "../components/nursing/CustomizeNursing";
import CustomizeNursingAdd from "../components/nursing/CustomizeNursingAdd";
import CustomizeNursingEdit from "../components/nursing/CustomizeNursingEdit";
import BedList from "../components/bed/BedList";
import BedListAdd from "../components/bed/BedListAdd";
import BedListPost from "../components/bed/BedListPost";
import BedListUpdate from "../components/bed/BedListUpdate";
import Dashboard from "../components/dashboard/Dashboard";

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
                    path: 'dashboard',
                    component: Dashboard,
                },
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
                },
                {
                    path: 'customer',
                    component: CustomerList,
                },
                {
                    path: 'customerAdd',
                    component: AddCustomer
                },

                {
                    path: 'checkin',
                    component: CheckIn
                },
                {
                    path: 'checkinAdd',
                    component: AddCheckIn
                },
                {
                    path: 'retreat',
                    component: Retreat,
                },
                {
                    path: 'nursing',
                    component: NursingConfig
                },
                {
                    path: 'customizeNursing',
                    component: CustomizeNursing,
                },
                {
                    path: 'customizeNursingAdd',
                    component: CustomizeNursingAdd,
                },
                {
                    path: 'customizeNursingEdit/:id',
                    component: CustomizeNursingEdit,
                },
                {
                    path: 'bed',
                    component: BedList
                },
                {
                    path: 'bedAdd',
                    component: BedListAdd
                },
                {
                    path: 'bedPost',
                    component: BedListPost
                },
                {
                    path: 'bedUpdate/:id',//路由跳转传递参数，参数名是id
                    component: BedListUpdate
                },
            ]
        }

    ]
})

export default router