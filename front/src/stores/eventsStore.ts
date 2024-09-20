import type { Event } from '@/types/Event'
import type { Profile } from '@/types/Profile'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

/**
 * Store to manage the posts events
 * WARNING : this store is not complete, the fetchPosts method returns mock data
 * you have to implement the fetchEvents method to fetch the events from the API
 */
export const useEventsStore = defineStore('eventsStore', () => {
  const events = ref<Event[] | null>(null)

  const fetchEvents = async (profileId: string) => {
    const response = await axios.get(`http://localhost:3000/profiles/${profileId}`)
    const profile = response.data as Profile
    events.value = profile.events
  }

  return { events, fetchEvents }
})
