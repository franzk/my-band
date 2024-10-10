<template>
  <ul>
    <li v-for="(video, index) in videoStore.videos" :key="index">
      <VideoPlayer :youtubeId="video.youtubeId" />
    </li>
  </ul>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router'
import { useVideoStore } from '@/stores/videoStore'
import { RouteUtils } from '@/utils/RouteUtils'
import VideoPlayer from '@/components/VideoPlayer.vue'

const route = useRoute()
const videoStore = useVideoStore()

videoStore.getVideos(RouteUtils.firstIfArray(route.params.id))
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
