<template>
  <div class="chips-menu">
    <RouterLink :to="{ name: 'profile-home' }"><IconHome /></RouterLink>
    <RouterLink :to="{ name: 'profile-pictures' }">P</RouterLink>
    <RouterLink :to="{ name: 'profile-videos' }"><IconPlayCircle /></RouterLink>
    <RouterLink :to="{ name: 'profile-music' }">M</RouterLink>
    <RouterLink :to="{ name: 'profile-links' }">L</RouterLink>
  </div>
</template>

<script setup lang="ts">
import IconHome from '@/components/icons/IconHome.vue'
import IconPlayCircle from '@/components/icons/IconPlayCircle.vue'
</script>

<style lang="scss" scoped>
.chips-menu {
  display: flex;
  gap: $spacing-small;
  margin: $spacing-small;
  padding: $spacing-small;
  background-color: $black;
  border-radius: $border-radius-small;
  a {
    text-decoration: none;
    color: $primary;
    padding: $spacing-small;
    border-radius: $border-radius-xxl;
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
