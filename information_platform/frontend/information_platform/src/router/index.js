import Vue from 'vue'
import Router from 'vue-router'
import store from './../../store/store'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      redirect: '/HomePage'
    },
    {
      path: '/HomePage',
      name: 'HomePage',
      component: () => import('@/views/HomePage')
    },
    {
      path: '/Login',
      name: 'Login',
      component: () => import('@/views/Login')
    },
    {
      path: '/Message',
      name: 'Message',
      component: () => import('@/views/Message'),
      meta:{
        requireAuth: true
      }
    },
    {
      path: '/Appeal',
      name: 'Appeal',
      component:() => import('@/views/Appeal'),
      meta:{
        requireAuth: true
      }
    },
    {
      path: '/Announcement',
      name: 'Announcement',
      component:() => import('@/views/Announcement'),
    },
    {
      path: '/Announcement/date/:id',
      name: 'AnnouncementDate',
      component:() => import('@/views/AnnouncementDate'),
    },
    {
      path: '/Forum',
      name: 'Forum',
      component: () => import('@/views/Forum')
    },
    {
      path: '/ForumCreate',
      name: 'ForumCreate',
      component: () => import('@/views/ForumCreate'),
      meta:{
        requireAuth: true
      }
    },
    {
      path: '/ForumPage1',
      name: 'ForumPage1',
      component: () => import('@/views/ForumPage1')
    },
    {
      path: '/ForumPage2',
      name: 'ForumPage2',
      component: () => import('@/views/ForumPage2')
    },
    {
      path: '/ForumPage3',
      name: 'ForumPage3',
      component: () => import('@/views/ForumPage3')
    },
    {
      path: '/ForumPage4',
      name: 'ForumPage4',
      component: () => import('@/views/ForumPage4')
    },
    {
      path: '/ForumDetail',
      name: 'ForumDetail',
      component: () => import('@/views/ForumDetail'),
    },
    {
      path: '/Help',
      name: 'Help',
      component: () => import('@/views/Help'),
      meta:{
        requireAuth: true
      }
    },
    {
      path: '/Report',
      name: 'Report',
      component: () => import('@/views/Report'),
      meta:{
        requireAuth: true
      }
    },
    {
      path: '/UserDetail',
      name: 'UserDetail',
      component: () => import('@/views/UserDetail')
    },
    {
      path: '/Find',
      name: 'Find',
      component: () => import('@/views/Find')
    },
    {
      path: '/ChangeUserDetail',
      name: 'ChangeUserDetail',
      component: () => import('@/views/ChangeUserDetail'),
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/LostAFound/Board',
      name:'LostAFoundBoard',
      component:() => import('@/views/LostAFound/Board')
    },
    {
      path: '/LostAFound/Publish',
      name:'LostAFoundPublish',
      meta: {
        requireAuth: true
      },
      component:() => import('@/views/LostAFound/Publish')
    },
    {
      path:'/LostAFound/MyBoard',
      name:'LostAFoundMyBoard',
      meta: {
        requireAuth: true
      },
      component:() => import('@/views/LostAFound/MyBoard')
    },
    {
      path:'/Manage/AnnouncementPublish',
      name:'AnnouncementPublish',
      component:() => import('@/views/Manage/AnnouncementPublish'),
      meta: {
        requireManage: true
      }
    },
    {
      path:'/Manage/User',
      name:'User_Manage',
      component:() => import('@/views/Manage/User_Manage'),
      meta: {
        requireManage: true
      }
    },
    {
      path:'/Manage/AnnouncementDelete',
      name:'AnnouncementDelete',
      component:() => import('@/views/Manage/AnnouncementDelete'),
      meta: {
        requireManage: true
      }
    },
    {
      path:'/Manage/ForumDelete',
      name:'ForumDelete',
      component:() => import('@/views/Manage/ForumDelete'),
      meta: {
        requireManage: true
      }
    },
    {
      path:'/Manage/Inbox',
      name:'Inbox',
      component:() => import('@/views/Manage/Inbox'),
      meta: {
        requireManage: true
      }
    },
    {
      path:'/Manage/HelpDelete',
      name:'HelpDelete',
      component:() => import('@/views/Manage/HelpDelete'),
      meta: {
        requireManage: true
      }
    }
  ]
})

