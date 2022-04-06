<template>
  <div class="black-bg" v-if="모달창열렸니">
    <div class="white-bg">
      <h4>상세페이지임</h4>
      <p>상세페이지 내용임</p>
      <button @click="모달창열렸니 = false">❌</button>
    </div>
  </div>

  <div class="menu">
    <a v-for="작명 in 메뉴들" :key="작명">{{ 작명 }}</a>
  </div>

  <img alt="Vue logo" src="./assets/logo.png" />
  <div>
    {{ logo }}
    <img src="./assets/room0.jpg" alt="" srcset="" class="room-img" />
    <h4 class="red" :style="스타일" @click="모달창열렸니 = true">
      {{ products[0] }}
    </h4>
    <p>{{ price1 }} 만원</p>
    <button @click="increase(0)">허위매물신고</button
    ><span>신고 수 : {{ 신고수[0] }} </span>
    <hr />
  </div>

  <div v-for="(숫자, i) in 2" :key="i">
    <img :src="사진[i]" alt="" srcset="" class="room-img" />
    <h4>{{ products[i] }}</h4>
    <p>{{ price2[i] }} 만원</p>
    <button @click="increase(i + 1)">허위매물신고</button
    ><span>신고 수 : {{ 신고수[i + 1] }} </span>
    <hr />
  </div>

  <div v-for="원룸 in 원룸들" :key="원룸">
    <img :src="원룸[0]" alt="" srcset="" class="room-img" />
    <h4>{{ 원룸[0] }}</h4>
    <p>{{ 원룸[0] }}원</p>
    <hr />
  </div>
</template>

<script>
import 자료 from "./data/post";
export default {
  name: "App",
  data() {
    return {
      모달창열렸니: false,
      price1: 60,
      price2: [70, 80],
      logo: "원룸샵",
      스타일: "color:blue",
      products: ["역삼동원룸", "천호동원룸", "마포구원룸"],
      메뉴들: ["Home", "Shop", "About"],
      신고수: [0, 0, 0],
      사진: [require("./assets/room1.jpg"), require("./assets/room2.jpg")],
      원룸들: 자료,
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
body {
  margin: 0;
}
div {
  box-sizing: border-box;
}
.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  padding: 20px;
}
.white-bg {
  width: 100%;
  background: white;
  border-radius: 8px;
  padding: 20px;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 10px;
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

.room-img {
  width: 100%;
  margin-top: 40px;
}
</style>
