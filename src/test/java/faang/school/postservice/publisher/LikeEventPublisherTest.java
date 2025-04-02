package faang.school.postservice.publisher;

import faang.school.postservice.config.redis.RedisProperties;
import faang.school.postservice.dto.like.LikeEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LikeEventPublisherTest {
    @Mock
    private RedisTemplate<String, Object> redisTemplate;

    @InjectMocks
    private LikeEventPublisher likeEventPublisher;

    RedisProperties redisProperties;

    @Test
    void publishToChannel() {
        redisProperties = new RedisProperties(
                "localhost",
                6379,
                new RedisProperties.Channel(
                        "adsChannel",
                        "calculationsChannel",
                        "likesChannel",
                        "userBansChannel",
                        "commentsChannel"));

        LikeEvent likeEvent = LikeEvent.builder()
                .likeAuthorId(1L)
                .postId(2L)
                .postAuthorId(3L)
                .build();

        likeEventPublisher = new LikeEventPublisher(redisTemplate, redisProperties);

        likeEventPublisher.publish(likeEvent);

        verify(redisTemplate, times(1))
                .convertAndSend(redisProperties.channel().likesChannel(), likeEvent);
    }
}