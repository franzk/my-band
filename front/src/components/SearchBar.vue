<template>
  <div class="search-bar">
    <span class="icon search-icon">
      <IconSearch />
    </span>
    <input type="input" v-model="searchVal" placeholder="Rechercher..." />
    <span v-if="searchVal" class="icon clear-icon" @click="searchVal = ''">
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
}

input {
  flex: 1;
  padding: 0.5rem 3rem 0.5rem 3rem;
  font-size: 16px;
  font-weight: normal;
  height: 38px;
  color: $primary;
  background-color: #00000022;
  border: 1px solid $primary;
  border-radius: 0;
  transition: border-color 0.15s ease-in-out;
  box-shadow: 1px 1px 2px $primary;
}

.icon {
  position: absolute;
  color: $primary;
  top: 0;
  display: block;
  width: 1.5rem;
  height: 100%;
  align-content: center;
  filter: brightness(70%);
}

.search-icon {
  left: 1rem;
}

.clear-icon {
  right: 1rem;
  cursor: pointer;
}
</style>
