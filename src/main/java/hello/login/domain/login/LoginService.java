package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * @return 로그인 실패 -> null
     */
    public Member save(String loginId, String password) {
        /*Optional<Member> optionalMember = memberRepository.findByLoginId(loginId);
        Member member = optionalMember.get();
        if (member.getPassword().equals(password)) {
            return member;
        } else {
            return null;
        }*/
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
