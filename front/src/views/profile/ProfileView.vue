<template>
  <section class="profile">
    <ProfileNavBar />

    <!--section class="profile-header">
      <ProfileHeader />
    </section-->

    <main>
      <RouterView />
    </main>
  </section>
</template>

<script setup lang="ts">
// import ProfileHeader from '@/components/profile/ProfileHeader.vue'
import ProfileNavBar from '@/components/profile/ProfileNavBar.vue'
import { useProfileStore } from '@/stores/profileStore'

const profileStore = useProfileStore()
profileStore.fetchProfile(1)
</script>

<style lang="scss" scoped>
.profile {
  position: relative;

  margin: {
    position: absolute;
    top: 0;
  }

  /*.profile-header {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    height: $profile-header-height;
  }*/
}
</style>
