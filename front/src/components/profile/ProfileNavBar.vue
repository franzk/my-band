<template>
  <div class="chips-menu">
    <RouterLink :to="{ name: 'profile-home' }">Posts</RouterLink>
    <RouterLink :to="{ name: 'profile-pictures' }">Pictures</RouterLink>
    <RouterLink :to="{ name: 'profile-videos' }">Videos</RouterLink>
    <RouterLink :to="{ name: 'profile-music' }">Music</RouterLink>
    <RouterLink :to="{ name: 'profile-links' }">Links</RouterLink>
  </div>
</template>

<script setup lang="ts"></script>

<style lang="scss" scoped>
.chips-menu {
  display: flex;
  gap: $spacing-small;
  margin: $spacing-small;
  padding: $spacing-small;
  background-color: black;
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
