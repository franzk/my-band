import type { Picture } from '@/types/Picture'
import type { Video } from '@/types/Video'

/**
 * Post type
 */
export interface Post {
  id: number
  date: Date
  content: string
  picture?: Picture
  video?: Video
  comments?: Comment[]
}
