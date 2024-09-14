<template>
  <!--section class="profile-header">
    <ProfileHeader />
  </section -->

  <section id="video">
    <!--ProfileVideo /-->
    <VideoPlayer :youtubeId="profileStore.profile?.video?.youtubeId" />
  </section>

  <section id="latest-posts">
    <PostFeed />
  </section>
</template>

<script setup lang="ts">
// import ProfileHeader from '@/components/profile/ProfileHeader.vue'
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
