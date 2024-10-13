<template>
  <ProfileHeader
    :title="profileStore.profile?.title || ''"
    :cover="profileStore.profile?.coverImageUrl"
    :bio="profileStore.profile?.bio"
  />

  <section id="tags">
    <TagsList :tags="profileStore.profile?.tags || []" />
  </section>

  <section id="cta">
    <RoundedButton class="cta-btn" variant="primary">FOLLOW</RoundedButton>
    <RoundedButton class="cta-btn" variant="secondary">MESSAGE</RoundedButton>
  </section>

  <section id="video">
    <VideoPlayer :youtubeId="profileStore.profile?.youtubeId" />
  </section>

  <section id="latest-posts">
    {{ postStore.posts }}
  </section>
</template>

<script setup lang="ts">
import { ErrorUtils } from '@/utils/ErrorUtils'
import { useProfileStore } from '@/stores/profileStore'
import { watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { RouteUtils } from '@/utils/RouteUtils'
import ProfileHeader from '@/components/profile/ProfileHeader.vue'
import VideoPlayer from '@/components/VideoPlayer.vue'
import RoundedButton from '@/components/RoundedButton.vue'
import TagsList from '@/components/TagsList.vue'
import { usePostStore } from '@/stores/postStore'

const route = useRoute()
const router = useRouter()

// Profile Data Zone

// Fetch profile
const profileStore = useProfileStore()
profileStore.fetchProfile(RouteUtils.firstIfArray(route.params.id))

// error handling
if (profileStore.error) {
  // TODO tester de l'enlever
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

// Posts Data Zone
const postStore = usePostStore()
watch(
  () => profileStore.profile?.id,
  (profileId) => {
    if (profileId) {
      postStore.getPosts(profileId)
    }
  }
)

watch(
  () => postStore.error,
  (error) => {
    if (error) {
      showErrorPage(error)
    }
  }
)

// functions
function showErrorPage(error: string) {
  router.push({ name: ErrorUtils.errorRouteName(error) })
}
</script>

<style scoped lang="scss">
#video {
  margin: $spacing-small;
  box-shadow: 1px 1px 5px 0 $accent;
}

#tags {
  margin: $spacing-small;
}

#cta {
  display: flex;
  flex-direction: row;
  justify-content: center;
  .cta-btn {
    margin: $spacing-small;
    width: 40%;
  }
}
</style>
