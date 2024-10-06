package net.franzka.myband.post.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ControllerAdvisorTest {

    @InjectMocks
    private ControllerAdvisor controllerAdvisor;

    @Test
    void handlePostNotFoundExceptionTest() {
        // Arrange
        PostNotFoundException ex = new PostNotFoundException();

        // Act
        ResponseEntity<String> result = controllerAdvisor.handlePostNotFoundException(ex);

        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(result.getBody()).isEqualTo("Post not found");
    }


}
