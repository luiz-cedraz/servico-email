<script lang="ts">
import { defineComponent } from "vue";
import api from "../services/api";

export default defineComponent({
  name: "ListEmails",
  data() {
    return {
      filter: new Date("1970-01-01"),
      emails: [],
    };
  },
  created() {
    this.getEmails();
  },
  methods: {
    getEmails() {
      api
        .get("/emails")
        .then((res) => {
          this.emails = res.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getFormatedDate(data: Date) {
      const formatedDate = ('0' + data.getDate()).slice(-2);
      const month = ('0' + (data.getMonth() + 1)).slice(-2);
      const year = data.getFullYear();
      return `${formatedDate}/${month}/${year}`;
    }
  },
  computed: {
    filteredRows() {
      return this.emails.filter(row => {
        const searchTerm = Date.parse(this.filter);
        return Date.parse(row.sendDateEmail) >= searchTerm;
    });
  }
  },
});
</script>

<template>
  <section class="container">
    <br/>
    <span>Filtrar a partir de:   </span>
    <input 
      type="date"
      placeholder="Filter by department or employee"
      v-model="filter" />
    <table class="styled-table" v-if="emails.length > 0">
      <thead>
        <tr>
          <th>De</th>
          <th>Para</th>
          <th>Mensagem</th>
          <th>Data de Envio</th>
        </tr>
      </thead>
      <tbody v-for="email in filteredRows">
        <tr>
          <td>{{ email.emailFrom }}</td>
          <td>{{ email.emailTo }}</td>
          <td>{{ email.text }}</td>
          <td>{{ getFormatedDate(new Date(email.sendDateEmail)) }}</td>
        </tr>
      </tbody>
    </table>
    <div v-else>
      <p>A lista de emails está vazia!</p>
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
