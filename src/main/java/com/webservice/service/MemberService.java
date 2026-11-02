package com.webservice.service;

import com.webservice.dto.MemberRequest;
import com.webservice.dto.MemberResponse;
import com.webservice.entity.Member;
import com.webservice.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public MemberResponse create(MemberRequest request) {
        Member saved = repository.save(new Member(request));
        return MemberResponse.from(saved);
    }

    public List<MemberResponse> findAll() {
        return repository.findAll().stream().map(MemberResponse::from).toList();
    }

    public MemberResponse findById(Long id) {
        return MemberResponse.from(findEntity(id));
    }

    public MemberResponse update(Long id, MemberRequest request) {
        Member member = findEntity(id);
        member.update(request);
        return MemberResponse.from(repository.save(member));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found: " + id);
        }
        repository.deleteById(id);
    }

    private Member findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Member not found: " + id));
    }
}
