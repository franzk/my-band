<template>
  <ul v-if="postList" class="post-list">
    <li v-for="item in postList" :key="item.id">
      <PostItem :post="item" />
    </li>
  </ul>
  <div v-else>
    <!-- placeholders -->
    <PostItem :skeleton="true" />
    <PostItem :skeleton="true" />
    <PostItem :skeleton="true" />
  </div>
</template>

<script setup lang="ts">
import PostItem from '@/components/profile/post/PostItem.vue'
import type { Post } from '@/types/Post'
import { computed, onMounted, type PropType } from 'vue'
import { usePostStore } from '@/stores/postStore'

const props = defineProps({
  profileId: {
    type: String,
    default: undefined
  },
  posts: {
    type: Array as PropType<Post[]> | undefined,
    default: undefined
  }
})

const postStore = usePostStore()

const postList = computed(() => props.posts || postStore.posts)

onMounted(() => {
  if (!props.posts && props.profileId) {
    postStore.getPosts(props.profileId)
  }
})
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
