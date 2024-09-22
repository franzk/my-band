<template>
  <article class="event-card shadow-box">
    <div class="event-image">
      <img :src="event.picture?.url" alt="" />
    </div>
    <div class="event-info">
      <p class="event-date" :class="{ skeleton: skeleton }">{{ formattedDate }}</p>
      <h3 class="event-title" :class="{ skeleton: skeleton }">{{ event.title }}</h3>
    </div>
  </article>
</template>

<script setup lang="ts">
import { computed } from 'vue'
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
  props.event.eventDate ? dayjs(props.event.eventDate).format('D MMMM YYYY') : ''
)
</script>

<style lang="scss" scoped>
.event-card {
  display: flex;
  background-color: $ghost;
  border-radius: $border-radius;
  overflow: hidden;
  padding: 0;
  margin: 0;
}

.event-image {
  flex-basis: 25%;
  flex-shrink: 0;
}

.event-image img {
  width: 100%;
}

.event-info {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.event-date {
  margin: 0;
  padding: 0;
}

.event-title {
  margin: 0;
  padding: 0;
}
</style>
