import { request } from '@/network/request.js'
export function getPowers(auth,uNum) {
    return request({
        method: 'get',
        url: 'getPowers/'+auth,
        params:{
            uNum:uNum
        }
    })
}