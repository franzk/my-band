import type { Picture } from '@/types/Picture'
import type { Post } from '@/types/Post'
import type { Video } from '@/types/Video'

/**
 * Profile type
 */
export interface Profile {
  id: string
  name: string
  slogan: string
  bio: string
  avatarUrl: string
  coverPictureUrl: string
  video: Video
  posts: Post[]
  pictures: Picture[]
}
