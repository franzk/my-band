<template>
  <nav>
    <ul>
      <li>
        <RouterLink :to="{ name: 'profile-home' }"> What's up </RouterLink>
      </li>
      <li>
        <RouterLink :to="{ name: 'profile-about' }"> About</RouterLink>
      </li>
    </ul>
  </nav>
</template>

<script setup lang="ts"></script>

<style lang="scss" scoped>
nav {
  width: 100%;
  border-bottom: 1px solid $ghost;
  margin-top: 3.5rem;

  ul {
    width: 100%;
    display: flex;
    flex-direction: row;
    align-items: start;
    list-style: none;
    padding: 0;
    margin: $spacing-small 0;

    li {
      flex: 1;
      text-align: center;
      margin: 0 $spacing-small;
      a {
        text-decoration: none;
        color: $primary;
      }
    }
  }
}
</style>
