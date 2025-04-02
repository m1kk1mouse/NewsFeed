package faang.school.postservice.mapper;

import faang.school.postservice.dto.post.CreatePostDto;
import faang.school.postservice.dto.post.ResponsePostDto;
import faang.school.postservice.model.Hashtag;
import faang.school.postservice.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    @Mapping(target = "hashtags", expression = "java(toHashtags(post.getHashtags()))")
    ResponsePostDto toDto(Post post);

    @Mapping(target = "hashtags", ignore = true)
    Post toEntity(CreatePostDto createPostDto);

    @Named("toHashtags")
    default Set<String> toHashtags(Set<Hashtag> hashtags) {
        return hashtags.stream().map(Hashtag::getTag).collect(Collectors.toSet());
    }
}
