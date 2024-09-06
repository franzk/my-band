<template>
  <div class="header">
    <span class="logo">
      <RouterLink to="/">
        <img src="@/assets/images/myband.jpg" />
      </RouterLink>
    </span>
    <span class="search"><SearchBar /></span>
    <span class="absolute-icon user">
      <RouterLink to="/account">
        <IconUser />
      </RouterLink>
    </span>
  </div>
</template>

<script setup lang="ts">
import SearchBar from '@/components/SearchBar.vue'
import IconUser from '@/components/icons/IconUser.vue'
</script>

<style scoped lang="scss">
.header {
  display: flex;
  padding: $spacing-small;
  border-bottom: 1px solid $shadow;
  line-height: 0;
  position: relative;

  .logo {
    position: absolute;
    left: $spacing-small;
    top: $spacing-small;
    cursor: pointer;
    img {
      width: 2.5rem;
      height: 2.5rem;
    }
  }

  .search {
    height: 2.5rem;
    margin-left: auto;
    margin-right: auto;
    width: 60%;
  }

  .user {
    right: $spacing-small;
  }
}
</style>
