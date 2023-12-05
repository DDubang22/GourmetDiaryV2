package woosong.gourmetdiary.web.member;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import woosong.gourmetdiary.domain.member.Member;
import woosong.gourmetdiary.domain.member.MemberService;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/login")
@Transactional
@RequiredArgsConstructor
public class MemberController   {

    private final MessageSource messageSource;
    private final MemberService memberService;

    @PostMapping("/generallogin")
    public ResponseEntity<String> postRequest(@Valid @RequestBody Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : errors) {
                String message = messageSource.getMessage(error, Locale.getDefault());
                errorMsg.append(message).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMsg.toString());
        }

        // 입력 유효성 검사 성공한 경우

        if (!(member.getPassword().equals(member.getPasswordCheck()))) {
            return ResponseEntity.badRequest().body("비밀번호가 일치하지 않습니다");
        }

        memberService.save(member);
        String loginId = member.getLoginId();
        String password = member.getPassword();
        return ResponseEntity.ok("member = " + member);
    }

    @GetMapping("/generallogin")
    public String memberRegister() {
        return "index.html";
    }




}



