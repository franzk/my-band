import type { Picture } from '@/types/Picture'
import type { Post } from '@/types/Post'
import type { Video } from '@/types/Video'

export interface Profile {
  id: number
  name: string
  slogan: string
  bio: string
  avatarUrl: string
  coverPictureUrl: string
  video: Video
  posts: Post[]
  pictures: Picture[]
}
