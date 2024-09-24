package hello.core.member;

public interface MemberRepository {

    void save(Member member); // 회원 정보 저장

    Member findById(Long memberId); // Id 로 회원정보 찾고 리턴


}
