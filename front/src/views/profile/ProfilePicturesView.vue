<template>
  <PicturesGallery :pictures="picturesStore.pictures" />
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router'
import { usePicturesStore } from '@/stores/picturesStore'
import PicturesGallery from '@/components/PicturesGallery.vue'
import { RouteUtils } from '@/utils/RouteUtils'

const route = useRoute()
const picturesStore = usePicturesStore()

picturesStore.fetchPictures(RouteUtils.firstIfArray(route.params.id))
</script>
