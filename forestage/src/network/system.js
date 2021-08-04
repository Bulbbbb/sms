import { request } from '@/network/request.js'

export function getAuth(uNum) {
    return request({
        method: 'get',
        url: 'getAuth',
        params: {
            uNum: uNum
        }
    })
}
export function getUser(uNum) {
    return request({
        method: 'get',
        url: 'getUser',
        params: {
            uNum: uNum
        }
    })
}
