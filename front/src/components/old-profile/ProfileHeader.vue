<template>
  <div class="profile-header-cover">
    <!-- cover and avatar -->
    <div class="cover-image" :class="{ skeleton: !profileStore.profile }">
      <img
        v-if="profileStore.profile?.coverImageUrl"
        :src="profileStore.profile?.coverImageUrl"
        :alt="altCoverImage"
      />
    </div>

    <div class="profile-avatar">
      <img
        v-if="profileStore.profile?.avatarUrl"
        :src="profileStore.profile?.avatarUrl"
        :alt="altAvatarImage"
        class="rounded-image"
      />
    </div>
  </div>

  <!-- title and slogan -->
  <div class="profile-header-title">
    <h1 class="lato-black profile-title" :class="{ skeleton: !profileStore.profile }">
      {{ profileStore.profile?.name }}
    </h1>
    <span class="lato-light-italic profile-slogan" :class="{ skeleton: !profileStore.profile }">{{
      profileStore.profile?.slogan
    }}</span>
  </div>

  <!-- actions -->
  <ProfileActions />
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'
import ProfileActions from '@/components/profile/ProfileActions.vue'
import { computed } from 'vue'

const profileStore = useProfileStore()

const altCoverImage = computed(() =>
  profileStore.profile?.name ? `${profileStore.profile.name} cover image` : ''
)

const altAvatarImage = computed(() =>
  profileStore.profile?.name ? `${profileStore.profile.name} avatar image` : ''
)
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
    top: $profile-avatar-top;
    left: 50%;
    transform: translateX(-50%);
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
    margin-bottom: 0;
  }
}
</style>
