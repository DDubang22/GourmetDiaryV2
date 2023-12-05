<template>
   <div class="main">
        <div class="main_page">
            <div class="main_pageItem">
                <h1>미식 일기</h1>
              <form @submit.prevent="submitForm">
                
                <div class="mb-3 row">
                    <label for="inputId" class="col-sm-2 col-form-label">아이디</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputId" v-model="formData.loginId">

                         <!-- 입력 값이 없을 때 메시지 -->
                        <div v-if="isInputEmpty(formData.loginId)" class="text-danger">아이디를 입력하세요.</div>
                        <div v-if="errorMessages.loginId" class="text-danger">{{ errorMessages.loginId }}</div>
                    </div>
                
                </div>

                <div class="mb-3 row">
                    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword" v-model="formData.password">
                        
                         <!-- 입력 값이 없을 때 메시지 -->
                    <div v-if="isInputEmpty(formData.password)" class="text-danger">비밀번호를 입력하세요.</div>
                    <div v-if="errorMessages.password" class="text-danger">{{ errorMessages.password }}</div>

                        <div class="d-grid gap-2">
                            <button class="btn btn-secondary gray" type="submit">로그인</button>
                            <div class="login_func">
                                <div class="main_pageItem_btn">
                                    <button class="btn btn-link" type="button" @click="generalLogin">회원가입</button>
                                    <button class="btn btn-link" type="button" >아이디 찾기{{message}}</button>
                                    <button class="btn btn-link" type="button" >비밀번호 찾기</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
              </form>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios';
import emitter from '../main.js';

export default {
    name: "LoginPage",
    data () {
        return {
            message : "",
            formData : {
                loginId: '',
                password: '',
            },
            errorMessages: {
                loginId: '',
                password: '',
            },
            login: false,
            showTooltip: false,
        };
    },
    mounted() {
        this.checkLoginStatus();
    },
    methods: {
        async checkLoginStatus() {
            await axios.get("/login")
        .then(response => {
            if(response.data === true) {
                this.login = true;
                this.showTooltip = this.login;
                emitter.emit('login-status',this.showTooltip);
                this.$store.commit('setLoggedIn', true);
            }
            console.log(this.showTooltip);
            
        })
        .catch(error => {
            console.log(error);
        });
        },

        submitForm() {
            this.errorMessages = {
                loginId : '',
                password: '',
            };

            if (this.isAnyInputEmpty()) {
            alert('모든 항목을 입력하세요.');
            return;
        }

        this.sendDataToSerever(this.formData);

        },

        generalLogin() {
            this.$router.push('/login/generallogin');
        },
        
        

    async sendDataToSerever(data) {
        try {
            const response = await axios.post('http://localhost:8080/login',data);
            console.log("response from server", response.data);
            this.$router.push("/map");
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
.main_page {
    width:85vw;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.main_pageItem {
    width: 500px;
}

.main_pageItem h1{
    margin-bottom: 1em;
    margin-left: 2em;
}

.login_pageItem_object label{
    width: 110px;
}

.gray {
    margin-top : 2em;
}

.login_func {
    display: flex;
    flex-direction: row;

}




</style>