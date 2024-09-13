<template>
  <section class="profile">
    <ProfileHeader />

    <main>
      <RouterView />
    </main>
  </section>
</template>

<script setup lang="ts">
import ProfileHeader from '@/components/profile/ProfileHeader.vue'
import { useProfileStore } from '@/stores/profileStore'

const profileStore = useProfileStore()
profileStore.fetchProfile(1)
</script>

<style lang="scss" scoped>
.profile {
  position: relative;
  display: flex;
  flex-direction: column;
}
</style>
