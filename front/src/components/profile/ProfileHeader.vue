<template>
  <div class="profile-header">
    <div class="image-container">
      <img :src="cover" alt="Image" />
      <div class="overlay"></div>
    </div>
    <div class="text-container">
      <h1>{{ title }}</h1>
      <p>{{ bio }}</p>
    </div>
  </div>
</template>

<script setup lang="ts">
const props = defineProps({
  title: {
    type: String,
    required: true
  },
  avatar: {
    type: String,
    default: ''
  },
  cover: {
    type: String,
    default: ''
  },
  bio: {
    type: String,
    default: ''
  }
})
</script>

<style scoped lang="scss">
.profile-header {
  position: relative;
  height: 10rem;
}

.image-container {
  position: relative;
  height: 7rem;
  overflow: hidden;
}

.image-container img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(to right, rgba($secondary, 1) 0%, rgba(0, 0, 0, 0) 300%),
    linear-gradient(to top, rgba($secondary, 1) 0%, rgba(0, 0, 0, 0) 10%);
}

.text-container {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  padding: $spacing-small;

  h1 {
    color: $primary;
    margin: 0;
  }

  p {
    color: $primary;
    margin: $spacing-small 0 0 0;
  }
}
</style>
