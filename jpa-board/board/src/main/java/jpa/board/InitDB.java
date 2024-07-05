package jpa.board;

import jpa.board.entity.Member2;
import jpa.board.repository.BoardRepository;
import jpa.board.repository.Member2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.util.List;

import static jpa.board.entity.Authority.ROLE_ADMIN;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.userDBInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final Member2Repository memberRepository;
        private final BoardRepository boardRepository;
        public void userDBInit(){

            List<Member2> memberList = memberRepository.findAll();
            if(memberList.size() == 0){
                Member2 member = Member2.builder()
                        .username("관리자")
                        .phoneNo("010-1111-2222")
                        .age(29)
                        .authority(ROLE_ADMIN)
                        .build();
                //member 저장
                memberRepository.save(member);
            }
        }
    }
}