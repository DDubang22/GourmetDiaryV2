<template>
   <div class="main">
        <div class="main_page">
            <div id="map"></div>
            <div class="form">
                <button type="button" @click="open_modal = true" >맛집 집어넣기</button>
            </div>

            <Modal  :open_modal="open_modal" @closeModal="open_modal = false" />

        </div>
    </div>
</template>
<script> 
import Modal from "./RegisterFormModal.vue"
import axios from 'axios';

export default {
    name: "kakaoMap",
    data () {
        return {
            map : null,
            open_modal : false,
            shop : '미세노센세',
            overlay : null,
            marker : null,

            markerInfos : [],
        };
    },
    beforeUpdate() {
    const prevMarkerInfosLength = this.$data._prevMarkerInfosLength || 0;

    // markerInfos 배열의 길이가 변경되었을 때만 맵을 리로드
    if (this.markerInfos.length !== prevMarkerInfosLength) {
      this.$data._prevMarkerInfosLength = this.markerInfos.length;
      this.addMarker();
    }
  },
    mounted() {
      
      if(window.kakao && window.kakao.maps) {
        this.loadMap();
      } else {
        const script = document.createElement("script");
        script.onload = () => {
            window.kakao.maps.load(this.loadMap);
        };
        
        script.src=
            "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=915cffed372954b7b44804ed422b9cf0";
        document.head.appendChild(script);    
      }
      
    },
    methods: {
         async loadMap () {
             
            const container = document.getElementById("map");
            const options = {
                center: new window.kakao.maps.LatLng(36.34610445888127, 127.38851977413381),
                level : 3,
            };
            this.map = new window.kakao.maps.Map(container,options);
            await this.fetchData();
            this.addMarker();
        },
        addMarker() {
        this.markerInfos.push(
        {
            position: new window.kakao.maps.LatLng(36.346040, 127.388857),
            shop: {
                name: '미세노 센세',
                address: '대전 서구 계룡로553번안길 65 웨스턴빌딩 1층',
                postalCode: '35263',
                jibun: '탄방동 757',
                website: 'http://map.naver.com/p/entry/place/13472781?lng=127.388844605869&lat=36.346045287555995&placePath=%2Fhome&entry=plt',
                image: 'https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200103_48%2F1578045531270sJ3xQ_JPEG%2F07tuzBm7aoaPnzE4BoiEG5e_.jpeg.jpg'
            }
        });

        this.markerInfos.push(
        {
            position: new window.kakao.maps.LatLng(36.344040, 127.385857),
            shop: {
                name: '김포시가 한국 사회에 울린 마지막',
                address: '한겨레21',
                postalCode: '12345',
                jibun: '김포시',
                website: 'https://n.news.naver.com/article/036/0000049006?cds=news_media_pc&type=editn',
                image: 'https://imgnews.pstatic.net/image/036/2023/11/16/0000049006_001_20231116173501093.jpg?type=w647'
            }
        });
       
    this.markerInfos.forEach(markerInfo => {
        const marker = new window.kakao.maps.Marker({
            map: this.map,
            position: markerInfo.position,
        });

        const content = `
            <div class="wrap">
                <div class="info">
                    <div class="title">
                        ${markerInfo.shop.name}
                        <div class="close" title="닫기"></div>
                    </div>
                    <div class="body">
                        <div class="img">
                            <img src="${markerInfo.shop.image}" width="73" height="70">
                        </div>
                        <div class="desc">
                            <div class="ellipsis">${markerInfo.shop.address}</div>
                            <div class="jibun ellipsis">${markerInfo.shop.postalCode} (지번) ${markerInfo.shop.jibun}</div>
                            <div><a href="${markerInfo.shop.website}" target="_blank" class="link">홈페이지</a></div>
                        </div>
                    </div>
                </div>
            </div>
        `;

        const overlay = new window.kakao.maps.CustomOverlay({
            content: content,
            map: this.map,
            position: marker.getPosition(),
        });

        window.kakao.maps.event.addListener(marker, 'click', () => {
            if (overlay.getMap()) {
                overlay.setMap(null);
            } else {
                overlay.setMap(this.map);
            }
        });
    });
},
        async fetchData() {
            try { 
            const response = await axios.get('/map');
            const markerInfosFromServer = response.data; // Assuming the response is an array of items
            console.log(markerInfosFromServer);

            const markerInfosArray = Array.isArray(markerInfosFromServer) ? markerInfosFromServer : [markerInfosFromServer];

            
            markerInfosArray.forEach(markerInfo => {
            // markerInfo를 사용하여 원하는 작업 수행
            const newMarkerInfo = {
                position: new window.kakao.maps.LatLng(markerInfo.latitude, markerInfo.longitude),
                shop: {
                    name: markerInfo.shopName,
                    address: markerInfo.shopAddress,
                    postalCode: markerInfo.shopPostalCode,
                    jibun: markerInfo.shopJibun,
                    website: markerInfo.shopWebsiteAddress,
                    image: markerInfo.shopImageAddress
                }
            };

            // this.markerInfos 배열에 새로운 데이터 추가
            this.markerInfos.push(newMarkerInfo);
        });

      

            console.log(this.markerInfos);

        } catch (error) {
            console.error('Error fetching data', error);
        }
    },


    },
    components : {
        Modal,
    }
}
</script>

<style>
body {
    margin : 0;
    padding : 0;
}
.main {
    position: absolute;
    bottom: 0;
    right : 0;

}
.main_page {
    width:85vw;
    height: 100vh;
}

#map {
    width: 100%;
    height:100vh;
}

.form {
    width: 300px;
    height: 50px;
    
    position: absolute;
    z-index: 3;
    top: 0;
    right: 0;
}

.wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
</style>