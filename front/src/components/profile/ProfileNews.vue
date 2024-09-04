<template>
  <ul>
    <li v-for="item in news" :key="item.id">
      <h3>{{ formatDate(item.date) }} : {{ item.title }}</h3>
      <p>{{ item.content }}</p>
    </li>
  </ul>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useNewsStore } from '@/stores/newsStore'
import dayjs from 'dayjs'

const formatDate = (date: Date) => dayjs(date).format('DD/MM/YYYY')

const newsStore = useNewsStore()
const news = ref(newsStore.latestNews)
</script>

<style lang="scss" scoped>
ul {
  list-style: none;
  padding: $spacing-small;

  li {
    border-bottom: 1px solid $shadow;
    h3 {
      margin-bottom: $spacing-small;
    }
  }
}
</style>
