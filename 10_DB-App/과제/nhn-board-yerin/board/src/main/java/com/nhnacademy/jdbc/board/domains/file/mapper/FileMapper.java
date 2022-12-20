package com.nhnacademy.jdbc.board.domains.file.mapper;

import com.nhnacademy.jdbc.board.domains.file.domain.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileMapper {
    List<File> selectFilesByPostId(@Param("postId") Long postId);

    void insertFile(@Param("postId") long postId, @Param("fileName") String fileName);

    void deleteFile(@Param("fileId") Long fileId);

    void deleteFileByPostId(long postId);
}
