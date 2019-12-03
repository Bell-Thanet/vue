import Vue from 'vue'
import Router from 'vue-router';
import Registeruser from '../components/Registeruser';
import LoginUser from '../components/LoginUser';
import Select from '../components/Select';
import RegisterCompany from '../components/RegisterCompany';
import LoginCompany from '../components/LoginCompany';
import JobPost from '../components/JobPost';
import companychoice from '../components/companychoice';
import Interview from '../components/Interview';
import userchoice from '../components/userchoice';
import Application from '../components/Application';
import Resume from '../components/Resume';
Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/registeruser',
            component: Registeruser
        },
        {
            path: '/',
            component: Select
        },
        {
            path: '/registercompany',
            component: RegisterCompany
        },
        {
            path: '/registercompany/login',
            component: LoginCompany
        },
        {
            path: '/registercompany/login/jobpost',
            component: JobPost
        },
        {
            path: '/registeruser/login',
            component: LoginUser
        },  
        { 
            path: '/companychoice',
            component: companychoice
        },
        { 
            path: '/registercompany/login/Interview',
            component: Interview
        },
        { 
            path: '/userchoice',
            component: userchoice
        },
        { 
            path: '/registeruser/login/Application',
            component: Application
        },
        { 
            path: '/registeruser/login/Resume',
            component: Resume
        },

    ]
});