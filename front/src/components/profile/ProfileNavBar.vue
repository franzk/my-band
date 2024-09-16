<template>
  <div class="profile-navbar">
    <RouterLink :to="{ name: 'profile-home' }"><IconHome /></RouterLink>
    <RouterLink :to="{ name: 'profile-pictures' }"><IconPicture /></RouterLink>
    <RouterLink :to="{ name: 'profile-videos' }"><IconVideo /></RouterLink>
    <RouterLink :to="{ name: 'profile-music' }"><IconMusic /></RouterLink>
    <RouterLink :to="{ name: 'profile-links' }"><IconLink /></RouterLink>
  </div>
</template>

<script setup lang="ts">
import IconHome from '@/components/icons/IconHome.vue'
import IconPicture from '@/components/icons/IconPicture.vue'
import IconVideo from '@/components/icons/IconVideo.vue'
import IconMusic from '@/components/icons/IconMusic.vue'
import IconLink from '@/components/icons/IconLink.vue'
</script>

<style lang="scss" scoped>
.profile-navbar {
  display: flex;
  justify-content: center;
  gap: $spacing-medium;

  margin: $spacing-small;
  padding: $spacing-small;
  border-radius: $border-radius-small;
  background-color: $black;

  a {
    text-decoration: none;
    color: $primary;
    background-color: $secondary;

    padding: $spacing-medium;
    border-radius: $border-radius-xxl;
    border: $border-size-small solid $primary;
    height: 24px;
  }

  a.active {
    background-color: $primary;
    color: $secondary;
  }
}
</style>
