<template>
  <nav>
    <ul>
      <li><a href="#video">Video</a></li>
      <li><a href="#bio">Bio</a></li>
      <li><a href="#pictures">Pictures</a></li>
      <li><a href="#news">News</a></li>
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
    display: flex;
    flex-direction: row;
    align-items: start;
    list-style: none;
    padding: 0;
    margin: $spacing-small 0;

    li {
      margin: 0 $spacing-small;
      a {
        text-decoration: none;
        color: $primary;
      }
    }
  }
}
</style>
