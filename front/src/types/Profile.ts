import type { Picture } from '@/types/Picture'
import type { Post } from '@/types/Post'
import type { Video } from '@/types/Video'
import type { Event } from '@/types/Event'

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
  events: Event[]
}
