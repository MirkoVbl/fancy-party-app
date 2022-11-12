package com.example.backend.service;


import com.example.backend.model.Vote;
import com.example.backend.model.VoteDTO;
import com.example.backend.repository.VoteRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class VoteServiceTest {

    private final VoteRepo repo = mock(VoteRepo.class);
    private final IdService idService = mock(IdService.class);
    private final VoteService service = new VoteService(repo, idService);

    @Test
    void createVote() {
        //Given
        VoteDTO dummyVoteDTO = new VoteDTO("1", "q1", "Player1");
        when(idService.generateId()).thenReturn("1");
        when(repo.save(any())).thenReturn(
                Vote.builder()
                        .id("1")
                        .voterId(dummyVoteDTO.getVoterId())
                        .questionId(dummyVoteDTO.getQuestionId())
                        .answerId(dummyVoteDTO.getAnswerId())
                        .build());

        //When
        Vote actual = service.createVote(dummyVoteDTO);

        //Then
        Vote expected = new Vote("1", "1", "q1", "Player1");
        assertEquals(expected, actual);
    }
}