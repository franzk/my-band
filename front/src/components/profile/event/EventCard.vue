<template>
  <article class="event-item box-shadow">
    <!-- image -->
    <div class="image">
      <img :src="event.picture?.url" alt="" />
    </div>
    <div class="info" :class="{ skeleton: skeleton }">
      <!-- title -->
      <p class="title" :class="{ skeleton: skeleton }">{{ formattedDate }} - {{ event.title }}</p>
      <!-- detail -->
      <p class="detail" :class="{ skeleton: skeleton }">
        {{ event.detail }}
      </p>
    </div>
  </article>
</template>

<script setup lang="ts">
import { computed, ref } from 'vue'
import type { Event } from '@/types/Event'
import dayjs from 'dayjs'

const props = defineProps({
  event: {
    type: Object as () => Event,
    default: () => ({})
  },
  skeleton: {
    type: Boolean,
    default: false
  }
})

dayjs.locale('fr')
const formattedDate = computed(() =>
  props.event.eventDate ? dayjs(props.event.eventDate).format('DD/MM/YYYY') : ''
)
</script>
