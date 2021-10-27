<template>
       <section class="product-details checkout">
        <v-row v-if="isLoading" justify="center" no-gutters class="my-12">
            <v-progress-circular indeterminate color="primary" size="64" />
        </v-row>

        <div class="container" v-else-if="produto">
            
            <h6>Dados Producto</h6>

            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                                :src="produto.imagem" alt=""
                                data-pagespeed-url-hash="232668656"
                                onload="pagespeed.CriticalImages.checkImageForCriticality(this);">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>{{ produto.preco }}</h3>
                        <div class="product__details__rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                            <!-- <span>(18 reviews)</span> -->
                        </div>
                        <div class="product__details__price">${{ produto.preco }}</div>
                        <p>{{produto.descricao}}</p>
                        <div class="product__details__quantity">
                            <div class="quantity">
                                <div class="pro-qty">
                                    <input type="text" value="1">
                                </div>
                            </div>
                        </div>
                        <a v-if="checkIsInCart(produto)"
                          @click="$store.commit('carrinho/REMOVE_ITEM', produto.id)" class="primary-btn danger-btn">REMOVER DO CARRINHO</a>

                        <a v-else @click="addToCart(produto)" class="primary-btn">ADICIONAR AO CARRINHO</a>

                        <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                        <ul>
                            <li><b>Disponibilidade</b> 
                                <span v-if="produto.quatidadeEstoque>0">Em Estoque</span> 
                                <span v-if="produto.quatidadeEstoque<1" class="red">Fora de Estoque</span></li>
                        </ul>
                    </div>
                   
                </div>
            </div>
        </div>
    </section>
</template>

<style scoped>
    .checkout{
        padding: 0px;
        margin-top: 0!important;
    }
    .center-form{
        margin: 0 auto;
    }
    .checkout h6{
        margin-bottom: 30px;
    }
    .site-btn{
        color: white;
    }
    .danger-btn{
        background: red;
        cursor: pointer;
        color: white;
    }
    .primary-btn{
        cursor: pointer;
    }
    .v-progress-circular{
        margin: 0 auto !important; 
        text-align:center;
    }
    .no-gutters{
        margin-bottom: 100px;
    }
    .red{
        color: red;
    }
</style>

<script>
import axios from "axios";

export default {
  name: "Visualizar",
  
  data: () => ({
    produto: null,
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
      const { data } = await axios.get(
        `http://localhost:8025/nossaloja-api/produtos/${this.$route.params.id}`
      );
      this.produto = data;
    } finally {
      this.isLoading = false;
    }
  },

  methods: {
    checkIsInCart(produto) {
      return this.cartItems.some(cartItem => cartItem.id === produto.id);
    },

    addToCart(produto) {
      this.$store.commit("carrinho/ADD_ITEM", produto);
    }
  }
};
</script>
