import type { Picture } from '@/types/Picture'
import type { Post } from './Post'

export interface Profile {
  id: number
  name: string
  slogan: string
  bio: string
  avatarUrl: string
  coverPictureUrl: string
  youtubeVideoId: string
  posts: Post[]
  pictures: Picture[]
}
