<template>
  <section class="profile-header">
    <ProfileHeader
      title="Tranxen 200"
      slogan="Glucose Pop Rock"
      coverImageUrl="/fakedata/tranxen200/tranxen200-cover.png"
      avatarUrl="/fakedata/tranxen200/tranxen200-logo.png"
    />

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
