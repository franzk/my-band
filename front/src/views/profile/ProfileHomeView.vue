<template>
  <section id="video">
    <VideoPlayer :youtubeId="profileStore.profile?.video?.youtubeId" />
  </section>

  <section id="latest-posts">
    <PostFeed />
  </section>
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

#latest-posts {
  p {
    margin: 0 0 $spacing-medium $spacing-medium;
  }
}
</style>
