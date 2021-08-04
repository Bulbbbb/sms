import { request } from '@/network/request.js'


export function studentBat(student,uNum) {
    return request({
        method: 'post',
        url: 'studentBat',
        params: {
            uNum: uNum
        },
        data:student
    })
}
export function teacherBat(teacher,uNum) {
    return request({
        method: 'post',
        url: 'teacherBat',
        params: {
            uNum: uNum
        },
        data:teacher
    })
}

export function courseBat(course,uNum) {
    return request({
        method: 'post',
        url: 'courseBat',
        params: {
            uNum: uNum
        },
        data:course
    })
}