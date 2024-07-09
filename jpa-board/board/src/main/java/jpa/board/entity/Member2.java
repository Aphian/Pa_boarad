package jpa.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import jakarta.persistence.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;            
    private String username;    
    private String password;    
    private String phoneNo;     
    private int age;         

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Authority authority; 

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public Member2(String username, String phoneNo, int age, Authority authority){
        this.username = username;
        this.phoneNo = phoneNo;
        this.age = age;
        this.authority = authority;
    }
}