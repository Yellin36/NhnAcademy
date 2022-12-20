package com.nhnacademy.springboot.department.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "department_members")
public class DepartmentMember {
    @EmbeddedId
    private Pk pk;

    @MapsId("departmentId")
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @MapsId("memberId")
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Getter
    @Setter
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "department_id")
        private String departmentId;
        @Column(name = "member_id")
        private Long memberId;
    }

}

