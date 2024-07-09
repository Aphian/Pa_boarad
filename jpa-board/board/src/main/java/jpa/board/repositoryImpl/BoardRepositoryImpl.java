package jpa.board.repositoryImpl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jpa.board.dto.BoardReponseDto;
import jpa.board.dto.BoardRequestDto;
import jpa.board.dto.QBoardReponseDto;
import jpa.board.repository.CustomBoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import static jpa.board.entity.QBoard.board;
import static jpa.board.entity.QMember2.member2;

@Repository
public class BoardRepositoryImpl implements CustomBoardRepository{
	
	private final JPAQueryFactory jpaQueryFactory;
	
	public BoardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
		this.jpaQueryFactory = jpaQueryFactory;
	}
	
	@Override
	public Page<BoardReponseDto> seleteBoardList(String searchVal, Pageable pageable) {
		
		List<BoardReponseDto> content = getBoardMemberDtos(searchVal, pageable);
		Long count = getCount(searchVal);
		return new PageImpl<>(content, pageable, count);
		
	}
	
    private Long getCount(String searchVal){
        Long count = jpaQueryFactory
                .select(board.count())
                .from(board)
                //.leftJoin(board.member, member)   //검색조건 최적화
                .fetchOne();
        return count;
    }
    
    private List<BoardReponseDto> getBoardMemberDtos(String searchVal, Pageable pageable){
        List<BoardReponseDto> content = jpaQueryFactory
                .select(new QBoardReponseDto(
                         board.id
                        ,board.title
                        ,board.content
                        ,board.regDate
                        ,board.uptDate
                        ,board.viewCount
                        ,member2.username))
                .from(board)
                .leftJoin(board.member, member2)
                .orderBy(board.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return content;
    }
	
	private BooleanExpression containsSearch(String searchVal) {
		
		return searchVal != null ? board.title.contains(searchVal) : null;
		
	}


	
}
