<template>
  {{ profileStore.error }}
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
import { ErrorUtils } from '@/services/errorUtils'
import { useProfileStore } from '@/stores/profileStore'
import { handleError, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()
const profileStore = useProfileStore()

const id = Array.isArray(route.params.id) ? route.params.id[0] : route.params.id
profileStore.fetchProfile(id)

// error handling
if (profileStore.error) {
  showErrorPage(profileStore.error)
}

watch(
  () => profileStore.error,
  (error) => {
    if (error) {
      showErrorPage(error)
    }
  }
)

function showErrorPage(error: string) {
  router.push({ name: ErrorUtils.errorRouteName(error) })
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
