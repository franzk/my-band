<template>
  {{ props }}
</template>

<script setup lang="ts">
import type { Post } from '@/types/Post'

const props = defineProps({
  post: {
    type: Object as () => Post,
    required: true
  },
  profileTitle: {
    type: String,
    default: ''
  },
  profileAvatarUrl: {
    type: String,
    default: ''
  }
})
</script>
