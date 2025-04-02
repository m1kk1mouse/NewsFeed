package faang.school.postservice.mapper;

import faang.school.postservice.dto.like.LikeDto;
import faang.school.postservice.dto.like.LikeResponseDto;
import faang.school.postservice.model.Comment;
import faang.school.postservice.model.Like;
import faang.school.postservice.model.Post;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-01T22:13:51+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.14 (Ubuntu)"
)
@Component
public class LikeMapperImpl implements LikeMapper {

    @Override
    public LikeResponseDto toDto(Like like) {
        if ( like == null ) {
            return null;
        }

        LikeResponseDto.LikeResponseDtoBuilder likeResponseDto = LikeResponseDto.builder();

        likeResponseDto.postId( likePostId( like ) );
        likeResponseDto.commentId( likeCommentId( like ) );
        likeResponseDto.id( like.getId() );
        if ( like.getUserId() != null ) {
            likeResponseDto.userId( like.getUserId() );
        }
        likeResponseDto.createdAt( like.getCreatedAt() );

        return likeResponseDto.build();
    }

    @Override
    public Like toEntity(LikeDto likeDto) {
        if ( likeDto == null ) {
            return null;
        }

        Like.LikeBuilder like = Like.builder();

        like.userId( likeDto.getUserId() );

        return like.build();
    }

    private long likePostId(Like like) {
        if ( like == null ) {
            return 0L;
        }
        Post post = like.getPost();
        if ( post == null ) {
            return 0L;
        }
        long id = post.getId();
        return id;
    }

    private long likeCommentId(Like like) {
        if ( like == null ) {
            return 0L;
        }
        Comment comment = like.getComment();
        if ( comment == null ) {
            return 0L;
        }
        long id = comment.getId();
        return id;
    }
}
