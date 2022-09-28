<script lang="ts">
import { defineComponent } from "vue";
import api from "../services/api";

export default defineComponent({
  name: "ListProducts",
  data() {
    return {
      products: [],
    };
  },
  created() {
    this.getProducts();
  },
  methods: {
    formatCoin(value: any) {
      const formatter = new Intl.NumberFormat("pt-BR", {
        style: "currency",
        currency: "BRL",
      });
      return formatter.format(value);
    },
    getProducts() {
      api
        .get("/products")
        .then((res) => {
          this.products = res.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
});
</script>

<template>
  <section class="container">
    <table class="styled-table" v-if="products.length > 0">
      <thead>
        <tr>
          <th>Título</th>
          <th>Preço</th>
          <th>Descrição</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody v-for="product in products">
        <tr>
          <td>{{ product.title }}</td>
          <td>{{ formatCoin(product.price) }}</td>
          <td>{{ product.description }}</td>
          <td>{{ product.active ? "ativo" : "desativado" }}</td>
        </tr>
      </tbody>
    </table>
    <div v-else>
      <p>A lista de produtos está vazia!</p>
    </div>
  </section>
</template>

<style scoped>
.container {
  width: 1300px
}

.container h1,
p {
  text-align: center;
  margin: 50px 30px;
}

p {
  font-size: 18px;
  color: #009879;
}

.styled-table {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.styled-table thead tr {
  background-color: #d32a;
  color: #ffffff;
  text-align: left;
}

.styled-table th,
.styled-table td {
  padding: 12px 15px;
}

.styled-table tbody tr {
  border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
  border-bottom: 2px solid #d32a;
}
.styled-table tbody tr.active-row {
  font-weight: bold;
  color: #009879;
}
</style>
