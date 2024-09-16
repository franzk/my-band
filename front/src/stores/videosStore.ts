import type { Profile } from '@/types/Profile'
import type { Video } from '@/types/Video'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

/**
 * Store to manage the videos data
 * WARNING : this store is not complete, the fetchVideos method returns mock data
 * you have to implement the fetchVideos method to fetch the pictures from the API
 */
export const useVideosStore = defineStore('videosStore', () => {
  const videos = ref<Video[] | null>(null)

  const fetchVideos = async (profileId: string) => {
    const response = await axios.get(`http://localhost:3000/profiles/${profileId}`)
    const profile = response.data as Profile
    videos.value = (profile.posts.filter((p) => p.video).map((p) => p.video) || []) as Video[]
  }

  return { videos, fetchVideos }
})
