<template>
  <div class="main">
    <div class="main_page">
      <h1>Diary</h1>
      <div class="content">
        <div align="left" class="text-section">
          <h2>음식에서 미식으로.</h2>
          <p></p>
          <pre>
It's delicious food that makes me live,
not a quote.</pre
          >

          <pre>
"미식일기는 단순히 음식을 찾는 곳 이상입니다."
맛있는 요리, 아름다운 음식 사진, 
그리고 특별한 식사 경험을 기억으로 남기세요.

</pre
          >

          <pre>
당신이 발견한 훌륭한 맛집에서의 경험을
다른 미식가들과 공유하고
기록을 하여 추억을 남겨보세요.
            </pre
          >

          <pre>
맛있는 순간을 놓치지 않고 기록할 수 있으며
다른 미식가와 소통하며 더 많은 맛을 발견할 수 있습니다
맛있는 여행의 기록을 시작하세요.</pre
          >
        </div>
        <div class="image-section">
          <img src="@/assets/1.png" alt="Food Image" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "DiaryComponent",
  data() {
    return {};
  },
};
</script>

<style>
.main {
  position: absolute;
  bottom: 0;
  right: 0;
}
.main_page {
  width: 85vw;
  height: 100vh;
  box-sizing: border-box;
  font-family: "Arial", sans-serif; /* Adjust as needed */
  display: flex;
  flex-direction: column;
  align-items: center;
}
h1 {
  font-size: 48px;
  margin-bottom: 20px;
}
.content {
  display: flex;
  gap: 20px;
  width: 100%;
}
.text-section {
  flex: 1;
  font-size: 24px;
}
h2 {
  font-size: 48px;
  margin-bottom: 20px;
}
.image-section img {
  max-width: 300%;
  height: auto;
  margin-top: -20%;
  margin-left: 20%;
}
</style>
