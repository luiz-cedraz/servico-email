<script lang="ts">
  import { defineComponent } from 'vue';
  import ListProducts from "../components/ListProducts.vue"

  export default defineComponent({
    name: "Products",
    components: {
      ListProducts
    }
  })
</script>

<template>
  <main class="products-view">
    <section>
      <ListProducts />
    </section>
  </main>
</template>

<style scoped>

</style>
