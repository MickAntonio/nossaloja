const Module = () => import("./Module.vue");
const Cadastro = () => import("./views/Cadastro.vue");
const Listagem = () => import("./views/Listagem.vue");
const Visualizar = () => import("./views/Visualizar.vue");

const moduleRoute = {
  path: "/productos",
  component: Module,
  children: [
    {
      path: "/",
      component: Listagem
    },
    {
        path: "cadastro",
        component: Cadastro
    },
    {
        path: "visualizar/:id",
        component: Visualizar
    }
  ]
};

export default router => {
  router.addRoutes([moduleRoute]);
};
