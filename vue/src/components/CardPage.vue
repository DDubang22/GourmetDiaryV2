<template>
  <div class="main">
  <section id="cardType" class="main_page nexon section">
    <h2>맛집 카드페이지 </h2>
    <p>
      맛집 카드페이지
    </p>
    <div class="card_inner container">
      <article
        class="card"
        v-for="(item, index) in CardPageItems"
        :key="index"
        :class="{ 'is-expanded': item.expanded }"
>
        <figure>
          <img :src="item.imgSrc" :alt="item.altText" />
        </figure>
        <div class="card__body">
          <h3 class="tit">{{ item.title }}</h3>
          <p class="desc" v-html="item.description"></p>
          <button @click="toggleCard(index)" class="btn">대표메뉴</button>
        </div>
        <div class="card__detail" v-show="item.expanded">
          <!-- 대표 메뉴의 상세 정보를 여기에 넣습니다. -->
          <div v-for="menu in item.menuItems" :key="menu.name" class="menu-item">
            <img :src="menu.imgSrc" :alt="menu.name" class="menu-img" />
            <p class="menu-name">{{ menu.name }}</p>
        </div>
        </div>
      </article>
    </div>
  </section>
  </div>
</template>

<script>
export default {
  name: "CardPage",
  data() {
    return {
      CardPageItems: [
        {
          imgSrc: require("@/assets/가게1.jpg"),
          altText: "파우더룸 인테리어",
          title: "한마음식당",
          description:
            "주소: 대전광역시 중구 중촌동 20-14 <br> 영업시간: 오후 10:00 ⋅ 금 오전 11:30 <br> 연락처: 042-483-5900"
,
          expanded: false,
          menuItems: [
          {
            name: '맛있는메뉴',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '청경채 숙주나물 소고기 양고기 돼지고기 소세지 송이버섯 푸주 건두부 기타등등'
          },
          {
            name: '메뉴 2',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '메뉴 2에 대한 상세 설명입니다.'
          },
          {
            name: '메뉴 2',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '메뉴 2에 대한 상세 설명입니다.'
          },
          {
            name: '메뉴 2',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '메뉴 2에 대한 상세 설명입니다.'
          },
          {
            name: '메뉴 2',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '메뉴 2에 대한 상세 설명입니다.'
          },
          {
            name: '메뉴 2',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '메뉴 2에 대한 상세 설명입니다.'
          },
        ]
          
        },
        {
          imgSrc: require("@/assets/가게2.jpg"),
          altText: "두마음식당",
          title: "두마음식당",
          description:
            "주소: 대전광역시 서구 괴정동 426-3 <br>영업시간: 내마음대로 <br>연락처: 042-828-2828",
            expanded: false,
            menuItems: [
          {
            name: '맛있는메뉴',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '청경채 숙주나물 소고기 양고기 돼지고기 소세지 송이버섯 푸주 건두부 기타등등'
          },
          {
            name: '메뉴 2',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '메뉴 2에 대한 상세 설명입니다.'
          },
        ]
        },
        {
          imgSrc: require("@/assets/가게3.jpg"),
          altText: "집에가고식당",
          title: "세마음식당",
          description:
            "주소: 대전광역시 중구 대흥동 224 <br> 영업시간: 금요일: 9~10 한시간 <br> 연락처: 040-223-8922",
            expanded: false,
            menuItems: [
          {
            name: '맛있는메뉴',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '청경채 숙주나물 소고기 양고기 돼지고기 소세지 송이버섯 푸주 건두부 기타등등'
          },

        ]
        },
        {
          imgSrc: require("@/assets/가게4.jpg"),
          altText: "주인의 주점",
          title: "주인의 주점",
          description:
            "주소: 대전광역시 중구 대흥동 12 <br> 영업시간: 영업안함 <br> 연락처: 040-123-2221",
            expanded: false,
            menuItems: [
          {
            name: '맛있는메뉴 ',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '청경채 숙주나물 소고기 양고기 돼지고기 소세지 송이버섯 푸주 건두부 기타등등'
          },
          {
            name: '메뉴 2',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '메뉴 2에 대한 상세 설명입니다.'
          },
        ]
        },
        {
          imgSrc: require("@/assets/가게5.jpg"),
          altText: "빨리끝내고식당",
          title: "브라운관 카페",
          description:
            "주소: 대전광역시 중구 흔들동 224 <br> 영업시간: 수빈이맘대로 <br> 연락처: 040-112-1119",
            expanded: false,
            menuItems: [
          {
            name: '맛있는메뉴 ',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '청경채 숙주나물 소고기 양고기 돼지고기 소세지 송이버섯 푸주 건두부 기타등등'
          },
          {
            name: '메뉴 2',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '메뉴 2에 대한 상세 설명입니다.'
          },
        ]
        },
        {
          imgSrc: require("@/assets/가게6.jpg"),
          altText: "빨리끝내고식당",
          title: "대승식당",
          description:
          "주소: 대전광역시 중구 둔동동 224 <br> 영업시간: 문안열어요 <br> 연락처: 040-152-1219",
            expanded: false,
            menuItems: [
          {
            name: '맛있는메뉴 ',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '청경채 숙주나물 소고기 양고기 돼지고기 소세지 송이버섯 푸주 건두부 기타등등'
          },
          {
            name: '메뉴 2',
            imgSrc: require("@/assets/1.png"), // 실제 이미지 경로
            detail: '메뉴 2에 대한 상세 설명입니다.'
          },
        ]
        },
      ],
    };
  },
  methods: {
    toggleCard(index) {
      // 클릭된 카드를 토글합니다.
      this.CardPageItems[index].expanded = !this.CardPageItems[index].expanded;

      // 다른 카드들은 닫습니다.
      this.CardPageItems.forEach((item, idx) => {
        if (idx !== index) {
          item.expanded = false;
        }
    });
  },
},
};
</script>

