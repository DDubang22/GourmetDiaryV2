<template>
    <div class="main">
    <div>
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
          <div class="two">
            <img class="me" src="./imgs/이맛은.png" alt=""  style="margin-top: 80px;" width="450px" height="500px">
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
              
              <br>
              To the world of gourmet food!</h3>
          </div>
        </div>
      </div>
    </div>
</div>
  </template>
  
  <script>
  export default {
    name: 'AboutPage',
    // 필요한 데이터와 메서드를 여기에 추가할 수 있습니다.
  };
  </script>
  
  <style>
 @import url('https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap');
 @import './css/main.css';
  @import './css/scroll.css';
  @import './css/about.css';

  .list{
    width: 85vw;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    scroll-snap-align: center;
}

/* .list:nth-child(1){
    background-color: rgb(0, 0, 0);
    background-size: cover;
    background-attachment: fixed; 
    background-position: center; 
} */

.list:nth-child(2){
    background-color: #4e5a56;
    background-size: cover;
    background-attachment: fixed; 
    background-position: center; 
}

.list:nth-child(3){
    background-color: #9d949e;
    background-size: cover;
    background-attachment: fixed; 
    background-position: center; 
}

.list:nth-child(4){
    background-color: #e0d8cc;
    background-size: cover;
    background-attachment: fixed; 
    background-position: center; 
}

.list:nth-child(5){
    background-color: #b39db3;
    background-size: cover;
    background-attachment: fixed; 
    background-position: center; 
}
  </style>
  