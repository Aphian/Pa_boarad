package com.study.board.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.board.dto.BoardResponseDto;
import com.study.paging.CommonParams;

@Mapper
public interface BoardMapper {
	
	int count(final CommonParams params);
	
	List<BoardResponseDto> findAll(final CommonParams parmas);
	

}
