/**
 * Profile type
 */
export interface Profile {
  id: string
  username: string
  title: string
  slogan: string
  bio: string
  avatarUrl?: string
  coverImageUrl?: string
  youtubeId?: string
  tags: string[]
  created: Date
  updated?: Date
}
