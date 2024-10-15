import type { Picture } from '@/types/Picture'

export interface Event {
  id: string
  date: Date
  eventDate: string
  picture?: Picture
  title: string
  detail: string
}
