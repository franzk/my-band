<script setup lang="ts">
import PostFeed from '@/components/profile/post/PostFeed.vue'
import ProfileHeaderSmall from '@/components/profile/ProfileHeaderSmall.vue'
</script>

<template>
  <div class="profile-header">
    <ProfileHeaderSmall />
  </div>
  <section class="feed">
    <PostFeed />
  </section>
</template>

<style lang="scss" scoped></style>
