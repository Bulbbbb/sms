import { request } from '@/network/request.js'


export function getIns(uNum) {
    return request({
        method: 'get',
        url: 'getIns',
        params: {
            uNum: uNum
        }
    })
}
export function getCour(cla,uNum) {
    return request({
        method: 'get',
        url: 'getCour/'+cla,
        params: {
            uNum: uNum
        }
    })
}
export function getACour(ins,uNum) {
    return request({
        method: 'get',
        url: 'getACour/'+ins,
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

export function courCreate(course,uNum) {
    return request({
        method: 'post',
        url: 'courCreate',
        params: {
            uNum: uNum
        },
        data:course
    })
}

export function getcours(uNum) {
    return request({
        method: 'get',
        url: 'getcours',
        params: {
            uNum: uNum
        }
    })
}

export function getSelectCour(uNum) {
    return request({
        method: 'get',
        url: 'getSelectCour',
        params: {
            uNum: uNum
        }
    })
}

export function getCourAt(uNum) {
    return request({
        method: 'get',
        url: 'getCourAt',
        params: {
            uNum: uNum
        }
    })
}
export function addCourAt(majCour,uNum) {
    return request({
        method: 'post',
        url: 'addCourAt',
        params: {
            uNum: uNum
        },
        data:majCour
    })
}