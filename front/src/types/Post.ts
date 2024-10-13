import type { Picture } from '@/types/Picture'
import type { Video } from '@/types/Video'

/**
 * Post type
 */
export interface Post {
  id: string
  date: Date
  content: string
  picture?: Picture
  video?: Video
  comments?: Comment[]
  created: Date
  updated: Date
}
