<template>
   <div class="main">
    <div id="container">
      <header id="header"> 
        <nav class="menu">
          <ul>
            <li><router-link to="/index"><b>인사</b></router-link></li>
            <li><router-link to="/about"><b>소개</b></router-link></li>
            <li><router-link to="/favorites"><b>목표</b></router-link></li>
            <li><router-link to="/contact"><b>연락처</b></router-link></li>
          </ul>
        </nav>
      </header> 
  
      <div class="list">
        <div class="one">
          <span class="profile"><img src="./imgs/sex.png" width="550px" height="550px" alt=""/></span> 
          <h3 style="color: white;"><strong>음식에서 미식으로.</strong> <br>It's delicious food that makes me live</h3>
        </div>
      </div>
      
      <div class="list">
        <div class="two">
          <img class="me" src="./imgs/이맛은.png" alt=""  style="margin-top: 0px;" width="450px" height="500px">
            <h3 style="color: white;" class="intext"><strong>"미식일기는 단순히 음식을 찾는 곳 이상입니다."<br>Gourmet Diary is more than just a place to find food.</strong><br><br>
                당신은 어제 무엇을 먹었는지 무슨맛이였는지 기억나시나요?<br>
                맛있는 요리, 아름다운 음식<br><br>
                당신이 발견한 훌륭한 맛집에서의 경험을 <br>
                다른 미식가들과 공유하고 <br>
                기록을 하여 추억을 남겨보세요 <br><br>
                가족들과 단란한 외식경험 <br>
                친구들과 돈을모아 먹어본 음식 <br>
                이러한 특별한 경험들을 모아 <br><br>
              "미식일기"가 완성됩니다. <br>
              </h3>
        </div>
      </div>
      
      <div class="list">
        <div class="three">
          <h1><br><br> 💕 💕 💕 </h1>
          <div class="favorites">
            <div class="lists">
              <img class="list_img" src="./imgs/whatilove/빵.jpg" alt="">
                <p  class="list_text" style="color: white;"> 탄수화물 뿌수기</p>
              </div>
  
              <div class="lists">
                <img class="list_img" src="./imgs/whatilove/고기.jpeg" alt="">
                <p class="list_text" style="color: white;"> 단백질 뿌수기</p>
              </div>
  
              <div class="lists">
                <img class="list_img" src="./imgs/whatilove/지방.jpg" alt="">
                <p class="list_text" style="color: white;"> 지방 뿌수기</p>
              </div>
  
              <div class="lists">
                <img class="list_img" src="./imgs/whatilove/식이섬유.jpg" alt="">
                <p class="list_text"> 식이섬유 넌 나가라</p>
            </div>
          </div>
        </div>
      </div>
  
      <div class="list">
        <div class="four">
          <img class="contact_img" src="./imgs/bg.jpg">
          <a href="블로그주소" class="ct">Blog</a>
          <a href="지멜주소" class="ct">Gmail</a>
          <a href="깃헙주소넣기" class="ct">Github</a>
        </div>
      </div>
    </div>
</div>
  </template>
  
  <script>
  export default {
    name: 'IndexPage',
    // 필요한 데이터와 메서드를 여기에 추가할 수 있습니다.
  };
  </script>
  
  <style scoped>
 @import url('https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap');
 @import './css/main.css';
  @import './css/scroll.css';
  
  </style>
  