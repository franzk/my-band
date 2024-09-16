<template>
  <ul>
    <li v-for="picture in props.pictures" :key="picture.id">
      <RouterLink :to="{ name: 'post', params: { id: picture.relatedPostId } }">
        <img :src="picture.url" />
      </RouterLink>
    </li>
  </ul>
</template>

<script setup lang="ts">
import type { Picture } from '@/types/Picture'
import type { PropType } from 'vue'

const props = defineProps({
  pictures: {
    type: Array as PropType<Picture[]>,
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
