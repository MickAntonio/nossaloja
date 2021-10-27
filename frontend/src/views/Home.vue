<template>
    <section class="product spad">
       <v-row v-if="isLoading" justify="center" no-gutters class="my-12">
        <v-progress-circular indeterminate color="primary" size="64" />
      </v-row>
        <div v-else class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="filter__item">
                        <div class="row">
                            <div class="col-lg-4 col-md-5">
                                <div class="filter__sort">
                                    <span>Ordernar por</span>
                                    <select>
                                        <option value="0">Default</option>
                                        <option value="0">Preço</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="filter__found">
                                    <h6><span>{{produtos.length}}</span> Productos encontrados</h6>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-3">
                                <div class="filter__option">
                                    <span class="icon_grid-2x2"></span>
                                    <span class="icon_ul"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row"> 
                      <!-- :data-setbg="`${product.image}`" -->
                        <div v-for="produto in produtos" :key="produto.id" class="col-lg-4 col-md-6 col-sm-6" >
                            <div class="product__item">
                                <div class="product__item__pic set-bg" :data-setbg="`${produto.imagem}`" :style="`background-image: url(${produto.imagem});`">
                                    <ul class="product__item__pic__hover">
                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                        <li><router-link :to="`/productos/visualizar/${produto.id}`"><i class="fa fa-eye"></i></router-link></li>
                                        <!-- <li><i class="fa fa-shopping-cart" @click="addToCart(product)"></i></li> -->
                                        <li><a @click="addToCart(produto)"><i class="fa fa-shopping-cart"></i></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><router-link :to="`/productos/visualizar/${produto.id}`">{{ produto.nome }}</router-link></h6>
                                    <h5>${{ produto.preco }}</h5>
                                </div>
                            </div>
                        </div>
                      
                      
                    </div>
                    <div class="product__pagination">
                        <a href="#">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#"><i class="fa fa-long-arrow-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>

<script>
import axios from "axios";

export default {
  name: "Home",

  data: () => ({
    produtos: [],
    isLoading: false
  }),

  computed: {
    cartItems() {
      return this.$store.state.carrinho.items;
    }
  },

  async created() {
    this.isLoading = true;

    try {
      const { data } = await axios.get("http://localhost:8025/nossaloja-api/produtos");
      this.produtos = data;
    } finally {
      this.isLoading = false;
    }
  },

   methods: {
    checkIsInCart(produto) {
      return this.cartItems.some(cartItem => cartItem.id === produto.id);
    },

    addToCart(produto) {
      alert(22)
      this.$store.commit("carrinho/ADD_ITEM", produto);
    }
  }

};
</script>


<style scoped>
    .product__pagination{
        margin: 0 auto!important;;
    }
    .v-progress-circular{
        margin: 0 auto !important; 
        text-align:center;
    }
    .no-gutters{
        margin-bottom: 100px;
    }
</style>