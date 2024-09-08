<template>
  <nav>
    <ul>
      <li>
        <RouterLink :to="{ name: 'profile-home' }">
          <IconHome class="nav-icon" />
        </RouterLink>
      </li>
      <li>
        <RouterLink :to="{ name: 'profile-about' }">
          <IconPlayCircle class="nav-icon" />
        </RouterLink>
      </li>

      <li>
        <RouterLink :to="{ name: 'profile-about' }">
          <IconGroup class="nav-icon" />
        </RouterLink>
      </li>
    </ul>
  </nav>
</template>

<script setup lang="ts">
import IconHome from '@/components/icons/IconHome.vue'
import IconGroup from '../icons/IconGroup.vue'
import IconPlayCircle from '../icons/IconPlayCircle.vue'
</script>

<style lang="scss" scoped>
nav {
  position: sticky;
  top: 0;
  height: 17rem;
  z-index: 1;

  ul {
    display: flex;
    flex-direction: column;
    align-items: end;
    list-style: none;
    margin: 0;
    padding: $spacing-small $spacing-small 0 0;

    li {
      margin-bottom: $spacing-small;
    }
  }

  .nav-icon {
    width: 2rem;
    height: 2rem;
    color: $primary;
    background-color: #aa1a1acc;
    border-radius: 50%;
    padding: $spacing-small;
  }
}
</style>
