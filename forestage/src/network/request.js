import axios from 'axios'

export function request(config) {
    const instance = new axios.create({
        baseURL: 'http://127.0.0.1:8080/sms_war/',
        timeout: 5000,
    });

    // 请求拦截器
    instance.interceptors.request.use(config => {
        //  config.headers['uNum'] = window.sessionStorage.getItem('uNum')
        config.headers.Authorization = window.sessionStorage.getItem('token')
        // config.headers.Authorization = window.sessionStorage.getItem('token')
        return config;
    }, err => {
        console.log(err);
    })

    // 响应拦截器
    instance.interceptors.response.use(res => {
        // 拦截后需要将拦截下来处理成的结果返回
        return res.data
    }, err => {
        console.log(err)
    })

    //返回promis
    return instance(config)
}