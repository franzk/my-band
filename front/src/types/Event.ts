import type { Picture } from '@/types/Picture'
import type { Comment } from '@/types/Comment'

export interface Event {
  id: string
  date: Date
  eventDate: string
  picture?: Picture
  title: string
  detail: string
  comments?: Comment[]
}
