import { request } from '@/network/request.js'
export function graCreat(stu,cour,school,cla,gra,year,uNum) {
    return request({
        method: 'get',
        url: 'graCreat/'+stu+"/"+cour+"/"+school+"/"+cla+"/"+gra+"/"+year,
        params: {
            uNum: uNum
        }
    })
}
export function getGra(uNum) {
    return request({
        method: 'get',
        url: 'getGra',
        params: {
            uNum: uNum
        }
    })
}
export function getAGra(name,year,school,uNum) {
    return request({
        method: 'get',
        url: 'getAGra/'+name+'/'+year+'/'+school,
        params: {
            uNum: uNum
        }
    })
}