<template>
  <section class="profile-header">
    <ProfileHeader />
  </section>

  <section id="bio">
    <p>{{ profileStore.profile?.bio }}</p>
  </section>

  <section id="video">
    <!--ProfileVideo /-->
    <VideoPlayer :youtubeVideoId="profileStore.profile?.youtubeVideoId" />
  </section>

  <section id="latest-posts">
    <PostFeed :postCount="3" />
    <p>
      <RouterLink :to="{ name: 'profile-feed' }">voir tous les posts >></RouterLink>
    </p>
  </section>
</template>

<script setup lang="ts">
import ProfileHeader from '@/components/profile/ProfileHeader.vue'
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
#latest-posts {
  p {
    margin: 0 0 $spacing-medium $spacing-medium;
  }
}
</style>