<style scoped>
/* Add your CSS styles here */
/* fonts */
/* fonts */
@import url('https://webfontworld.github.io/NexonLv1Gothic/NexonLv1Gothic.css');
.main_page {
  width: 85vw;
  height: 100vh;
  background-color: rgb(255, 190, 86); /* Light green background */
  padding: 40px;
  box-sizing: border-box;
  font-family: "Arial", sans-serif; /* Adjust as needed */
  display: flex;
  flex-direction: column;
  align-items: center;
}
.nexon {
    font-family: "NexonLv1Gothic";
    font-weight: 400;
    overflow : auto;
}

/* reset */
* {
    padding: 0;
    margin: 0;
}
a {
    text-decoration: none;
    color: #000;
}
img {
  width: 100%; 
  height: 200px; 
  object-fit: cover;
}

/* common */
.main {
    position: absolute;
    bottom: 0;
    right : 0;

}
.container {
    width: 1160px;
    padding: 0 20px;
    /* margin-top: 1em; */
    min-width: 1160px;
    
}
.section {
    width: 85vw;
    /* padding: 120px 0; */
    height: 100vh;
    justify-content: center;
    align-items: center;
}
.section > h2 {
    font-size: 50px;
    line-height: 1; /*line height auto는 1을 의미*/
    text-align: center;
    margin-bottom: 20px;
}
.section > p {
    font-size: 22px;
    font-weight: 300;
    color: #666;
    text-align: center;
    margin-bottom: 70px;
}
h1, h2, h3, h4, h5 ,h6 {
    font-weight: normal;
}

/* cardType */
.card_inner {
    display: flex;
    flex-wrap:wrap;
    justify-content: space-between
}
.card {
  transition: all 0.3s ease; /* 부드러운 전환 효과 */
    width: 32%;
    background-color: #f5f5f5;
    transition: all 0.3s ease; /* 부드러운 전환 효과 */
  overflow: hidden; /* 내용이 넘칠 때 숨김 처리 */
  margin-bottom: 20px; /* 카드 사이의 간격 */
  cursor: pointer; /* 마우스 오버 시 손가락 모양으로 변경 */
}

.card:hover {
  transform: scale(1.03); /* 마우스 오버 시 카드가 약간 커지는 효과 */
}

