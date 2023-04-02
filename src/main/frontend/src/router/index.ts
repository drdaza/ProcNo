import { createRouter, createWebHistory } from 'vue-router'
import { useAuthStore } from '../stores/AuthStore'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: ()=> import('../views/LoginView.vue')
    },
    {
      path: '/register',
      name: 'register',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/views/RegisterView.vue')
    },
    {
      path: '/session',
      name: 'session',
      component: () => import('@/layouts/sessionLayout/SessionLayout.vue'),
      meta: {requireAuth: true},
      children: [
        {
          path: 'user',
          name: 'user',
          component: ()=> import('@/layouts/userLayout/UserLayout.vue'),
          meta: {requireAuth: true},
          children:[
            {
              path: 'dashboard',
              name: 'dashbboardUser',
              component: ()=> import ('@/views/userViews/UserDashboardView.vue'),
              meta: {requireAuth: true}
            },
            {
              path: 'MyProjects',
              name: 'myProjects',
              component: () => import('@/views/userViews/UserMyProjectsView.vue'),
              meta: {requireAuth: true}
            }
          ]
        }
      ]
    }
  ]
});
router.beforeEach((to, from) => {
  const loginStore = useAuthStore()

  if(to.meta.requireAuth && !loginStore.isAuthenticate) return {name: 'login'}
  if(to.name == 'session' && loginStore.roleLogin == 'ROLE_USER') router.push({name:'dashbboardUser'})
  /* if(to.name == 'sessionLayout' && loginStore.roleLogin == 'ROLE_ADMIN') router.push({name:'dashboardAdmin'}) */
})
export default router
