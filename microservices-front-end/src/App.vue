<script lang="ts">
  import { defineComponent } from 'vue';
  import { RouterLink, RouterView } from 'vue-router'

  export default defineComponent({
    name: "App",
    components: {
      RouterLink,
      RouterView
    }
  })
</script>

<template>
  <nav class="navigation">
    <RouterLink class="butao" to="/">Home</RouterLink>
    <RouterLink class="butao" to="/products">Produtos</RouterLink>
  </nav>
  <RouterView />
</template>

<style scoped>

.navigation {
  justify-content: flex-start;
}

.butao {
  align-items: center;
  background-color: #fee6e3;
  border: 2px solid #111;
  border-radius: 8px;
  box-sizing: border-box;
  color: #111;
  cursor: pointer;
  display: flex;
  font-family: Inter,sans-serif;
  font-size: 16px;
  height: 48px;
  justify-content: center;
  line-height: 24px;
  max-width: 100%;
  padding: 0 25px;
  position: relative;
  text-align: center;
  text-decoration: none;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  margin-left: 30px
}

.butao:after {
  background-color: #111;
  border-radius: 8px;
  content: "";
  display: block;
  height: 48px;
  left: 0;
  width: 100%;
  position: absolute;
  top: -2px;
  transform: translate(8px, 8px);
  transition: transform .2s ease-out;
  z-index: -1;
}

.butao:hover:after {
  transform: translate(0, 0);
}

.butao:active {
  background-color: #ffdeda;
  outline: 0;
}

.butao:hover {
  outline: 0;
}

</style>
