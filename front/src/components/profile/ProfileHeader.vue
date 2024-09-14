<template>
  <div class="profile-header-cover">
    <div class="cover-image">
      <img
        :src="profileStore.profile?.coverPictureUrl"
        :alt="`${profileStore.profile?.name} cover picture`"
      />
    </div>
    <div class="profile-avatar">
      <img :src="profileStore.profile?.avatarUrl" :alt="`${profileStore.profile?.name} avatar`" />
    </div>
  </div>
  <div class="profile-header-title">
    <h1 class="lato-black profile-title">{{ profileStore.profile?.name }}</h1>
    <span class="lato-light-italic profile-slogan">{{ profileStore.profile?.slogan }}</span>
  </div>
  <section id="bio">
    <p>{{ profileStore.profile?.bio }}</p>
  </section>
  <ProfileActions />
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'
import ProfileActions from '@/components/profile/ProfileActions.vue'

const profileStore = useProfileStore()
</script>

<style lang="scss" scoped>
.profile-header-cover {
  position: relative;
  text-align: center;
  height: $profile-header-cover-height;
  margin-bottom: calc($profile-avatar-size / 2);

  .cover-image {
    width: 100%;
    height: 100%;
    overflow: hidden;
    clip-path: polygon(0 0, 100% 0, 100% 60%, 0 100%); /* cut the image in a triangle shape */
    margin-bottom: $spacing-medium;

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      object-position: top;
    }
  }

  .profile-avatar {
    position: absolute;
    width: $profile-avatar-size;
    height: $profile-avatar-size;
    border-radius: 50%;
    overflow: hidden;
    border: $border-size-small solid $primary;
    top: $profile-avatar-top;
    left: 50%;
    transform: translateX(-50%);

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
  }
}

.profile-header-title {
  text-align: center;
  margin-bottom: $spacing-medium;

  .profile-title {
    margin-top: 0;
    margin-bottom: $spacing-tiny;
  }

  .profile-slogan {
    font-size: $font-size-medium;
  }
}

#bio {
  padding: $spacing-small;
  background-color: $ghost;
  border-radius: $border-radius-small;
  margin: 0 $spacing-medium $spacing-medium $spacing-medium;
  p {
    margin: 0;
  }
}
</style>
