package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    @Autowired // 자동으로 의존관계 주입을 해준다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) { // 만들어진 자식 클래스를 통해 MemoryMemberRepository 의 기능을 그대로 갖다 쓰고 있다.
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
       return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
