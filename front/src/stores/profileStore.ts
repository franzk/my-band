import type { Profile } from '@/types/Profile'
import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'

export const useProfileStore = defineStore('profileStore', () => {
  const profile = ref(null as Profile | null)

  const fetchProfile = async (id: number) => {
    // Fetch the profile from the API
    const response = await axios.get(`http://localhost:3000/profiles/${id}`)
    const data = await response.data

    profile.value = data as Profile
  }

  return { profile, fetchProfile }
})
