import type { Image } from '@/types/Image'

export interface Event {
  id: string
  date: Date
  eventDate: string
  image?: Image
  title: string
  detail: string
}
