<template>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    </head>
    <div class="side-bar">
        <div class="headline">
            <div class="headline-item">
                <button type="button" @click="onClickRedirect()">diary</button>   
            </div>
        </div>
        <div class="account">
            <div class="account_profile">
                <button type="button" class="account_profile_button" @click="redirectToLogin">
                    <img v-show="!$store.getters.isLoggedIn" src="../assets/person-circle.svg" alt="SVG Button" width="50" height="50">
                    <h2 v-show="$store.getters.isLoggedIn">세션확인</h2>
                </button>
            </div>
        </div>
        <div class="function">
            <div class="function_item">
                <button type="button" class="btn btn-outline-success">
                    <router-link to="/map" style="text-decoration-line: none">지도</router-link> 
                </button>
            </div>
            <div class="function_item">
                <router-link to="/cardpage">
                    <button type="button" class="btn btn-outline-danger">맛집</button>
                </router-link>    
            </div>
            <div class="function_item">
                <button type="button" class="btn btn-outline-warning">방명록</button>
            </div>
        </div>
        <div class="service">
            <router-link to="/index">
                <button>서비스 소개</button>          
            </router-link>
        </div>
    </div>
    
</template>

<script>
import { mapGetters } from 'vuex';
import emitter from '../main.js';

export default {
    data () {
        return {
            showTooltip : false,
        };
    },
    computed: {
    // mapGetters를 사용하여 스토어의 getters를 컴포넌트의 계산된 속성에 매핑
    ...mapGetters(['isLoggedIn']),
     },

    created() {
        emitter.on('login-status', this.handleLoginStatus);
    },
    methods: {
        handleLoginStatus(status) {
            this.showTooltip = status;
        },
        onClickRedirect: function () {
            window.location.href = "/";
        },
        redirectToLogin() {
            this.$router.push('/login'); // '/login' 페이지로 이동
    }
},
}

</script>
<style>
body {
    margin : 0;
    padding: 0;
    overflow: hidden;
}


.side-bar {
    position: relative;
    display:flex;
    flex-direction: column;
    width: 15vw;
    height: 100vh;
    background-color:beige;
}
.headline {
    width:100%;
    height: 15%;
    border-bottom: 1px solid rgba(0,0,0,0.3);
}

.headline-item {
    height: 100%;
    display: flex;
    justify-content : center;
    align-items: center;
   
}

.headline-item button {
    border : none;
    background-color: transparent;
    color:teal;
    font-size: 40px;
    font-weight: 600;
}

.account {
    width:100%;
    height: 30%;
    border-bottom: 1px solid rgba(0,0,0,0.3);
}

.account_profile_button {
    background: transparent;
    border:none;
}

.account_profile_button img {
    margin-top: 20px;
    width: 80px;
    height: 80px;
}

.function {
    display: flex;
    width : 100%;
    height: 40%;
    flex-direction: column;
}

.function_item {
    width:100%;
    display: flex;
    justify-content: center;
    padding: 20px 0px;
    
}

.service {
    width:100%;
    position: absolute;
    bottom : 0;
    margin-bottom: 20px;
}
.service button {      
    padding: 10px 20px;
    font-size: 1em;
    border: none;
    border-radius: 8px;
    background: teal;

}
</style>