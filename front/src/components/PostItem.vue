<template>
  <article>
    <div class="info">
      <img :src="profileAvatarUrl" alt="" />
      <p>{{ formattedDate }}</p>
    </div>
    <div class="text">
      <p>{{ content }}</p>
    </div>
    <div v-if="pictureUrl" class="image">
      <img :src="pictureUrl" alt="" />
    </div>
  </article>
</template>

<script setup lang="ts">
import { defineProps, computed } from 'vue'
import dayjs from 'dayjs'
import 'dayjs/locale/fr'

const props = defineProps({
  date: Date,
  profileAvatarUrl: String,
  content: String,
  pictureUrl: String
})

dayjs.locale('fr')
const formattedDate = computed(() => dayjs(props.date).format('D MMMM YYYY'))
</script>

<style lang="scss" scoped>
article {
  display: flex;
  flex-direction: column;
  padding-top: $spacing-small;
  background-color: $ghost;
  padding: $spacing-small;
  border-radius: $border-radius-small;

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
  }

  .image {
    text-align: center;

    img {
      width: 90%;
    }
  }
}
</style>
