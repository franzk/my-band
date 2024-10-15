import type { Image } from '@/types/Image'
import type { Video } from '@/types/Video'

/**
 * Post type
 */
export interface Post {
  id: string
  date: Date
  title: string
  content: string
  image?: Image
  video?: Video
  created: Date
  updated: Date
}
