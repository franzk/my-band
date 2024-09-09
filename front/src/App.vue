<script setup lang="ts">
import { RouterView } from 'vue-router'
import TheHeader from '@/components/TheHeader.vue'
</script>

<template>
  <header>
    <TheHeader />
  </header>
  <section class="main-section">
    <RouterView />
  </section>
</template>

<style scoped lang="scss">
header {
  line-height: 1.5;
  max-height: 100vh;
}
.main-section {
  flex: 1;
  overflow-y: auto;
}
</style>
