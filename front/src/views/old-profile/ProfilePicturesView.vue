<template>
  <PicturesGallery :pictures="pictureStore.pictures || []" />
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router'
import { usePictureStore } from '@/stores/pictureStore'
import PicturesGallery from '@/components/PicturesGallery.vue'
import { RouteUtils } from '@/utils/RouteUtils'

const route = useRoute()
const pictureStore = usePictureStore()

pictureStore.getPictures(RouteUtils.firstIfArray(route.params.id))
</script>