.menu-item {
  border-top: 1px solid #eaeaea; /* 메뉴 아이템 상단에 경계선 추가 */
  padding: 15px 0; /* 상단과 하단에 패딩을 줍니다. */
  display: flex; /* 메뉴 아이템을 가로로 정렬하기 위해 flexbox 사용 */
  align-items: center; /* 세로 중앙 정렬 */
}

.menu-img {
  width: 100px; /* 이미지 너비를 100px로 설정 */
  height: 100px; /* 이미지 높이를 100px로 설정 */
  object-fit: cover; /* 이미지가 컨테이너를 채우도록 하되, 비율을 유지하면서 잘라냄 */
  border-radius: 50%; /* 원형 이미지로 만들고 싶다면 이 속성을 추가 */
  margin-right: 10px; /* 이미지와 이름 사이에 간격을 추가 */
}

.menu-name {
  font-size: 16px; /* 이름의 폰트 크기 설정 */
  color: #333; /* 이름의 색상 설정 */
  text-align: center; /* 이름을 중앙 정렬 */
}

/* 확장되었을 때의 카드 스타일 */
.is-expanded {
  /* 확장된 카드에 대한 스타일은 자동 높이로 설정하여 내용에 맞게 조정 */
  height: auto;
  background-color: rgb(255, 238, 231); /* 확장된 카드의 배경색 변경 */
}


.card__detail {
  overflow: hidden; /* 기본적으로 숨김 처리 */
  max-height: 0; /* 시작 높이는 0 */
  opacity: 0; /* 투명도 0으로 설정 */
  visibility: hidden;
  border-radius: 50%; /* 원형으로 시작 */
  transform: scale(0); /* 축소 상태로 시작 */
  transition: max-height 0.3s ease, opacity 0.3s ease, visibility 0s 0s, transform 0.3s ease, border-radius 0.3s ease; /* 부드러운 전환 효과 */
  padding: 20px; /* 상세 내용의 패딩 */
  background-color: #ffffff; /* 상세 내용의 배경색 */
  border-top: 1px solid #a8a8a8; /* 상단에 구분선 추가 */
}

/* 확장된 카드에서 상세 내용 표시 */
.card.is-expanded .card__detail {
  visibility: visible; /* 보이게 설정 */
  max-height:5000px; /* 최대 높이 설정 */
  opacity: 1; /* 불투명하게 설정 */
  transform: scale(1); /* 실제 크기로 확장 */
  border-radius: 0; /* 모서리 둥글기 없앰 */
  transition-delay: 0s; /* 애니메이션 지연 없음 */
}

/* 비확장 상태에서는 상세 내용 영역의 최대 높이를 0으로 설정 */
.card:not(.is-expanded) .card__detail {
  max-height: 0;
  opacity: 0; /* 축소 상태에서 투명도를 다시 0으로 설정 */
  overflow: hidden; /* 내용이 잘리는 것을 방지 */
}

/* "더 자세히 보기" 버튼 스타일 */
.btn {
  padding: 10px 20px; /* 버튼 패딩 */
  background-color: #f9f9f9; /* 버튼 배경색 */
  border: none; /* 테두리 없음 */
  border-radius: 4px; /* 버튼 모서리 둥글게 */
  transition: background-color 0.2s; /* 배경색 변경에 애니메이션 효과 */
}

.btn:hover {
  background-color: #e2e2e2; /* 버튼 호버 시 색상 변경 */
}

.card__body {
    padding: 24px;
    
}
.card__body .tit {
  font-size: 24px;
    margin-bottom: 10px;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    color: #000;
    font-weight: bold; /* 굵게 설정 */
    font-style: normal; /* 기울임 없애기 */
}
.card__body .desc {
    font-size: 18px;
    line-height: 1.4;
    color: #666;
    margin-bottom: 20px;
    font-weight: 300;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 4;  /*설명이 3줄이상 되면 ...으로 처리함*/
    -webkit-box-orient: vertical;
}
.card__body .btn {
  
}
.card__footer .span { /*사진*/
    width: 40px;
    height: 40px;
    background: #000;
    border-radius: 50%;
    overflow: hidden;
    display: block;
    margin-left: 10px;
    margin-top: -3px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.25);
}
</style>