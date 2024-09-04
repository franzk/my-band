<template>
  <ul>
    <li><img src="/fakedata/tranxen200/t1.jpg" /></li>
    <li><img src="/fakedata/tranxen200/t2.jpg" /></li>
    <li><img src="/fakedata/tranxen200/t3.png" /></li>
    <li><img src="/fakedata/tranxen200/t4.jpg" /></li>
  </ul>
</template>

<script setup lang="ts"></script>

<style lang="scss" scoped>
ul {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(10rem, 1fr));
  gap: $spacing-medium;
  padding: $spacing-medium;

  li {
    width: 100%;
    height: 100%;
    object-fit: cover;
    display: block;

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      display: block;
      border-radius: 0 $border-radius;
    }
  }
}
</style>
