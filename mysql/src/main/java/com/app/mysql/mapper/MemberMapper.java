package com.app.mysql.mapper;

import com.app.mysql.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
//    추가하기
    public void insert(MemberVO memberVO);

//    전체 조회
    public List<MemberVO> selectAll();
}
