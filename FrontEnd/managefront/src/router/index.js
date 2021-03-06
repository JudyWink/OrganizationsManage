import Vue from 'vue'
import VueRouter from 'vue-router'  // 引入vue-router
import store from '../store/index';
import ElementUI from 'element-ui';

// 引入要跳转的vue组件
import Login from "../views/login/Login";
import Regist from "../views/regist/Regist";
import Index from "../views/index/Index";
import Menu from "../components/content/menu/Menu"
import Test from "../views/test/Test";
import Test1 from "../views/test/Test1";
import Test2 from "../views/test/Test2";
import Test3 from "../views/test/Test3";
import Test4 from "../views/test/Test4";
import Test5 from "../views/test/Test5";
import Test6 from "../views/test/Test6";
import Test7 from "../views/test/Test7";
import PersonalInfo from "../views/personal/PersonalInfo";
import Document from  "../views/document/Document"
import Message from "../views/message/Message";
import allActivities from "../views/activities/allActivities";
import myActivities from "../views/activities/myActivities";
import ActivitiesProgress from "../views/activities/ActivitiesProgress";
import Calendar from "../views/calendar/Calendar";
import AllOrganizations from "../views/organization/AllOrganizations";
import ForgetPassword from "../views/login/ForgetPassword";
import MyOrganization from "../views/organization/MyOrganization";
import OrganizationInfo from "../views/organization/OrganizationInfo";
import OrganizationSetting from "../views/organization/OrganizationSetting";
import NoPermission from "../views/wrong/NoPermission"
import Member from "../views/member/Members";
import SignupMembers from "../views/member/SignupMembers";
import PublishActivities from "../views/activities/PublishActivities";
import UserPower from "../views/UserManager/UserPower";
import IndexManager from "../views/index/IndexManager";
import UploadDocument from "../views/document/UploadDocument";
import ModifyPassword from "../views/login/ModifyPassword";
import MessageSended from "../views/message/MessageSended";
import myPushActs from "../views/activities/myPushActs";
import havaOrgUsers from "../views/UserManager/havaOrgUsers"
import notFound from "../views/wrong/notFound"

// 在vue中注入Router
Vue.use(VueRouter)

Vue.use(ElementUI);

// 配置路由路径
const routes =[
  {
    path: '/',
    redirect: '/login' //域名重定向
  },
  {
    path: '/regist',
    component: Regist,
    meta:{
      keepalive:false
    }
  },
  {
    path: '/test',
    component: Test,
    meta:{
      keepalive:false
    }
  },
  {
  path: '/test1',
     component: Test1,
     meta:{
     keepalive:false
        }
  },
  {
    path: '/test2',
    component: Test2,
    meta:{
      keepalive:false
        }
  },
  {
     path: '/test4',
     component: Test4,
     meta:{
        keepalive:false
           }
     },
  {
    path: '/test3',
    component: Test3,
    meta:{
        keepalive:false
    }
  },
  {
   path: '/test5',
   component: Test5,
   meta:{
   keepalive:false
   }
   },
      {
       path: '/test6',
       component: Test6,
       meta:{
       keepalive:false
       }
       },
     {
           path: '/test7',
           component: Test7,
           meta:{
           keepalive:false
           }
           },
   {
   path: '/login',
    component: Login,
    meta:{
      keepalive:false
    }
  },
  {
    path: '/index',
    component: Index,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/personalInfo',
    component: PersonalInfo,
    name:"PersonalInfo",
    meta:{
      keepalive:true
    }
  },
  {
    path: '/document',
    component: Document,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/message',
    component: Message,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/allActivities',
    component: allActivities,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/myActivities',
    component: myActivities,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/ActivitiesProgress',
    component: ActivitiesProgress,
    name:"ActivitiesProgress",
    meta:{
      keepalive:true
    }
  },
  {
    path: '/calendar',
    component: Calendar,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/allOrganizations',
    component: AllOrganizations,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/forgetPassword',
    component: ForgetPassword,
    meta:{
      keepalive:false
    }
  },
  {
    path: '/myOrganization',
    component: MyOrganization,
    meta:{
      keepalive:true
    }
  },
     {
       path: '/myPushActs',
       component: myPushActs,
       meta:{
         keepalive:true
       }
     },
  {
    path: '/organizationInfo',
    component: OrganizationInfo,
    name:"OrganizationInfo",
    meta:{
      keepalive:true
    }
  },
  {
    path: '/organizationSetting',
    component: OrganizationSetting,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/noPermission',
    component: NoPermission,
    meta:{
      keepalive:false
    }
  },
  {
    path: '/publishActivities',
    component: PublishActivities,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/members',
    component: Member,
    meta:{
      keepalive:true
    }
  },
     {
       path: '/havaOrgUsers',
       component: havaOrgUsers,
       meta:{
         keepalive:true
       }
     },
     {
         path: '*',
         component: notFound,
         meta:{
           keepalive:false
         }
       },
  {
    path: '/signupMembers',
    component: SignupMembers,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/userPower',
    component: UserPower,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/indexManager',
    component: IndexManager,
    meta:{
      keepalive:true
    }
  },
  {
    path: '/uploadDocument',
    component: UploadDocument,
    meta:{
      keepalive:true
    }
  },
    {
      path: '/modifyPassword',
      component: ModifyPassword,
      meta:{
        keepalive:false
      }
    },{
            path: '/messageSended',
            component: MessageSended,
            meta:{
              keepalive:true
            }
          },

  {
    path: '/menu',
    component: Menu,
  },
  ]

// 将路径注入到Router中
var router = new VueRouter({
  'mode': 'history',
  routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
  let token = store.state.token ? store.state.token : window.sessionStorage.getItem('token');
 // let userType =  window.sessionStorage.getItem('userType');
  if (to.path === '/login' || to.path === '/regist' || to.path === '/forgetPassword') {
    next();
  }else {
    if (token === null || token === '') {
    let v = new Vue();
      v.$notify.error({
        message: '你还未登录'
      });
        next('/login');
    } else {
      next();
    }
  }
});


// 导出路由
export default router;
