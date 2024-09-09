<template>
  <vue-plyr>
    <div class="plyr__video-embed">
      <iframe
        :src="`https://youtube-nocookie.com/embed/${youtubeVideoId}`"
        allowfullscreen
        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
      >
      </iframe>
    </div>
  </vue-plyr>
</template>

<script setup lang="ts">
const props = defineProps({
  youtubeVideoId: String
})
</script>
