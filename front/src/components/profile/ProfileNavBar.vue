<template>
  <nav class="profile-navbar">
    <RouterLink :to="{ name: 'profile-posts' }"><IconActivity /></RouterLink>
    <RouterLink :to="{ name: 'profile-pictures' }"><IconPicture /></RouterLink>
    <RouterLink :to="{ name: 'profile-videos' }"><IconVideo /></RouterLink>
    <RouterLink :to="{ name: 'profile-music' }"><IconMusic /></RouterLink>
    <RouterLink :to="{ name: 'profile-links' }"><IconLink /></RouterLink>
  </nav>
</template>

<script setup lang="ts">
import IconPicture from '@/components/icons/IconPicture.vue'
import IconVideo from '@/components/icons/IconVideo.vue'
import IconMusic from '@/components/icons/IconMusic.vue'
import IconLink from '@/components/icons/IconLink.vue'
import IconActivity from '@/components/icons/IconActivity.vue'
</script>

<style lang="scss" scoped>
.profile-navbar {
  display: flex;
  justify-content: center;
  gap: $spacing-medium;

  margin: 0;
  padding: $spacing-small;
  background-color: $background;

  a {
    display: flex;
    flex-wrap: wrap;
    align-content: center;

    text-decoration: none;
    color: $primary;
    background: linear-gradient(135deg, $secondary, #d45959);

    padding: $spacing-small;
    border-radius: $border-radius-xxl;
    border: $border-size-small solid $primary;
    height: $profile-nav-icon-size;
    width: $profile-nav-icon-size;
  }

  a.active {
    background-color: $primary;
    color: $secondary;
  }

  svg {
    flex: 1;
  }
}
</style>
