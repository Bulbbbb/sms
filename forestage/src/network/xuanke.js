import { request } from '@/network/request.js'

export function addXuanke(xuanKe,uNum) {
    return request({
        method: 'post',
        url: 'addXuanke',
        params: {
            uNum: uNum
        },
        data:xuanKe
    })
}
export function getXuanke(sNum,cNum,uNum) {
    return request({
        method: 'get',
        url: 'getXuanke/'+sNum+'/'+cNum,
        params: {
            uNum: uNum
        },
    })
}