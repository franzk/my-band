<template>
  <vue-plyr v-if="youtubeId">
    <div class="plyr__video-embed">
      <iframe
        :src="`https://youtube-nocookie.com/embed/${youtubeId}`"
        allowfullscreen
        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
      >
      </iframe>
    </div>
  </vue-plyr>
  <div v-else class="skeleton video-placeholder"></div>
</template>

<script setup lang="ts">
const props = defineProps({
  youtubeId: {
    type: String,
    default: ''
  }
})
</script>

<style lang="scss" scoped>
.video-placeholder {
  width: 100%;
  height: calc(100vw * 9 / 16);
}
</style>
