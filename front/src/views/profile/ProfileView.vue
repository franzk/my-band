<template>
  <section class="profile-header">
    <ProfileHeader />

    <ProfileNavBar />
  </section>

  <main>
    <RouterView />
  </main>
</template>

<script setup lang="ts">
import ProfileHeader from '@/components/profile/ProfileHeader.vue'
import ProfileNavBar from '@/components/profile/ProfileNavBar.vue'
</script>
