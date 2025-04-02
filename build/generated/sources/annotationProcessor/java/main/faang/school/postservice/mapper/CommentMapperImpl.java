package faang.school.postservice.mapper;

import faang.school.postservice.dto.comment.CommentResponseDto;
import faang.school.postservice.dto.comment.CreateCommentDto;
import faang.school.postservice.model.Comment;
import faang.school.postservice.model.Post;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-01T22:13:51+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.14 (Ubuntu)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment toEntity(CreateCommentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Comment.CommentBuilder comment = Comment.builder();

        comment.content( dto.getContent() );
        if ( dto.getAuthorId() != null ) {
            comment.authorId( dto.getAuthorId() );
        }

        return comment.build();
    }

    @Override
    public CommentResponseDto toDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResponseDto.CommentResponseDtoBuilder commentResponseDto = CommentResponseDto.builder();

        commentResponseDto.likeIds( mapToLikeIds( comment.getLikes() ) );
        commentResponseDto.postId( commentPostId( comment ) );
        commentResponseDto.id( comment.getId() );
        commentResponseDto.content( comment.getContent() );
        commentResponseDto.authorId( comment.getAuthorId() );
        commentResponseDto.createdAt( comment.getCreatedAt() );
        commentResponseDto.updatedAt( comment.getUpdatedAt() );

        return commentResponseDto.build();
    }

    @Override
    public List<CommentResponseDto> toListDto(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentResponseDto> list = new ArrayList<CommentResponseDto>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( toDto( comment ) );
        }

        return list;
    }

    private Long commentPostId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Post post = comment.getPost();
        if ( post == null ) {
            return null;
        }
        long id = post.getId();
        return id;
    }
}
