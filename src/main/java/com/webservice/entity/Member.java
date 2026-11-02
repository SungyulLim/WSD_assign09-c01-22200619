package com.webservice.entity;

import com.webservice.dto.MemberRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "members") // 실제 테이블의 이름을 명시
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 20)
    private String studentId;

    @Column(nullable = false, length = 100)
    private String department;

    @Column(nullable = false)
    private Integer grade;

    @Column(nullable = false, length = 200)
    private String email;

    @Column(nullable = false, length = 50)
    private String role;

    protected Member() { } // JPA uses the no-args constructor.

    public Member(MemberRequest request) {
        this.name = request.name();
        this.studentId = request.studentId();
        this.department = request.department();
        this.grade = request.grade();
        this.email = request.email();
        this.role = request.role();
    }

    public void update(MemberRequest request) {
        this.name = request.name();
        this.studentId = request.studentId();
        this.department = request.department();
        this.grade = request.grade();
        this.email = request.email();
        this.role = request.role();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public String getDepartment() { return department; }
    public Integer getGrade() { return grade; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}
