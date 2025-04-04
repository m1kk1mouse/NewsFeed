package faang.school.postservice.mapper;

import faang.school.postservice.dto.like.LikeDto;
import faang.school.postservice.dto.like.LikeResponseDto;
import faang.school.postservice.model.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LikeMapper {
    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "comment.id", target = "commentId")
    LikeResponseDto toDto(Like like);

    Like toEntity(LikeDto likeDto);
}
