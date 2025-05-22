package com.app.mysql.domain.vo;

import com.app.mysql.domain.enumeration.MemberType;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString(callSuper=true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class MemberVO extends Period{
    @EqualsAndHashCode.Include
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private MemberType memberType;

    @Builder
    public MemberVO(String createdDate, String updatedData, Long id, String memberEmail, String memberPassword, String memberName, MemberType memberType) {
        super(createdDate, updatedData);
        this.id = id;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberType = memberType;
    }
}
