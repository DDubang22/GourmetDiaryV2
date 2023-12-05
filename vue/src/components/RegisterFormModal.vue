<template>
  <div>
    <div class="black-bg" v-if="open_modal == true">
        <div class="white-bg">
            <h3>맛집 등록</h3>

            <form @submit.prevent="submitForm">
                <div class="mb-3">
                     <div class="login_pageItem_object">
                        <label for="id" class="form-label">맛집 이름</label>
                        <input type="text" class="form-control" id="id" placeholder="맛집 이름을 등록해주세요" v-model="formData.shopName">
                    </div>
                 </div>
                 
                 <div class="mb-3">
                    <div class="login_pageItem_object">
                        <label for="address" class="form-label">맛집 주소</label>
                        <input type="text" class="form-control" id="address" placeholder="정확한 주소 기입하시기 바랍니다." v-model="formData.shopAddress">
                    </div>
                 </div>

                 <div class="mb-3">
                    <div class="login_pageItem_object">
                        <label for="postalCode" class="form-label">우편 번호</label>
                        <input type="text" class="form-control" id="postalCode" placeholder="정확한 우편번호 기입하시기 바랍니다." v-model="formData.shopPostalCode">
                    </div>
                 </div>

                 <div class="mb-3">
                    <div class="login_pageItem_object">
                        <label for="jibun" class="form-label">지번</label>
                        <input type="text" class="form-control" id="jibun" placeholder="정확한 지번 기입하시기 바랍니다." v-model="formData.shopJibun">
                    </div>
                 </div>

                 <div class="mb-3">
                    <div class="login_pageItem_object">
                        <label for="website" class="form-label">웹사이트 주소</label>
                        <input type="text" class="form-control" id="website" placeholder="정확한 웹사이트 주소 남겨주세요 " v-model="formData.shopWebsiteAddress">   
                    </div>
                 </div>

                 <div class="mb-3">
                    <div class="login_pageItem_object">
                        <label for="image" class="form-label">이미지 주소</label>
                        <input type="text" class="form-control" id="image" placeholder="정확한 이미지 주소 남겨주세요 " v-model="formData.shopImageAddress">   
                    </div>
                 </div>

                 <!-- <div class="mb-3">
                    <div class="login_pageItem_object">
                        <label for="latitude" class="form-label">위도</label>
                        <input type="text" class="form-control" id="latitude" placeholder="정확한 위도 남겨주세요 " v-model="formData.latitude">   
                    </div>
                 </div>

                 <div class="mb-3">
                    <div class="login_pageItem_object">
                        <label for="longitude" class="form-label">경도</label>
                        <input type="text" class="form-control" id="longitude" placeholder="정확한 경도 남겨주세요 " v-model="formData.longitude">   
                    </div>
                 </div> -->
                 
                 <div class="d-grid gap-2">
                        <button class="btn btn-primary" type="submit">맛집 등록하기!!</button>
                        <button class="close_btn" type="button" @click="$emit('closeModal')">취소</button>
                 </div>
            </form>
        </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name : 'TheModal',

    props : {
        open_modal : Boolean,
    },
    data() {
        return {
        formData : {
            shopName: '',
            shopAddress: '',
            shopPostalCode: '',
            shopJibun: '',
            shopWebsiteAddress: '',
            shopImageAddress: '',
            latitude: 0.0,
            longitude: 0.0,
      }
        };
    },
    mounted() {

    },
    methods: {
        submitForm() {
            this.sendDataToSerever(this.formData);
        },
        async sendDataToSerever(data) {
        try {
            const response = await axios.post('http://localhost:8080/map',data);
            console.log("response from server", response.data);
            this.$router.push('/');
        } catch (error) {
            console.error('Error seding data to server', error);
        }
     }
    },
}
</script>

<style>
.black-bg {
  width: 50%; height: 55%;
  background: rgba(0, 0, 0, 0.5);
  background-color: white;
  padding: 20px;
  border-radius: 20px;
  position: absolute;
  z-index: 3;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.white-bg {
  width:100%; background: beige;
  border-radius: 8px;
  padding: 20px;
}

.close_btn {
    background: transparent;
    border: none;
}


</style>