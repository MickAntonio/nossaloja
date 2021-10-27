<template>
        <section class="checkout">
        
         <v-row v-if="isLoading" justify="center" no-gutters class="my-12">
            <v-progress-circular indeterminate color="primary" size="64" />
        </v-row>

       
        <div  v-else class="container">
            <div class="checkout__form">
                <form @submit="onSubmit">
                    <h6>Cadastrar Producto</h6>

                    <div class="row">
                        <div class="col-lg-8 col-md-8 center-form">
                            <div class="checkout__input">
                                <p>Nome<span>*</span></p>
                                <input v-model="nome" type="text" required>
                            </div>

                             <div class="checkout__input">
                                <p>Categoria<span>*</span></p>
                                <select v-model="categoria" name="categoria" class="select" required>
                                    <option v-for="categoria in categorias" :key="categoria.id"  v-bind:value="categoria.id">{{categoria.nome}}</option>
                                </select>
                            </div>

                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Preço por Unidade<span>*</span></p>
                                        <input v-model="preco" type="number" required>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Quantidade Disponivel no Estoque<span>*</span></p>
                                        <input v-model="quantidade" type="number" required placeholder="Street Address" class="checkout__input__add">
                                    </div>
                                </div>
                            </div>

                            <div class="checkout__input">
                                <p>Descricao<span></span></p>
                                <input v-model="descricao" type="text" >
                            </div>
                           
                            <div class="">
                                <p>Lik da Imagem<span>*</span></p>
                                <input type="text" v-model="imagem" class="checkout__input" required>
                            </div>
                           
                            <button type="submit" class="site-btn">SALVAR</button>

                        </div>
                       
                    </div>
                </form>
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
        margin-top: 30px;
        margin-bottom: 50;
    }
    .select{
        border: 1px solid #ccc;
        width: 100%;
        padding: 10px;
    }
    .v-progress-circular{
        margin: 0 auto !important; 
        text-align:center;
    }
    .no-gutters{
        margin-bottom: 100px;
    }
</style>

<script>

import axios from "axios";

export default {
  name: "Cadastro", 
  
  data: () => ({
      nome: '',
      descricao: '',
      categoria: 0,
      preco: 0,
      quantidade: 0,
      imagem: ''
  },
  {
    categorias: [],
    isLoading: false
  }
  ),

  
  methods: {
    async onSubmit(e) {
      e.preventDefault()

      const novoProduto = {
        id: 0,
        nome: this.nome,
        descricao: this.descricao,
        categoria: this.categoria,
        preco: this.preco,
        quantidade: this.quantidade,
        imagem: this.imagem,
      }

      await axios.post("http://localhost:8025/nossaloja-api/produtos", novoProduto)
        .then(response => {
            alert('Produto Cadastrado com sucessso')
        })
        .catch(error => {
            this.errorMessage = error.message;
            alert("Ocorreu uma erro ao salvar o produto, por favor entre em contacto com o administrador", error);
        });

      this.nome = ''
      this.descricao = ''
      this.categoria = 0
      this.preco = 0
      this.quantidade = 0
      this.imagem = ''
    },
  },
   async created() {
    this.isLoading = true;

    try {
      const { data } = await axios.get(
        `http://localhost:8025/nossaloja-api/categorias`
      );
      this.categorias = data;
    } finally {
      this.isLoading = false;
    }
  },
 
};
</script>
