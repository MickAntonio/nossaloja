<template>
     <section class="shoping-cart checkout">

        
        <div class="container">
            <v-row v-if="isLoading"  justify="center" no-gutters class="my-12">
                <v-progress-circular indeterminate color="primary" size="64" />
            </v-row>

            <div v-else class="row">
                <div class="col-lg-12">
                    <h6>Lista de Productos</h6>

                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Producto</th>
                                    <th>Categoria</th>
                                    <th>Preço</th>
                                    <th>Qtd. disponível</th>
                                    <th>Ultima Actualização</th>
                                    <th>Acção</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="produto in produtos" :key="produto.id" >
                                    <td class="shoping__cart__item">
                                        <img :src="produto.imagem" width="50" height="50"
                                            alt="" data-pagespeed-url-hash="2710334252"
                                            onload="pagespeed.CriticalImages.checkImageForCriticality(this);">
                                        <h5>{{produto.nome}}</h5>
                                    </td>
                                    <td>
                                        {{produto.categoria.nome}}
                                    </td>
                                     <td class="shoping__cart__price">
                                        {{produto.preco}}
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        {{produto.quatidadeEstoque}}
                                    </td>
                                    <td>
                                        {{produto.ultima_actualizacao}}
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <router-link class="btn btn-primary" to="/productos/cadastro"><i class="fa fa-pencil"></i></router-link>
                                        <a class="btn btn-danger"><i class="fa fa-close"></i></a>
                                    </td>
                                </tr>
                            
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
         
        </div>
    </section>

</template>

<script>

import axios from "axios";

export default {
  name: "Listagem", 
  data: () => ({
    produtos: [],
    isLoading: false
  }),

   async created() {
    this.isLoading = true;

     try {
      const { data } = await axios.get("http://localhost:8025/nossaloja-api/produtos");
      this.produtos = data;
    } finally {
      this.isLoading = false;
    }
  },
};
</script>


<style scoped>
    .checkout, .shoping-cart{
        padding: 0px;
        margin-top: 0!important;
    }
    .checkout h6{
        margin-bottom: 30px;
    }
    .v-progress-circular{
        margin: 0 auto !important; 
        text-align:center;
    }
    .no-gutters{
        margin-bottom: 100px;
    }
</style>