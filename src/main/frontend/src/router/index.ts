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
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
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
            }
          ]
        }
      ]
    }
  ]
});
router.beforeEach((to, from) => {
  const loginStore = useAuthStore()

  if(to.meta.requireAuth && !loginStore.isAuthenticate) return {name: 'home'}
  if(to.name == 'session' && loginStore.roleLogin == 'ROLE_USER') router.push({name:'dashbboardUser'})
  /* if(to.name == 'sessionLayout' && loginStore.roleLogin == 'ROLE_ADMIN') router.push({name:'dashboardAdmin'}) */
})
export default router
