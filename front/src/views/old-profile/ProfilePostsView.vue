<template>
  <PostFeed :profileId="RouteUtils.firstIfArray(route.params.id)" />
</template>

<script setup lang="ts">
import PostFeed from '@/components/profile/post/PostFeed.vue'
import { useRoute } from 'vue-router'
import { RouteUtils } from '@/utils/RouteUtils'

const route = useRoute()
</script>
