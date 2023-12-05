package woosong.gourmetdiary.web.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import woosong.gourmetdiary.SessionConst;
import woosong.gourmetdiary.domain.login.Login;
import woosong.gourmetdiary.domain.login.LoginService;
import woosong.gourmetdiary.domain.member.Member;
import woosong.gourmetdiary.domain.member.MemberService;

import java.util.List;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class LoginController implements ErrorController {

    private final MemberService memberRepository;
    private final MessageSource messageSource;
    private final LoginService loginService;

    @Autowired
    private HttpSession session;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody Login login, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : allErrors) {
                String message = messageSource.getMessage(error, Locale.getDefault());
                errorMsg.append(message).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMsg.toString());
        }

        Member loginMember = loginService.login(login.getLoginId(), login.getPassword());

        if (loginMember == null) {
            return ResponseEntity.badRequest().body("아이디와 비밀번호가 맞지 않습니다. 다시 입력해주세요");
        }

        //로그인 성공 처리
        //세션에 있으면 있는 세션 반환, 없으면 신규 세션 반환
        session = request.getSession();

        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER,loginMember);

        return ResponseEntity.ok(true);
    }

//    @GetMapping("/login")
//    public ResponseEntity<Object> loginStatus() {
//        boolean isLoggedIn = session.getAttribute(SessionConst.LOGIN_MEMBER) != null;
//        return ResponseEntity.ok(isLoggedIn);
//    }

    @GetMapping("/login")
    public String redirectRoot() {
        return "index.html";
    }




}
