<script lang="ts">
  import { defineComponent } from 'vue';
  import ListEmails from "../components/ListEmails.vue"

  export default defineComponent({
    name: "Emails",
    components: {
      ListEmails
    }
  })
</script>

<template>
  <main class="emails-view">
    <section>
      <ListEmails />
    </section>
  </main>
</template>

<style scoped>

</style>
