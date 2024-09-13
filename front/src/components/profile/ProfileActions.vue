<template>
  <div class="profile-actions">
    <button @click="followProfile">
      <span v-if="isFollowed">Unfollow</span>
      <span v-else>Follow</span>
    </button>
    <button>Message</button>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const isFollowed = ref(false)

const followProfile = () => {
  isFollowed.value = !isFollowed.value
}
</script>

<style lang="scss" scoped>
.profile-actions {
  display: flex;
  justify-content: center;
  gap: $spacing-medium;

  button {
    padding: $spacing-small $spacing-medium;
    border: none;
    border-radius: $border-radius-small;
    background-color: $primary;
    color: $secondary;
    cursor: pointer;
  }
}
</style>
