<template>
  <!-- bio -->
  <section id="bio" :class="{ skeleton: !profileStore.profile }">
    <p v-if="profileStore.profile?.bio">{{ profileStore.profile?.bio }}</p>
  </section>

  <section id="video">
    <VideoPlayer :youtubeId="profileStore.profile?.video?.youtubeId" />
  </section>

  <section id="posts">
    <PostFeed :posts="profileStore.profile?.posts" />
  </section>

  <RouterLink :to="{ name: 'profile-posts' }" class="all-posts-link">View all posts</RouterLink>
</template>

<script setup lang="ts">
import VideoPlayer from '@/components/VideoPlayer.vue'
import PostFeed from '@/components/profile/post/PostFeed.vue'
import { useProfileStore } from '@/stores/profileStore'

const profileStore = useProfileStore()
</script>

<style lang="scss" scoped>
.profile-header {
  height: $profile-header-height;
}

#bio {
  padding: $spacing-small;
  background-color: $ghost;
  border-radius: $border-radius-small;
  margin: 0 $spacing-medium $spacing-medium $spacing-medium;
  p {
    margin: 0;
  }
}

#posts {
  p {
    margin: 0 0 $spacing-medium $spacing-medium;
  }
}

.all-posts-link {
  margin: $spacing-medium;
}
</style>
