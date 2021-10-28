<template>
  <div>
    
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> ajuda@ecommerce.com</li>
                                <li>Entrega grátis para todos os pedidos de $99</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            
                            <div class="header__top__right__auth">
                                <a href="#"><i class="fa fa-user"></i> Entrar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./index.html" class="logo">NOSSA LOJA
                               </a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><router-link to="/">Ínicio</router-link></li>
                            <li><a href="#">Produtos</a>
                                <ul class="header__menu__dropdown">
                                    <li><router-link to="/productos/cadastro">Cadastro</router-link></li>
                                    <li><router-link to="/productos">Visualizar Todos </router-link></li>
                                </ul>
                            </li>
                            <li><a href="#">Vendas</a>
                                <ul class="header__menu__dropdown">
                                    <li><router-link to="/">Visualizar Todas </router-link></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>0</span></a></li>
                            <li><router-link to="/carrinho-compras"><i class="fa fa-shopping-bag"></i> <span>0</span></router-link></li>
                        </ul>
                        <div class="header__cart__price">item: <span>$0.00</span></div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>

    <section class="hero  hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Todas as Categorias</span>
                        </div>
                        <ul>
                            <!-- <li v-for="categoria in categorias" :key="categoria.id"  v-bind:value="categoria.id"><a href="#">{{categoria.nome}}</a></li> -->
                          
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <input type="text" placeholder="O que você precisas?">
                                <button type="submit" class="site-btn">PESQUISAR</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+244 935 273 943</h5>
                                <span>supporte 7/24 horas</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <router-view /> 

    <footer class="footer spad">
        <div class="container">
           
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text">
                            <p>
                                Copyright © 2021 Todos os direitos reservados
                            </p>
                        </div>
                        <div class="footer__copyright__payment"><img
                                src="img/xpayment-item.png.pagespeed.ic.fk3ziISga0.webp" alt=""
                                data-pagespeed-url-hash="577918195"
                                onload="pagespeed.CriticalImages.checkImageForCriticality(this);"></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

  </div>
</template>

<style scoped>
.logo{
    text-decoration: none;
    font-weight: bold;
    color: #000;
}
</style>

<script>
export default {
  async created() {
    this.isLoading = true;

    try {
      const { data } = await axios.get(
        `/categorias`
      );
      this.categorias = data;
    } finally {
      this.isLoading = false;
    }
  },
 
}
</script>