import type { Picture } from '@/types/Picture'
import type { Video } from '@/types/Video'

/**
 * Post type
 */
export interface Post {
  id: string
  date: Date
  title: string
  content: string
  image?: Picture
  video?: Video
  created: Date
  updated: Date
}
