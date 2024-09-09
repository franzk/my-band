<template>
  <div class="search-bar">
    <span class="absolute-icon search-icon">
      <IconSearch />
    </span>
    <input type="input" v-model="searchVal" placeholder="Rechercher..." />
    <span v-if="searchVal" class="absolute-icon clear-icon" @click="searchVal = ''">
      <IconCancel />
    </span>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import IconSearch from '@/components/icons/IconSearch.vue'
import IconCancel from '@/components/icons/IconCancel.vue'

const searchVal = ref('')
</script>

<style scoped lang="scss">
.search-bar {
  display: flex;
  position: relative;
  width: 100%;
  height: 100%;
}

input {
  flex: 1;
  width: 100%;
  padding: $spacing-small 3rem $spacing-small 3rem;
  font-size: $font-size-medium;
  font-weight: normal;

  color: $primary;
  background-color: $black;
  border: $border-size-tiny solid $shadow;
  border-radius: $border-radius-xs;
  transition: border-color 0.15s ease-in-out;
  box-shadow: 1px 1px 2px $shadow;
}

.search-icon {
  left: $spacing-medium;
}

.clear-icon {
  right: $spacing-medium;
  cursor: pointer;
}
</style>
