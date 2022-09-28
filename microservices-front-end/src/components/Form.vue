<script lang="ts">
import { defineComponent } from "vue";
import api from "../services/api";

interface FormData {
  product: {
    title: string;
    description: string;
    price: number;
    active: boolean;
  };
  isViewFeedback: boolean;
  isSuccess: boolean;
}

interface CreateProduct {
  title: string;
  description: string;
  price: number;
  active: boolean;
}

export default defineComponent({
  name: "Form",
  data(): FormData {
    return {
      product: {
        title: "",
        description: "",
        price: 0,
        active: true,
      },
      isViewFeedback: false,
      isSuccess: true,
    };
  },
  methods: {
    async createProduct(product: CreateProduct) {
      const body = product;
      try {
        const response = await api.post("/products", body);
        this.isViewFeedback = true;
        this.isSuccess = true;
      } catch (error) {
        this.isViewFeedback = true;
        this.isSuccess = false;
      }
    },
    handleCreateProduct(event: Event) {
      event.preventDefault();
      if (
        this.product.title != "" &&
        this.product.description != "" &&
        this.product.price > 0
      ) {
        this.createProduct(this.product);
      }
    },
  },
});
</script>

<template>
  <section class="cadastro">
    <h1>Cadastro de produtos</h1>
    <form class="form" @submit="handleCreateProduct($event)">
      <div class="form__field">
        <label for="titulo">Título:</label>
        <input type="text" name="titulo" id="titulo" v-model="product.title" />
      </div>
      <div class="form__field">
        <label for="price">Preço:</label>
        <input type="number" name="price" id="price" v-model="product.price" />
      </div>
      <div class="form__field">
        <label for="description">Descrição:</label>
        <input
          type="text"
          name="description"
          id="description"
          v-model="product.description"
        />
      </div>
      <button type="submit">Cadastrar produto</button>
    </form>
    <p
      class="feedback"
      :class="[isSuccess ? 'success' : 'error']"
      v-show="isViewFeedback"
    >
      {{
        isSuccess
          ? "Produto cadastrado"
          : "Não foi possível cadastrar o produto"
      }}
    </p>
  </section>
</template>

<style scoped>
.cadastro {
  width: 1200px;
  background-color: #fee6e3;
  border-radius: 30px;
}
.cadastro h1 {
  margin: 50px 30px;
  font-weight: bold;
}
.form {
  width: 100%;
}
.form__field {
  width: 100%;
  display: flex;
  justify-content: flex-start;
  margin: 10px 20px 0px;
}
.form__field label {
  font-size: 15px;
  min-width: 100px;
}
.form__field input {
  width: 20%;
  border-radius: 6px;
  border: 1px solid #222222;
  padding: 6px 10px;
  font-size: 14px;
}

.form button {
  align-items: center;
  appearance: button;
  background-color: #0276FF;
  border-radius: 8px;
  border-style: none;
  box-shadow: rgba(255, 255, 255, 0.26) 0 1px 2px inset;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  display: flex;
  flex-direction: row;
  flex-shrink: 0;
  font-family: "RM Neue",sans-serif;
  font-size: 100%;
  line-height: 1.15;
  margin: 0;
  padding: 10px 21px;
  text-align: center;
  text-transform: none;
  transition: color .13s ease-in-out,background .13s ease-in-out,opacity .13s ease-in-out,box-shadow .13s ease-in-out;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  margin: 30px 0px 0px 100px;
  width: 130px;
  height: 50px;
}

.form button:active {
  background-color: #006AE8;
}

.form button:hover {
  background-color: #1C84FF;
}

.feedback {
  margin: 20px 0px;
  text-align: center;
  font-size: 16px;
  font-weight: bold;
  border-radius: 8px;
  padding: 8px;
}
.feedback.error {
  background-color: #ff033e;
}
.feedback.success {
  background-color: #a4c639;
}
</style>
