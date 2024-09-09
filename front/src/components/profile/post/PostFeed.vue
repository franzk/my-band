<template>
  <ul class="post-list">
    <li v-for="item in posts" :key="item.id">
      <PostItem :post="item" />
    </li>
  </ul>
</template>

<script setup lang="ts">
import { computed } from 'vue'
import { useProfileStore } from '@/stores/profileStore'
import PostItem from '@/components/profile/post/PostItem.vue'

const props = defineProps({
  postCount: {
    type: Number,
    default: undefined
  }
})

const profileStore = useProfileStore()

const posts = computed(() =>
  props.postCount
    ? profileStore.profile?.posts.slice(0, props.postCount)
    : profileStore.profile?.posts
)
</script>

<style lang="scss" scoped>
.post-list {
  list-style: none;
  padding: $spacing-small $spacing-small 0 $spacing-small;
  margin-bottom: 0;

  li {
    margin: $spacing-tiny;
    margin-bottom: $spacing-medium;
  }
}
</style>
