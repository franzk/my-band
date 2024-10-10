<template>
  <div class="profile-events-view">
    <EventFeed :profileId="RouteUtils.firstIfArray(route.params.id)" />
  </div>
</template>

<script setup lang="ts">
import EventFeed from '@/components/profile/event/EventFeed.vue'
import { useRoute } from 'vue-router'
import { RouteUtils } from '@/utils/RouteUtils'

const route = useRoute()
</script>

<style lang="scss" scoped>
.profile-events-view {
  text-align: center;
  margin: $spacing-small;
}
</style>
