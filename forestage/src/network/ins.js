import { request } from '@/network/request.js'

export function getStus(name, num, uNum) {
    return request({
        method: 'get',
        url: 'insCreat/' + name + "/" + num,
        params: {
            uNum: uNum
        }
    })
}
export function getIns(uNum) {
    return request({
        method: 'get',
        url: 'getIns',
        params: {
            uNum: uNum
        }
    })
}
export function getMajs(major,uNum) {
    return request({
        method: 'get',
        url: 'getMaj/'+major,
        params: {
            uNum: uNum
        }
    })
}
export function getcla(major,uNum) {
    return request({
        method: 'get',
        url: 'getClass/'+major,
        params: {
            uNum: uNum
        }
    })
}
export function getMaj(uNum) {
    return request({
        method: 'get',
        url: 'getMaj',
        params: {
            uNum: uNum
        }
    })
}
export function getCla(uNum) {
    return request({
        method: 'get',
        url: 'getcla',
        params: {
            uNum: uNum
        }
    })
}
export function majCreate(name, num, major, uNum) {
    return request({
        method: 'get',
        url: 'majCreate/' + name + "/" + num + "/" + major,
        params: {
            uNum: uNum
        }
    })
}
export function claCreate(name, num, ins, maj,uNum) {
    return request({
        method: 'get',
        url: 'claCreate/'+name+"/"+num+"/"+ins+"/"+maj,
        params: {
            uNum: uNum
        }
    })
}

