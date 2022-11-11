package com.example.backend.service;

import com.example.backend.model.Vote;
import com.example.backend.repository.VoteRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ResultServiceTest {

    private final VoteRepo repo = mock(VoteRepo.class);
    private final ResultService service = new ResultService(repo);


    @Test
    void allVotesForQuestion() {
        //Given
        Vote dummyVote = new Vote("1", "Player1", "q1", "Player2");
        Vote dummyVote2 = new Vote("2", "Player2", "q1", "Player1");
        Vote dummyVote3 = new Vote("3", "Player3", "q2", "Player2");
        repo.save(dummyVote);
        repo.save(dummyVote2);
        repo.save(dummyVote3);
        when(repo.findVotesByQuestionId(any())).thenReturn(List.of(dummyVote, dummyVote2));

        //When
        List<Vote> actual = service.allVotesForQuestion("q1");

        //Then
        List<Vote> expected = List.of(dummyVote, dummyVote2);
        assertEquals(expected, actual);

    }

    @Test
    void deleteVotesForQuestion() {
        //Given
        Vote dummyVote = new Vote("1", "Player1", "q1", "Player2");
        Vote dummyVote2 = new Vote("2", "Player2", "q1", "Player1");
        Vote dummyVote3 = new Vote("3", "Player3", "q1", "Player2");
        repo.save(dummyVote);
        repo.save(dummyVote2);
        repo.save(dummyVote3);
        when(repo.deleteVotesByQuestionId(any())).thenReturn(List.of(new Vote(), new Vote(), new Vote()));

        //When
        List<Vote> actual = service.deleteVotesForQuestion("q1");

        //Then

        List<Vote> expected = List.of(new Vote(), new Vote(), new Vote());
        assertEquals(expected, actual);
    }
}