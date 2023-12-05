package woosong.gourmetdiary.domain.login;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woosong.gourmetdiary.domain.member.Member;
import woosong.gourmetdiary.domain.member.MemberService;

@Service
@RequiredArgsConstructor
public class LoginService {

    public final MemberService memberRepository;

    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }


}
