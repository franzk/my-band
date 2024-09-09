<template>
  <div>
    <VideoPlayer :youtubeVideoId="profileStore.profile?.youtubeVideoId" />
  </div>
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'
import VideoPlayer from '../VideoPlayer.vue'

const profileStore = useProfileStore()
</script>
