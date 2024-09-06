import type { NewsItem } from '@/types/NewsItem'
import type { Picture } from '@/types/Picture'

export interface Profile {
  id: number
  name: string
  slogan: string
  bio: string
  avatarUrl: string
  coverPictureUrl: string
  youtubeVideoId: string
  news: NewsItem[]
  pictures: Picture[]
}
