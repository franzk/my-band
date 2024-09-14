<template>
  <section class="profile">
    <div class="profile-header">
      <ProfileHeader />
    </div>
    <div class="profile-nav">
      <ProfileNavBar />
    </div>
    <main class="profile-main">
      <RouterView />
    </main>
  </section>
</template>

<script setup lang="ts">
import ProfileHeader from '@/components/profile/ProfileHeader.vue'
import ProfileNavBar from '@/components/profile/ProfileNavBar.vue'
import { useProfileStore } from '@/stores/profileStore'
import { useRoute } from 'vue-router'

const route = useRoute()
const profileStore = useProfileStore()

const profileId = Array.isArray(route.params.id) ? route.params.id[0] : route.params.id

if (profileId) {
  profileStore.fetchProfile(profileId)
}
</script>

<style lang="scss" scoped>
.profile {
  position: relative;
  display: flex;
  flex-direction: column;

  .profile-header {
    position: relative;
  }

  .profile-nav {
    position: sticky;
    top: 0;
    z-index: 1;
  }
}
</style>
