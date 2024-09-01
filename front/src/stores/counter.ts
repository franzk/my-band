import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useExampleStore = defineStore('example', () => {
  const greeting = ref('hello')
  const userName = ref('John Doe')
  const usersCount = ref(22)
  const welcome = computed(() => `${greeting.value} ${userName.value}`)

  function newUser() {
    usersCount.value++
  }

  return { usersCount, userName, welcome, newUser }
})
