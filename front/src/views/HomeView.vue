<template>
  <div class="home">
    <div v-for="profile in profileStore.profileList" :key="profile.id">
      <RouterLink :to="`/profile/${profile.username}`">{{ profile.title }}</RouterLink>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useProfileStore } from '@/stores/profileStore'

const profileStore = useProfileStore()
profileStore.fetchProfiles()
</script>

<style lang="scss" scoped>
.home {
  width: 100%;
  height: 60%;
  text-align: center;
  align-content: center;
}
</style>
