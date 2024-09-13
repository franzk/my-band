<template>
  <nav>
    <ul>
      <li>
        <RouterLink :to="{ name: 'profile-home' }">
          <IconHome class="nav-icon" />
        </RouterLink>
      </li>
      <li>
        <RouterLink :to="{ name: 'profile-content-posts' }">
          <IconFeed class="nav-icon" />
        </RouterLink>
      </li>
    </ul>
  </nav>
</template>

<script setup lang="ts">
import IconHome from '@/components/icons/IconHome.vue'
import IconFeed from '@/components/icons/IconFeed.vue'
</script>

<style lang="scss" scoped>
nav {
  position: sticky;
  top: 0;
  height: 0;
  z-index: 1;
  width: 0;
  align-self: end;
  margin-right: $spacing-small;

  ul {
    display: flex;
    flex-direction: column;
    align-items: end;
    list-style: none;
    margin: 0;
    padding: $spacing-small $spacing-small 0 0;

    li {
      margin-bottom: $spacing-small;
      display: flex;
    }
  }

  .nav-icon {
    width: $profile-nav-icon-size;
    height: $profile-nav-icon-size;
    color: $primary;
    background-color: $secondary;
    border-radius: 50%;
    padding: $spacing-small;
  }
}
</style>
