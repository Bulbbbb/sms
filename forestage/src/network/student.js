import { request } from '@/network/request.js'
export function getStus(uNum) {
    return request({
        method: 'get',
        url: 'getStus/'+'1',
        params:{
            uNum:uNum
        }
    })
}
export function getStusForCla(cla,ind,uNum) {
    return request({
        method: 'get',
        url: 'getStusForCla/'+cla+"/1",
        params:{
            uNum:uNum
        }
    })
}


export function stuCreate(name,num,year,ins,maj,cla,uNum) {
    return request({
        method: 'get',
        url: "/stuCreate/"+name+"/"+num+"/"+year+"/"+ins+"/"+maj+"/"+cla,
        params:{
            uNum:uNum
        }
    })
}
export function addAStu(student,uNum) {
    return request({
        method: 'post',
        url: "/addAStu",
        params:{
            uNum:uNum
        },
        data:student
    })
}

