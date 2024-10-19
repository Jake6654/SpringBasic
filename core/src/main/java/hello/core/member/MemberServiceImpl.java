package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    // 생성자 주입을 통해 이 클래스는 더이상 구체적인 객체에 의존하는 것이 아닌 추상화을 사용한다
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
