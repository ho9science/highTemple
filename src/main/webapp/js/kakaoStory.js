function kakaoStory(){
var curPage = document.location.href;
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
      Kakao.init('dfea0f72131dd8a9344060453268c5bc');

      // 스토리 공유 버튼을 생성합니다.
      Kakao.Story.createShareButton({
        container: '#kakaostory-share-button',
        url: curPage,
        text: ''
      });


      function getKakaotalkUserProfile(){ 
			Kakao.API.request({ 
				url: '/v1/user/me', 
				success: function(res) { 
					$("#kakao-profile").append(res.properties.nickname); 
					$("#kakao-profile").append($("<img/>",{"src":res.properties.profile_image,"alt":res.properties.nickname+"님의 프로필 사진"})); 
				}, 
				fail: function(error) { 
					console.log(error); 
				} 
			}); 
		} 
		function createKakaotalkLogin(){ 
			$("#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn").remove(); 
			var loginBtn = $("<a/>",{"class":"kakao-login-btn"});
			loginBtn.append($("<img/>",{"src":"img/klogin.png"}));
			loginBtn.click(function(){ 
				Kakao.Auth.login({ 
					persistAccessToken: true, 
					persistRefreshToken: true, 
					success: function(authObj) { 
						getKakaotalkUserProfile(); 
						createKakaotalkLogout(); 
					}, 
					fail: function(err) { 
						console.log(err); 
					} 
				}); 
			}); 
			$("#kakao-logged-group").prepend(loginBtn) 
		} 
		function createKakaotalkLogout(){ 
			$("#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn").remove(); 
			var logoutBtn = $("<a/>",{"class":"kakao-logout-btn","text":"로그아웃"}); 
			logoutBtn.click(function(){ 
				Kakao.Auth.logout(); 
				createKakaotalkLogin(); 
				$("#kakao-profile").text(""); 
			}); 
			$("#kakao-logged-group").prepend(logoutBtn); 
		} 
		if(Kakao.Auth.getRefreshToken()!=undefined&&Kakao.Auth.getRefreshToken().replace(/ /gi,"")!=""){ 
			createKakaotalkLogout(); 
			getKakaotalkUserProfile(); 
		}else{ 
			createKakaotalkLogin(); 
		} 
	 
}