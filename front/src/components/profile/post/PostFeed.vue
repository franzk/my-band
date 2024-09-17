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
import { useProfileStore } from '@/stores/profileStore'
import PostItem from '@/components/profile/post/PostItem.vue'
import type { Post } from '@/types/Post'
import { onMounted, ref, type PropType } from 'vue'
import { usePostsStore } from '@/stores/postsStore'

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

const postList = ref<Post[]>([])

onMounted(() => {
  if (props.posts) {
    postList.value = props.posts
  } else if (props.profileId) {
    const postsStore = usePostsStore()
    postsStore.fetchPosts(props.profileId)
    postList.value = postsStore.posts || []
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
