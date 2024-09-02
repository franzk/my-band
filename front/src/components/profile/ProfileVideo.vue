<template>
  <div class="profile-video">
    <vue-plyr>
      <div class="plyr__video-embed">
        <iframe
          :src="`https://youtube-nocookie.com/embed/${youtubeId}`"
          allowfullscreen
          allowtransparency
          allow="autoplay"
        >
        </iframe>
      </div>
    </vue-plyr>
  </div>
</template>

<script setup lang="ts">
const props = defineProps({
  youtubeId: String // ZTeqM5gciH8
})
</script>
