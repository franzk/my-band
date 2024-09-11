<script setup lang="ts">
import PostFeed from '@/components/profile/post/PostFeed.vue'
import ProfileHeaderSmall from '@/components/profile/ProfileHeaderSmall.vue'
</script>

<template>
  <div class="profile-header">
    <ProfileHeaderSmall />
  </div>
  <div class="chips-menu">
    <RouterLink :to="{ name: 'profile-home' }">Posts</RouterLink>
    <RouterLink :to="{ name: 'profile-home' }">Media</RouterLink>
    <RouterLink :to="{ name: 'profile-home' }">Links</RouterLink>
  </div>
  <section class="feed">
    <PostFeed />
  </section>
</template>

<style lang="scss" scoped>
.chips-menu {
  display: flex;
  gap: $spacing-small;
  margin: $spacing-small;
  padding: $spacing-small;
  background-color: $ghost;
  border-radius: $border-radius-small;
  a {
    text-decoration: none;
    color: $primary;
    padding: $spacing-small;
    border-radius: $border-radius-small;
    background-color: $secondary;
  }
  a.active {
    background-color: $primary;
    color: $secondary;
  }
  .router-link-exact-active {
    border-bottom: 1px solid #123456;
  }
}
</style>
