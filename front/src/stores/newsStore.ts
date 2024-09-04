// import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

interface News {
  id: number
  date: Date
  title: string
  content: string
}

export const useNewsStore = defineStore('newsStore', () => {
  const latestNews = [
    { id: 1, date: new Date(), title: 'Hello', content: 'World' } as News,
    { id: 2, date: new Date(), title: 'Hello', content: 'World' } as News,
    { id: 3, date: new Date(), title: 'Hello', content: 'World' } as News,
    { id: 4, date: new Date(), title: 'Hello', content: 'World' } as News
  ]

  return { latestNews }
})
