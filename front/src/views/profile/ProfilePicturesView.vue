<template>
  Pictures
  {{ route.params.id }}
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router'
// import { UsePicturesStore } from '@/stores/picturesStore'

const route = useRoute()
// const picturesStore = UsePicturesStore()

// picturesStore.fetchPictures(route.params.id)
</script>
