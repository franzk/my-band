import { defineStore } from 'pinia'
import { ref } from 'vue'
import type { Profile } from '@/types/Profile'
import type { NewsItem } from '@/types/NewsItem'

const testProfile: Profile = {
  id: 1,
  name: 'Tranxen 200',
  slogan: 'Glucose for your ears',
  bio: 'Tranxen 200 is a band from France. They are known for their unique style of music, which combines elements of rock, pop, and electronica.',
  avatarUrl: '/fakedata/tranxen200/tranxen200-logo.png',
  coverPictureUrl: '/fakedata/tranxen200/tranxen200-cover.png',
  youtubeVideoId: 'ZTeqM5gciH8',
  news: [
    { id: 1, date: new Date(), title: 'Hello', content: 'World' } as NewsItem,
    { id: 2, date: new Date(), title: 'Hello', content: 'World' } as NewsItem,
    { id: 3, date: new Date(), title: 'Hello', content: 'World' } as NewsItem,
    { id: 4, date: new Date(), title: 'Hello', content: 'World' } as NewsItem,
    { id: 5, date: new Date(), title: 'Hello', content: 'World' } as NewsItem
  ],
  picturesUrls: [
    '/fakedata/tranxen200/t1.jpg',
    '/fakedata/tranxen200/t2.jpg',
    '/fakedata/tranxen200/t3.png',
    '/fakedata/tranxen200/t4.jpg'
  ]
}

export const useProfileStore = defineStore('profileStore', () => {
  const profile = ref(testProfile)

  return { profile }
})
