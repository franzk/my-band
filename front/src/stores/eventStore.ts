import type { Event } from '@/types/Event'
import type { Profile } from '@/types/Profile'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

/**
 * Store to manage the events
 * WARNING : this store is not complete, the getEvents method returns mock data
 * you have to implement the getEvents method to fetch the events from the API
 */
export const useEventStore = defineStore('eventStore', () => {
  const events = ref<Event[] | null>(null)

  const getEvents = async (profileId: string) => {
    const response = await axios.get(`http://localhost:3000/profiles/${profileId}`)
    const profile = response.data as Profile
    events.value = profile.events
  }

  return { events, getEvents }
})
