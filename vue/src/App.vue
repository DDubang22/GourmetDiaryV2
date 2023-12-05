<template>
 <div>
  <Mainpage />
  <router-view></router-view> 
  hello
 </div>
</template>

<script>

import Mainpage from './components/MainPage.vue'

export default {
  name: 'App',
  components: {
    Mainpage,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
</style>
