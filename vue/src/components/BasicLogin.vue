<template>
    <div class="main">
         <div class="login_page">
             <div class="login_pageItem">
               <h1>회원 가입</h1>
               <form class="row g-3" @submit.prevent="submitForm">
                 <div class="mb-3">
                     <div class="login_pageItem_object">
                        <label for="id" class="form-label">이메일</label>
                        <input type="email" class="form-control" id="id" placeholder="이메일을 입력해주세요" v-model="formData.loginId">
                        <button type="button" class="btn btn-outline-warning btnlocate">이메일 검사</button>                     
                    </div>
                    <!-- 입력 값이 없을 때 메시지 -->
                    <div v-if="isInputEmpty(formData.loginId)" class="text-danger">이메일을 입력하세요.</div>

                    <div v-if="errorMessages.loginId" class="text-danger">{{ errorMessages.loginId }}</div>
                 </div>
                 
                 <div class="mb-3">
                    <div class="login_pageItem_object">
                        <label for="password" class="form-label">비밀번호</label>
                        <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력해주세요" v-model="formData.password">
                    </div>
                    <!-- 입력 값이 없을 때 메시지 -->
                    <div v-if="isInputEmpty(formData.password)" class="text-danger">비밀번호를 입력하세요.</div>

                    <div v-if="errorMessages.password" class="text-danger">{{ errorMessages.password }}</div>
                 </div>
                 <div class="mb-3">
                    <div class="login_pageItem_object">
                        <label for="password_check" class="form-label">비밀번호 확인</label>
                        <input type="password" class="form-control" id="password_check" placeholder="비밀번호를 다시 입력해주세요" v-model="formData.passwordCheck">   
                    </div>
                    <!-- 입력 값이 없을 때 메시지 -->
                    <div v-if="isInputEmpty(formData.passwordCheck)" class="text-danger">비밀번호를 다시 입력하세요.</div>

                    <div v-if="errorMessages.passwordCheck" class="text-danger">{{ errorMessages.passwordCheck }}</div>
                 </div>
                 <div class="mb-3">
                     <div class="login_pageItem_object">
                        <label for="nickname" class="form-label">닉네임</label>
                        <input type="text" class="form-control" id="nickname"  placeholder="닉네임을 입력해주세요" v-model="formData.name">
                        <button type="button" class="btn btn-outline-warning btnlocate">닉네임 중복</button>
                    </div>
                    <!-- 입력 값이 없을 때 메시지 -->
                    <div v-if="isInputEmpty(formData.name)" class="text-danger">닉네임을 입력하세요.</div>

                    <div v-if="errorMessages.name" class="text-danger">{{ errorMessages.name }}</div>
                 </div>
                 <div class="d-grid gap-2">
                        <button class="btn btn-primary" type="submit">가입은 여기로 눌러주세요!!!</button>
                 </div>
               </form>
             </div>
         </div>
     </div>
 </template>
 <script>
 import axios from 'axios';
 
 export default {
     name: "LoginPage",
     data () {
         return {
             formData : {
                loginId : '',
                password : '',
                passwordCheck : '',
                name : '',
             },
             errorMessages: {
                loginId: '',
                password: '',
                passwordCheck: '',
                name: '',
            },
         };
     },
     mounted() {
        
     },
     methods: {
        submitForm() {

        this.errorMessages = {
            loginId: '',
            password: '',
            passwordCheck: '',
            name: '',
        };

        if (this.isAnyInputEmpty()) {
            alert('모든 항목을 입력하세요.');
            return;
        }

        this.sendDataToServer(this.formData);
    },
    async sendDataToServer(data) {
        try {
            const response = await axios.post('http://localhost:8080/login/generallogin',data);
            console.log("response from server", response.data);
            this.$router.push('/map');
        } catch (error) {
            console.error('Error seding data to server', error);

            if (error.response) {
            // 서버 응답이 400대인 경우
                if (error.response.status >= 400 && error.response.status < 500) {
                    // 여기에 클라이언트에게 알리고자 하는 작업을 추가
                    alert(error.response.data);
                } else {
                    // 다른 상태 코드의 경우 에러 메시지만 설정
                    this.errorMessages = error.response.data;
                }
        }
            
            if(error.response){
                this.errorMessages = error.response.data;
            }
            
        }
     },
     isInputEmpty(value) {
        return !value || value.trim() === '';
     },
     isAnyInputEmpty() {
        // 입력 값이 하나라도 비어있으면 true 반환
        return Object.values(this.formData).some(value => this.isInputEmpty(value));
    }

     },
 }
 </script>
 
 <style>
 .main {
     position: absolute;
     bottom: 0;
     right : 0;
     display: flex;
 
 }
 .login_page {
     width:85vw;
     height: 100vh;
     display: flex;
     justify-content: center;
     align-items: center;
 }
 
 .login_pageItem {
     width: 650px;
     display: flex;
     flex-direction: column;
 }
 
 .login_pageItem h1{
     margin-bottom: 1.5em;
 }

 .login_pageItem_object {
    display: flex;
    width: 39em;
    justify-content: center;
    position: relative;
 }
 
 .login_pageItem_object button {
    width: 9em;
 }


 .form-control {
    margin-right : 15px;
 }
 
 .form-label{
    text-align:left;
    margin-right: 10px;
 }

.btnlocate {
    position:absolute;
    right: 15px;
}
 </style>