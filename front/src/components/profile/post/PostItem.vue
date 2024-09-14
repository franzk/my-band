<template>
  <article class="post-item">
    <div class="text">
      <p>
        {{ post.content }}
      </p>
    </div>
    <div v-if="post.picture?.url" class="image">
      <img :src="post.picture.url" alt="" />
    </div>
    <div v-if="post.video?.youtubeId" class="video">
      <VideoPlayer :youtubeId="post.video.youtubeId" />
    </div>
    <div class="info">
      <p>{{ formattedDate }}</p>
    </div>
    <div v-if="post.comments" @click="showComments = !showComments">
      <p class="comments-count">{{ post.comments.length }} commentaires</p>
      <transition name="expand">
        <ul v-if="showComments">
          <li v-for="comment in post.comments" :key="comment.id">
            <CommentItem :comment="comment" />
          </li>
        </ul>
      </transition>
    </div>
  </article>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import type { Post } from '@/types/Post'
import dayjs from 'dayjs'
import 'dayjs/locale/fr'
import CommentItem from '@/components/profile/post/CommentItem.vue'
import VideoPlayer from '@/components/VideoPlayer.vue'

const props = defineProps({
  post: {
    type: Object as () => Post,
    required: true
  },
  profileAvatarUrl: {
    type: String,
    default: ''
  }
})

const showComments = ref(false)

dayjs.locale('fr')
const formattedDate = computed(() => dayjs(props.date).format('D MMMM YYYY'))

const postType = computed(() => {
  switch (true) {
    case !!props.post.picture?.url:
      return 'picture'
    case !!props.post.video?.youtubeId:
      return 'video'
    default:
      return 'text'
  }
})
</script>

<style lang="scss" scoped>
.post-item {
  display: flex;
  flex-direction: column;
  background-color: $ghost;
  padding: $spacing-small;
  border-radius: $border-radius-tiny;
  border: $border-size-tiny solid $shadow;

  .info {
    display: flex;
    font-size: $font-size-small;
    font-style: italic;

    img {
      width: 2rem;
      height: 2rem;
      border-radius: 50%;
      margin-right: $spacing-small;
      border: 1px solid white;
    }

    p {
      margin: 0;
      align-content: center;
    }
  }

  .text {
    flex: 1;
    p {
      margin: 0 0 $spacing-small 0;
    }
  }

  .image {
    text-align: center;

    img {
      width: 90%;
    }
  }

  ul {
    list-style: none;
    padding: 0;

    li {
      margin: $spacing-tiny;
    }
  }

  .comments-count {
    cursor: pointer;
    font-size: $font-size-small;
    font-style: italic;
    text-decoration: underline;
  }

  /* Transition for expanding down */
  .expand-enter-active,
  .expand-leave-active {
    transition: all 0.6s ease;
  }

  .expand-enter-from,
  .expand-leave-to {
    max-height: 0;
    opacity: 0;
    overflow: hidden;
  }

  .expand-enter-to,
  .expand-leave-from {
    max-height: 100rem;
    opacity: 1;
  }
}
</style>
