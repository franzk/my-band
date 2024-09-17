<template>
  <div class="profile-header-small">
    <div class="profile-avatar">
      <RouterLink :to="{ name: 'profile-home', params: { id: profileStore.profile?.id } }">
        <img :src="profileStore.profile?.avatarUrl" :alt="`${profileStore.profile?.name} avatar`" />
      </RouterLink>
    </div>
    <h1 class="lato-black profile-title" ref="title">
      {{ profileStore.profile?.name }}
    </h1>
  </div>
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'
import { RouterLink } from 'vue-router'

const profileStore = useProfileStore()
</script>

<style lang="scss" scoped>
.profile-header-small {
  height: $profile-header-height-small;
  display: flex;
  flex-direction: row;
  padding: $spacing-small;
  gap: $spacing-small;
  overflow: hidden;

  .profile-avatar {
    width: $profile-avatar-size-small;
    height: $profile-avatar-size-small;
    border-radius: 50%;
    overflow: hidden;
    border: $border-size-small solid $primary;
    flex-shrink: 0;
    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
  }

  .profile-title {
    margin-top: 0;
    display: flex;
    flex-wrap: wrap;
    align-content: center;
    margin-block: 0;
    font-size: 1.5rem;
  }
}
</style>
