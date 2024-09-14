<template>
  {{ profileStore.profile?.name }}
  {{ postStore.post }}
</template>

<script setup lang="ts">
import { usePostStore } from '@/stores/postStore'
import { useProfileStore } from '@/stores/profileStore'

const postStore = usePostStore()
const profileStore = useProfileStore()
</script>
