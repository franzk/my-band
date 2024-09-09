<template>
  <ul class="post-list">
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
.post-list {
  list-style: none;
  padding: $spacing-small;

  li {
    margin: $spacing-tiny;
    margin-bottom: $spacing-medium;
  }
}
</style>
