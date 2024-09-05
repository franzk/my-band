import type { NewsItem } from '@/types/NewsItem'

export interface Profile {
  id: number
  name: string
  slogan: string
  bio: string
  avatarUrl: string
  coverPictureUrl: string
  youtubeVideoId: string
  news: NewsItem[]
  picturesUrls: string[]
}
