<template>
  <ul>
    <li v-for="(video, index) in videosStore.videos" :key="index">
      <VideoPlayer :youtubeId="video.youtubeId" />
    </li>
  </ul>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router'
import { useVideosStore } from '@/stores/videosStore'
import { RouteUtils } from '@/utils/RouteUtils'
import VideoPlayer from '@/components/VideoPlayer.vue'

const route = useRoute()
const videosStore = useVideosStore()

videosStore.fetchVideos(RouteUtils.firstIfArray(route.params.id))
</script>

<style lang="scss" scoped>
ul {
  list-style: none;
  display: flex;
  flex-direction: column;
  width: 100%;
  padding: 0;

  li {
    padding: $spacing-small;
    margin-bottom: $spacing-small;
  }
}
</style>
