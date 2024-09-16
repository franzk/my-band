<template>
  <div class="post-view">Post id : {{ route.params.id }}</div>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router'

const route = useRoute()
</script>

<style lang="scss" scoped>
.post-view {
  text-align: center;
  margin: $spacing-large;
}
</style>
