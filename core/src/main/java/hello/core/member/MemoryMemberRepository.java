package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // Id 와 회원 정보를 Hashmap 에 저장

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); // key(Id) 조회 후 value(member) 리턴
    }
}
