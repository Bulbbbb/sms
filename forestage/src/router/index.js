import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/login/Login'
import Home from '@/views/home/Home'
import InfManage from '@/views/information/InfManage'
import SysManage from '@/views/system/SysManage'
import CourManage from '@/views/course/CourManage'
import GraManage from '@/views/grade/GraManage'
import InsManage from '@/views/institution/InsManage'
import CourseShow from '@/views/student/CourseShow'
import GradeShow from '@/views/student/GradeShow'
import SelectCour from '@/views/student/SelectCour'
import Profile from '@/components/content/profile/Profile'

Vue.use(VueRouter)

const routes=[
    {
        path:'/',
        redirect:'/login',
        meta: { allowBack: false }
    },
    {
        path:'/login',
        component:Login,
        meta: { allowBack: false }
    },
    {
        path:'/home',
        component:Home,
        meta: { allowBack: false },
        children: [
            {
              path: '/',
              redirect: '/2002'
            },
            {
              path: '/2002',
              component: InfManage
            },
            {
              path: '/2001',
              component: SysManage
            },
            {
              path: '/2003',
              component: CourManage
            },
            {
              path: '/2004',
              component: GraManage
            },
            {
              path: '/2005',
              component: InsManage
            },
            {
              path: '/2006',
              component: CourseShow,
              meta: { allowBack: false }
            },
            {
              path: '/2007',
              component: GradeShow
            },
            {
              path: '/2008',
              component: SelectCour
            },
            {
              path: '/profile',
              component: Profile
            }
          ]
    }
]
const router=new VueRouter({
    routes,
    mode:'history',
    scrollBehavior: () => {
      history.pushState(null, null, document.URL)
     }
})

// 全局导航守卫
router.beforeEach((to, from, next) => {
  let token = window.sessionStorage.getItem("token")
  // console.log(to.path);

  if (to.path === '/login') {
    next()
  } else {
    if (token === null) {
      next('/login')
    } else {
      next()
    }
  }
  next()
})
export default router