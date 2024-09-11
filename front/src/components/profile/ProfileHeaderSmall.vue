<template>
  <div class="profile-header-small">
    <div class="profile-avatar">
      <img :src="profileStore.profile?.avatarUrl" :alt="`${profileStore.profile?.name} avatar`" />
    </div>
    <h1 class="lato-black profile-title">{{ profileStore.profile?.name }}</h1>
  </div>
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'

const profileStore = useProfileStore()
</script>

<style lang="scss" scoped>
.profile-header-small {
  height: $profile-header-height-small;
  display: flex;
  flex-direction: row;
  width: 100%;
  padding: $spacing-small;
  gap: $spacing-small;

  .profile-avatar {
    width: $profile-avatar-size-small;
    height: $profile-avatar-size-small;
    border-radius: 50%;
    overflow: hidden;
    border: $border-size-small solid $primary;
    top: $profile-avatar-top;
    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
  }

  .profile-title {
    margin-top: 0;
    align-content: center;
    margin-block: 0;
  }
}
</style>
