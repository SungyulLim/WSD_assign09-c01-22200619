package com.webservice.dto;

import com.webservice.entity.Member;

public record MemberResponse(
        Long id, String name, String studentId, String department,
        Integer grade, String email, String role
) {
    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getId(), member.getName(), member.getStudentId(),
                member.getDepartment(), member.getGrade(), member.getEmail(), member.getRole());
    }
}
