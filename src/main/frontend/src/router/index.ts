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
              path: 'Dashboard',
              name: 'dashbboardUser',
              component: ()=> import ('@/views/userViews/UserDashboardView.vue'),
              meta: {requireAuth: true}
            },
            {
              path: 'MyProjects',
              name: 'myProjects',
              component: () => import('@/views/userViews/UserMyProjectsView.vue'),
              meta: {requireAuth: true}
            },
            {
              path: 'NewProject',
              name: 'newProject',
              component: () => import('@/views/userViews/UserCreateProjectView.vue'),
              meta: {requireAuth: true}
            },
            {
              path: 'Project/:idProject/container/:typeContainer',
              name: 'projectView',
              component: () => import('@/views/projectTemplate/ProjectTemplate.vue'),
              meta: {requireAuth: true},
              props: route => ({idProject: route.params.idProject, typeContainer: route.params.typeContainer}),
              children: [
                {
                  path: 'template',
                  name: 'kanbanTemplateView',
                  component: () => import('@/views/projectTemplate/KanbanTemplateView.vue')
                },
                {
                  path: 'workoutTemplate',
                  name: 'workoutPTemplateView',
                  component: () => import('@/views/projectTemplate/WorkoutPTemplateView.vue')
                }
              ]
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
  if(to.name == 'projectView' && to.params.typeContainer == 'kanban') router.push({name: 'kanbanTemplateView', params: { idProject: to.params.idProject, typeContainer: to.params.typeContainer}})
  if(to.name == 'projectView' && to.params.typeContainer == 'workoutPlanner') router.push({name: 'workoutPTemplateView', params: { idProject: to.params.idProject, typeContainer: to.params.typeContainer}})
  /* if(to.name == 'sessionLayout' && loginStore.roleLogin == 'ROLE_ADMIN') router.push({name:'dashboardAdmin'}) */
})
export default router
