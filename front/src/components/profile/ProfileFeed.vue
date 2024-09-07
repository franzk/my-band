<template>
  <ul>
    <li v-for="item in profileStore.profile?.posts" :key="item.id">
      <PostItem :post="item" />
    </li>
  </ul>
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'
import PostItem from '@/components/profile/post/PostItem.vue'

const profileStore = useProfileStore()
</script>

<style lang="scss" scoped>
ul {
  list-style: none;
  padding: $spacing-small;

  li {
    margin: $spacing-tiny;
  }
}
</style>
