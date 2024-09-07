import type { Picture } from '@/types/Picture'

export interface Post {
  id: number
  date: Date
  content: string
  picture?: Picture
  comments?: Comment[]
}
