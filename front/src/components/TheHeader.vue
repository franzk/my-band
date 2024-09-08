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
  border-bottom: $border-size-tiny solid $shadow;
  line-height: 0;
  position: relative;

  .logo {
    position: absolute;
    left: $spacing-small;
    top: $spacing-small;
    cursor: pointer;
    img {
      width: $search-bar-height;
      height: $search-bar-height;
    }
  }

  .search {
    height: $search-bar-height;
    margin-left: auto;
    margin-right: auto;
    width: 60%;
  }

  .user {
    right: $spacing-small;
  }
}
</style>
