<template>
  <ul v-if="eventList" class="event-list">
    <li v-for="item in eventList" :key="item.id">
      <EventCard :event="item" />
    </li>
  </ul>
  <div v-else>
    <!-- placeholders -->
    <EventCard :skeleton="true" />
    <EventCard :skeleton="true" />
    <EventCard :skeleton="true" />
  </div>
</template>

<script setup lang="ts">
import EventCard from '@/components/profile/event/EventCard.vue'
import type { Event } from '@/types/Event'
import { computed, onMounted, type PropType } from 'vue'
import { useEventStore } from '@/stores/eventStore'

const props = defineProps({
  profileId: {
    type: String,
    default: undefined
  },
  events: {
    type: Array as PropType<Event[]> | undefined,
    default: undefined
  }
})

const eventStore = useEventStore()

const eventList = computed(() => props.events || eventStore.events)

onMounted(() => {
  if (!props.events && props.profileId) {
    eventStore.getEvents(props.profileId)
  }
})
</script>

<style lang="scss" scoped>
.event-list {
  list-style: none;
  padding: $spacing-small $spacing-small 0 $spacing-small;
  margin-bottom: 0;

  li {
    margin: $spacing-tiny;
    margin-bottom: $spacing-medium;
  }
}
</style>
