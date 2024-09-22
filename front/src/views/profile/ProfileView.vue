<template>
  <section class="profile">
    <!--div class="profile-header" -->
    <ProfileHeader v-if="route.name === 'profile-home'" />
    <ProfileHeaderSmall v-else />
    <!-- /div -->
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
import { ErrorUtils } from '@/utils/ErrorUtils'
import { useProfileStore } from '@/stores/profileStore'
import { watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { RouteUtils } from '@/utils/RouteUtils'
import ProfileHeaderSmall from '@/components/profile/ProfileHeaderSmall.vue'

const route = useRoute()
const router = useRouter()
const profileStore = useProfileStore()

// fetch profile
profileStore.fetchProfile(RouteUtils.firstIfArray(route.params.id))

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
