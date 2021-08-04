import { request } from '@/network/request.js'

export function teaCreate(techer,uNum) {
    return request({
        method: 'post',
        url: 'teaCreate',
        params: {   
            uNum: uNum
        },
        data:techer
    })
}