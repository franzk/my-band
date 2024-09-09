<template>
  <div class="profile-video">
    <vue-plyr>
      <div class="plyr__video-embed">
        <iframe
          :src="`https://youtube-nocookie.com/embed/${profileStore.profile?.youtubeVideoId}`"
          allowfullscreen
          allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
        >
        </iframe>
      </div>
    </vue-plyr>
  </div>
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'

const profileStore = useProfileStore()
</script>
