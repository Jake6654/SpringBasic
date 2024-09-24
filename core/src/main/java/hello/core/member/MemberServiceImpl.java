package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 리포짓토리는 공개 x 변경 불가능하여 하니 private final 로 설정
    // 다형성을 활용하여 MemberRepository 를 구현한 자식 클래스 객체 사용


    @Override
    public void join(Member member) { // 만들어진 자식 클래스를 통해 MemoryMemberRepository 의 기능을 그대로 갖다 쓰고 있다.
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
       return memberRepository.findById(memberId);
    }
}
