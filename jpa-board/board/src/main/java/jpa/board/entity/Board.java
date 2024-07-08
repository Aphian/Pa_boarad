package jpa.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id")
	private Long id;
	
	private String title;
	private String content;
	
	@CreatedDate
	private LocalDateTime regDate;
	
	@LastModifiedDate
	private LocalDateTime uptDate;
	
	private Long viewCount;
	private String delYn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member2 member;
	
	public Board update(String title, String content) {
		this.title = title;
		this.content = content;
		return this;
	}
	
	public Board delete(String delYn) {
		this.delYn = delYn;
		return this;
	}
	
	@Builder
	public Board(String title, String content, Member2 member) {
		this.title = title;
		this.content = content;
		this.viewCount = 0L;
		this.delYn = "N";
		this.member = member;
	}

}
