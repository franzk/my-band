<template>
  <div class="profile-header">
    <div class="image-container">
      <img :src="cover" alt="Image" />
      <div class="overlay"></div>
    </div>
  </div>
  <div class="title">
    <h1>{{ title }}</h1>
  </div>
  <p class="bio">{{ bio }}</p>
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
}

.image-container {
  position: relative;
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
  background: linear-gradient(to top, rgba($secondary, 1) 5%, rgba(0, 0, 0, 0) 25%);
}

.title {
  margin-top: -2rem;
  position: relative;

  padding: 0 0 0 $spacing-small;

  h1 {
    color: $primary;
    margin: 0;
  }
}

.bio {
  padding: $spacing-small;
  margin: 0;
}
</style>
