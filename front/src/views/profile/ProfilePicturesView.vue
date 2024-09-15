<template>
  Pictures
  {{ route.params.id }}
  {{ picturesStore.pictures }}
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router'
import { usePicturesStore } from '@/stores/picturesStore'

const route = useRoute()
const picturesStore = usePicturesStore()

picturesStore.fetchPictures(route.params.id)
</script>
