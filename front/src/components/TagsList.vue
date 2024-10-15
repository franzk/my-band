<template>
  <ul id="tags">
    <li v-for="tag in tags" :key="tag" class="tag">#{{ tag.toUpperCase() }}</li>
  </ul>
</template>

<script setup lang="ts">
const props = defineProps({
  tags: {
    type: Array<string>,
    required: true
  }
})
</script>

<style scoped lang="scss">
#tags {
  display: flex;
  flex-direction: row;
  justify-content: center;
  list-style: none;
  padding: 0;
  font-size: $font-size-small;
  .tag {
    margin: $spacing-tiny;
    padding: $spacing-small $spacing-medium;
    min-width: 4rem;
    border-radius: 25px;
    border: 2px solid $accent;
    color: $primary;
    text-align: center;
    font-weight: bold;
  }
}
</style>
