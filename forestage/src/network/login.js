import { request } from '@/network/request.js'
export function login(uNum, uPwd,role) {
    return request({
        method: 'get',
        url: 'login/'+uNum+'/'+uPwd+'/'+role,
    })
}
export function getStus(id) {
    return request({
        method: 'get',
        url: 'getStus/' + id,
        params: {
            uName: "admin"
        }
    })
}
export function getPrivilege() {
    return request({
        method: 'get',
        url: 'getPrivilege/' + 1,
        params: {
            uName: "admin"
        }
    })
}
