<template>
  <div class="menu">
    <a v-for="작명 in 메뉴들" :key="작명">{{ 작명 }}</a>
  </div>

  <img alt="Vue logo" src="./assets/logo.png" />
  <div>
    {{ logo }}
    <h4 class="red" :style="스타일">{{ products[0] }}</h4>
    <p>{{ price1 }} 만원</p>
    <button @click="increase(0)">허위매물신고</button
    ><span>신고 수 : {{ 신고수[0] }} </span>
    <hr />
  </div>
  <div v-for="(숫자, i) in 2" :key="i">
    <h4>{{ products[숫자] }}</h4>
    <p>{{ price2[i] }} 만원</p>
    <button @click="increase(i + 1)">허위매물신고</button
    ><span>신고 수 : {{ 신고수[i + 1] }} </span>
    <hr />
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      price1: 60,
      price2: [70, 80],
      logo: "원룸샵",
      스타일: "color:blue",
      products: ["역삼동원룸", "천호동원룸", "마포구원룸"],
      메뉴들: ["Home", "Shop", "About"],
      신고수: [0, 0, 0],
    };
  },
  methods: {
    increase(i) {
      this.신고수[i]++;
    },
  },
  components: {},
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.menu {
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}
.menu a {
  color: white;
  padding: 10px;
}
</style>
