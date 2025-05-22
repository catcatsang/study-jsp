package com.app.mysql.mapper;

import com.app.mysql.domain.dto.MemberDTO;
import com.app.mysql.domain.enumeration.MemberType;
import com.app.mysql.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsert(){
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberEmail("test@gmail.com");
        memberDTO.setMemberPassword("1234");
        memberDTO.setMemberName("테스트");
        memberDTO.setMemberType(MemberType.MEMBER);

        memberMapper.insert(memberDTO.toVO());

    }

    @Test
    public void testSelectAll(){
        List<MemberVO> members = memberMapper.selectAll();
        members.forEach((member) -> {
            log.info("{}, {}, {}", member.getMemberName(), member.getMemberType().name(), member.getMemberType().getCode());
        });
    }
}

















