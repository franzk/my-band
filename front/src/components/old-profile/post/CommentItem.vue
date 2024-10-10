<template>
  <article class="comment-item">
    <div class="info">
      <p>{{ comment.author }} - {{ comment.date }}</p>
    </div>
    <div class="text">
      <p>{{ comment.content }}</p>
    </div>
  </article>
</template>

<script setup lang="ts">
import type { Comment } from '@/types/Comment'

const props = defineProps({
  comment: {
    type: Object as () => Comment,
    required: true
  }
})
</script>

<style lang="scss" scoped>
.comment-item {
  display: flex;
  flex-direction: column;
  background-color: $ghost;
  padding: 0rem $spacing-small;
  border-radius: $border-radius-small;
  border: 1px solid $shadow;

  .info {
    display: flex;
    font-size: $font-size-small;
    line-height: $font-size-small;
    font-style: italic;
    p {
      margin-bottom: 0;
    }
  }

  .text {
    margin-top: $spacing-tiny;
  }
}
</style>
