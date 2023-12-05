<template>
    <div class="main">
    <div>
      <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contact</title>
        <link rel="stylesheet" href="./css/main.css">
        <link rel="stylesheet" href="./css/contact.css">
      </head>
      <body>
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
          <div class="four">
            <img class="contact_img" src="./imgs/bg.jpg">
            <a href="https://subtitle1.github.io/" class="ct">Blog</a>
            <a href="mailto:stella.kim.96211@gmail.com" class="ct">Gmail</a>
            <a href="https://github.com/subtitle1" class="ct">Github</a>
          </div>
        </div>
      </body>
    </div>
</div>
  </template>
  
  <script>
  export default {
    name: 'ContactPage',
    // 필요한 데이터와 메서드를 여기에 추가할 수 있습니다.
  };
  </script>
  
  <style>
 @import url('https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap');
 @import './css/main.css';
  @import './css/scroll.css';
  @import './css/contact.css';

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
  