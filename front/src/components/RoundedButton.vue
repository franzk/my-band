<template>
  <button :class="buttonClass">
    <slot />
  </button>
</template>

<script setup lang="ts">
import { computed } from 'vue'

const props = defineProps({
  variant: {
    type: String,
    default: 'primary',
    validator: (value: string) => ['primary', 'accent'].includes(value)
  }
})
const buttonClass = computed(() => (props.variant === 'primary' ? 'primary' : 'accent'))
</script>

<style scoped lang="scss">
button {
  border-radius: 25px;
  font-size: 1rem;
  font-weight: bolder;
  border: none;
  padding: 0.8rem 1rem;
}
.primary {
  background-color: $primary;
  color: $secondary;
}
.accent {
  background-color: $accent;
  color: $primary;
}
</style>
