package jpa.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import jpa.board.entity.Board;
import jpa.board.entity.BoardFile;
import jpa.board.entity.File;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class BoardFileDto {

    private Long id;

    private Long boardId;

    public BoardFileDto(){

    }

    @Builder
    public BoardFileDto(Long boardId){
        this.boardId = boardId;
    }

    public BoardFile toEntity(File file){
        return BoardFile.builder()
                .boardId(boardId)
                .file(file)
                .build();
    }
}