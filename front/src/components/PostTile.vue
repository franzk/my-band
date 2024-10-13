<template>
  <div class="post-tile">
    <img :src="imageUrl" alt="Post image" class="post-tile-image" />
    <h3 class="post-tile-title">{{ title }}</h3>
  </div>
</template>

<script setup lang="ts">
const props = defineProps({
  title: {
    type: String,
    required: true
  },
  imageUrl: {
    type: String,
    default: ''
  }
})
</script>

<style scoped lang="scss">
.post-tile {
  position: relative;
  aspect-ratio: 0.8;
  overflow: hidden;
  border-radius: 15px;
}

.post-tile-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 15px;
}

.post-tile-title {
  position: absolute;
  bottom: 0;
  left: 0;
  background: rgba(0, 0, 0, 0.5);
  color: $primary;
  text-align: center;
  margin: 0;
  padding: 10px;
  font-size: 18px;
  border-bottom-left-radius: 15px;
  border-bottom-right-radius: 15px;
}
</style>
