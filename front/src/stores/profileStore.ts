import type { Profile } from '@/types/Profile'
import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'

const profileAPIUrl = 'http://localhost:8201/api/v1/profile'

/**
 * Store to manage the profile data
 */
export const useProfileStore = defineStore('profileStore', () => {
  /**
   * list of profiles
   */
  const profileList = ref<Profile[]>([])

  /**
   * currently displayed profile
   */
  const profile = ref<null | Profile>(null)

  /**
   * error status of the last fetch
   */
  const error = ref<null | string>(null)

  /**
   * fetch all profiles from the API
   */
  const fetchProfiles = async () => {
    axios
      .get(profileAPIUrl)
      .then((response) => {
        profileList.value = response.data as Profile[]
        error.value = null
      })
      .catch((err) => {
        error.value = err.status ? err.status : 'error'
      })
  }

  /**
   * fetch a profile from the API
   * @param id : the id of the profile to fetch
   */
  const fetchProfile = async (username: string) => {
    axios
      .get(`${profileAPIUrl}/${username}`)
      .then((response) => {
        profile.value = response.data as Profile
        error.value = null
      })
      .catch((err) => {
        error.value = err.status ? err.status : 'error'
      })
  }

  return {
    profile,
    fetchProfile,
    profileList,
    fetchProfiles,
    error
  }
})
