package faang.school.postservice.mapper;

import faang.school.postservice.dto.post.CreatePostDto;
import faang.school.postservice.dto.post.ResponsePostDto;
import faang.school.postservice.model.Post;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-01T22:13:51+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.14 (Ubuntu)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public ResponsePostDto toDto(Post post) {
        if ( post == null ) {
            return null;
        }

        ResponsePostDto responsePostDto = new ResponsePostDto();

        responsePostDto.setId( post.getId() );
        responsePostDto.setContent( post.getContent() );
        responsePostDto.setAuthorId( post.getAuthorId() );
        responsePostDto.setProjectId( post.getProjectId() );
        responsePostDto.setPublished( post.isPublished() );
        responsePostDto.setPublishedAt( post.getPublishedAt() );
        responsePostDto.setCreatedAt( post.getCreatedAt() );
        responsePostDto.setUpdatedAt( post.getUpdatedAt() );
        responsePostDto.setScheduledAt( post.getScheduledAt() );

        responsePostDto.setHashtags( toHashtags(post.getHashtags()) );

        return responsePostDto;
    }

    @Override
    public Post toEntity(CreatePostDto createPostDto) {
        if ( createPostDto == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        post.content( createPostDto.getContent() );
        post.authorId( createPostDto.getAuthorId() );
        post.projectId( createPostDto.getProjectId() );
        post.scheduledAt( createPostDto.getScheduledAt() );

        return post.build();
    }
}
