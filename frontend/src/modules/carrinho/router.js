const Module = () => import("./Module.vue");
const Carrinho = () => import("./views/Carrinho.vue");

const moduleRoute = {
  path: "/carrinho-compras",
  component: Module,
  children: [
    {
      path: "/",
      component: Carrinho
    }
  ]
};

export default router => {
  router.addRoutes([moduleRoute]);
};
