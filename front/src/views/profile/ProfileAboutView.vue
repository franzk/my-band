<template>
  <section id="bio">
    <article>
      {{ profileStore.profile?.bio }}
    </article>
  </section>
  <section id="pictures">
    <ProfileGallery />
  </section>
</template>

<script setup lang="ts">
import ProfileGallery from '@/components/profile/ProfileGallery.vue'
import { useProfileStore } from '@/stores/profileStore'

const profileStore = useProfileStore()
</script>

<style lang="scss" scoped>
#bio {
  padding: $spacing-medium;
  // border-bottom: 1px solid $shadow;
  background-color: $ghost;
  border-radius: $border-radius-small;
  margin: $spacing-medium;
}
</style>
