<template>
  <section id="video">
    <ProfileVideo />
  </section>
  <section id="news">
    <ProfileFeed />
  </section>
</template>

<script setup lang="ts">
import ProfileFeed from '@/components/profile/ProfileFeed.vue'
import ProfileVideo from '@/components/profile/ProfileVideo.vue'
</script>
