<template>
  <section class="profile-header">
    <ProfileHeader
      title="Tranxen 200"
      slogan="Glucose Pop Rock"
      coverImageUrl="/src/assets/fakedata/tranxen200/tranxen200-photo.webp"
      avatarUrl="/src/assets/fakedata/tranxen200/tranxen200-logo.png"
    />

    <ProfileNavBar />
  </section>

  <main>
    <section id="video">
      <ProfileVideo />
    </section>
    <section id="bio">bio</section>
    <section id="pictures">pictures</section>
    <section id="news">news</section>
  </main>
</template>

<script setup lang="ts">
import ProfileHeader from '@/components/profile/ProfileHeader.vue'
import ProfileNavBar from '@/components/profile/ProfileNavBar.vue'
import ProfileVideo from '@/components/profile/ProfileVideo.vue'
</script>
