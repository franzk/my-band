<template>
  <ul>
    <li v-for="pictureUrl in profileStore.profile.picturesUrls" :key="pictureUrl">
      <!-- TODO améliorer la key pictureUrl n'est pas forcément unique -->
      <img :src="pictureUrl" />
    </li>
  </ul>
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'

const profileStore = useProfileStore()
</script>

<style lang="scss" scoped>
ul {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(10rem, 1fr));
  gap: $spacing-medium;
  padding: $spacing-medium;

  li {
    width: 100%;
    height: 100%;
    object-fit: cover;
    display: block;

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      display: block;
      border-radius: 0 $border-radius;
    }
  }
}
</style>
