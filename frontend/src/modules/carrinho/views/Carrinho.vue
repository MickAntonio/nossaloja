<template>
        <section class="shoping-cart checkout">

        <div class="container">
            <form @submit="onSubmit">

            <div class="row">
                <div class="col-lg-12">
                    <h6>Carrinho de Compras</h6>

                    <div v-if="isCartEmpty" class="no-item">
                        Nenhum item no carrinho de compras
                    </div>

                    <div v-else class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="item in items" :key="item.id">
                                    <td class="shoping__cart__item">
                                        <img :src="item.imagem" width="50" height="50"
                                            alt="" data-pagespeed-url-hash="2710334252"
                                            onload="pagespeed.CriticalImages.checkImageForCriticality(this);">
                                        <h5>{{item.nome}}</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        ${{ item.preco }}
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                 <input type="number" @change="$store.commit('carrinho/QTD_ITEM', item)" v-model="item.qtd">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                        ${{ item.preco*item.qtd }}
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <span @click="$store.commit('carrinho/REMOVE_ITEM', item.id)" class="icon_close"></span>
                                    </td>
                                </tr>
                              
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="shoping__cart__btns">
                        <a href="#" class="primary-btn cart-btn">CONTINUAR COM AS COMPRAS</a>
                    </div>
                </div>
               
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Total do carrinho</h5>
                        <span>Checked names: {{ qtds }}</span>
                        <ul>
                            <li>Subtotal <span>${{ totalPrice }}</span></li>
                            <li>Total <span>$ {{ totalPrice }}</span></li>
                        </ul>
                        <button class="primary-btn" :disabled="isCartEmpty ? '' : disabled">FINALIZAR COMPRA</button>
                    </div>
                </div>
            </div>
            </form>
        </div>
        
    </section>
</template>

<style scoped>
     .checkout, .shoping-cart{
        padding: 0px;
        margin-top: 0!important;
    }
  
    .checkout h6{
        margin-bottom: 30px;
    }
    .shoping__checkout{
        margin-top: 0px;
    }
    .shoping__cart__btns{
        margin-top: 0px;
        padding-top: 0px;
    }
    .no-item{
        text-align: center;
        margin-bottom: 40px;
    }
</style>

<script>
import axios from "axios";

export default {
  name: "Carrinho",
  data: () => ({
    qtds: 1,
  }),

  computed: {
    items() {
      return this.$store.state.carrinho.items || [];
    },

    isCartEmpty() {
      return this.items.length === 0; 
    },

    totalPrice() {
      const price = this.items.reduce((acc, produto) => acc + produto.preco, 0);
      return price.toFixed(2);
    }
  },
   methods:{
      async onSubmit(e) {
        e.preventDefault()
        var compra = [];

        compra.produtos = this.$store.state.carrinho.items.map((item)=>( {produtoId: item.id, qtd:item.qtd}));
        
        console.log(compra)

        await axios.post("http://localhost:8025/nossaloja-api/compras", compra)
        .then(response => {
            alert('Compra realizada sucessso')
        })
        .catch(error => {
            this.errorMessage = error.message;
            alert("Ocorreu uma erro ao realizar a Compra, por favor entre em contacto com o administrador", error);
        });
       
      }
  }
};
</script>
