<template>
  <div class="profile-header-cover">
    <div class="cover-image">
      <img
        :src="profileStore.profile?.coverPictureUrl"
        class="profile-picture"
        :alt="`${profileStore.profile?.name} cover picture`"
      />
    </div>
    <div class="profile-avatar">
      <img
        :src="profileStore.profile?.avatarUrl"
        class="profile-logo"
        :alt="`${profileStore.profile?.name} avatar`"
      />
    </div>
    <h1 class="lato-black profile-title">{{ profileStore.profile?.name }}</h1>
    <span class="lato-light-italic profile-slogan">{{ profileStore.profile?.slogan }}</span>
  </div>
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'

const profileStore = useProfileStore()
</script>

<style lang="scss" scoped>
.profile-header-cover {
  position: relative;
  text-align: center;
  height: 10rem;
  padding-bottom: 3rem;

  .cover-image {
    width: 100%;
    height: 100%;
    overflow: hidden;
    clip-path: polygon(0 0, 100% 0, 100% 60%, 0 100%); /* Coupe la photo en biais */
    margin-bottom: 1rem;

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      object-position: top;
    }
  }

  .profile-avatar {
    position: absolute;
    width: 5rem;
    height: 5rem;
    border-radius: 50%;
    overflow: hidden;
    border: 2px solid $shadow;
    top: 6rem;
    left: 50%;
    transform: translateX(-50%);
    box-shadow: 2px 2px 5px $ghost;

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
  }

  .profile-title {
    margin-top: 0;
    margin-bottom: $spacing-tiny;
  }

  .profile-slogan {
    font-size: 1rem;
  }
}
</style>
