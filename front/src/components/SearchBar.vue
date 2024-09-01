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
@import '@/assets/variables.scss';

.search-bar {
  display: flex;
  position: relative;
  width: 100%;
  height: 100%;
}

input {
  flex: 1;
  padding: 0.5rem 3rem 0.5rem 3rem;
  font-size: 16px;
  font-weight: normal;

  color: $primary;
  background-color: #00000022;
  border: 1px solid $shadow;
  border-radius: 4px;
  transition: border-color 0.15s ease-in-out;
  box-shadow: 1px 1px 2px $shadow;
}

.search-icon {
  left: 1rem;
}

.clear-icon {
  right: 1rem;
  cursor: pointer;
}
</style>
