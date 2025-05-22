package com.app.mysql.domain.dto;

import com.app.mysql.domain.enumeration.MemberType;
import com.app.mysql.domain.vo.MemberVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private MemberType memberType;
    private String createdDate;
    private String updatedDate;

    public MemberVO toVO(){
        return MemberVO.builder()
                .id(id)
                .memberEmail(memberEmail)
                .memberPassword(memberPassword)
                .memberName(memberName)
                .memberType(memberType)
                .createdDate(createdDate)
                .updatedData(updatedDate)
                .build();
    }
}
