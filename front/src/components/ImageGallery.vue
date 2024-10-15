<template>
  <ul>
    <li v-for="image in images" :key="image.id">
      <RouterLink :to="{ name: 'post', params: { id: image.relatedPostId } }">
        <img :src="image.url" class="box-shadow" />
      </RouterLink>
    </li>
  </ul>
</template>

<script setup lang="ts">
import type { Image } from '@/types/Image'
import type { PropType } from 'vue'

const props = defineProps({
  images: {
    type: Array as PropType<Image[]>,
    default: () => []
  }
})
</script>

<style lang="scss" scoped>
ul {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(10rem, 1fr));
  gap: $spacing-medium;
  padding: $spacing-medium;

  li {
    width: 100%;
    height: 100%;
    object-fit: cover;
    display: block;

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      display: block;
      border-radius: 0 $border-radius;
    }
  }
}
</style>
