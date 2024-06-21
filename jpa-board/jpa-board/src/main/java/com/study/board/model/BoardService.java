package com.study.board.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.board.dto.BoardRequestDto;
import com.study.board.dto.BoardResponseDto;
import com.study.board.entity.Board;
import com.study.board.entity.BoardRespository;
import com.study.exception.CustomException;
import com.study.exception.ErrorCode;
import com.study.paging.CommonParams;
import com.study.paging.Pagination;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRespository boardRespository;
	
	private final BoardMapper boardMapper;
	
	// �Խñ� ����
	@Transactional
	public Long save(final BoardRequestDto params) {
		
		Board entity = boardRespository.save(params.toEntity());
		return entity.getId();
		
	}
	
	// �Խñ� ��ȸ
	public List<BoardResponseDto> findAll() {
		
		Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
		List<Board> list = boardRespository.findAll(sort);
		return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
		
	}
	
	// �Խñ� ����
	@Transactional
	public Long update(final Long id, final BoardRequestDto params) {
		
		Board entity = boardRespository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContent(), params.getWriter());
        return id;
		
	}
	
	// �Խñ� ����
	@Transactional
	public Long delete(final Long id) {
		
		Board entity = boardRespository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
		entity.delete();
		return id;
		
	}
	
	// �Խñ� ���� ����
	public List<BoardResponseDto> findAllByDeleteYn(final char deleteYn) {
		
		Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
		List<Board> list = boardRespository.findAllByDeleteYn(deleteYn, sort);
		return list.stream().map(BoardResponseDto :: new).collect(Collectors.toList());
		
	}
	
	// �Խñ� ������
	@Transactional
	public BoardResponseDto findById(final Long id) {
		
		Board entity = boardRespository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
		entity.increaseHits();
		return new BoardResponseDto(entity);
		
	}
	
	// �Խñ� ����Ʈ ��ȸ (pagination)
	public Map<String, Object> findAll(CommonParams params) {
		
		// �Խñ� �� ��ȸ
		int count = boardMapper.count(params);
		
		// �Խñ��� ���� ��� ����
		if (count < 1) {
			return Collections.emptyMap();
		}
		
		// pagination ����
		Pagination pagination = new Pagination(count, params);
		params.setPagination(pagination);
		
		// �Խñ� ��� ��ȸ
		List<BoardResponseDto> list = boardMapper.findAll(params);
		
		// ������ ��ȯ
		Map<String, Object> response = new HashMap<>();
		response.put("params", params);
		response.put("list", list);
		return response;
		
	}
	

}
