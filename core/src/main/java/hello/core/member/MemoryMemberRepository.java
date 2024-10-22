package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // memoryMemberRepository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // Id 와 회원 정보를 Hashmap 에 저장

    @Override
    public void save(Member member) { // 멤버 정보를 입려 받아 저장
        store.put(member.getId(),member);

    }

    @Override
    public Member findById(Long memberId) { // 아이디로 멤버 조회
        return store.get(memberId); // key(Id) 조회 후 value(member) 리턴
    }
}
