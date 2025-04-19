import axios from 'axios'
import router from "@/router";
import Cookies from "js-cookie";
import user from "@/views/user/User.vue";

const request = axios.create({
    baseURL: 'https://liber.huidi.site/api/',
    timeout: 5000
})
//request拦截器
request.interceptors.request.use(config => {
        config.headers['Content-Type'] = 'application/json; charset=utf-8';

        const adminJson = Cookies.get('admin')
        if (adminJson) {
            config.headers['token']= JSON.parse(adminJson).token//跳转登录界面
        }

        return config

    }, error => {
        return Promise.reject(error)
    }
);
request.interceptors.response.use(
    response => {
        let res = response.data;
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
        if (res.code === '401'){
            router.push('/login').catch(() => {})
        }
        return res;
    },
    error => {
        console.log('err'+error)
        return Promise.reject(error)
    }
)
export default request
