package faang.school.postservice.mapper;

import faang.school.postservice.dto.album.AlbumDto;
import faang.school.postservice.dto.album.AlbumUpdateDto;
import faang.school.postservice.model.Album;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-01T22:13:51+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.14 (Ubuntu)"
)
@Component
public class AlbumMapperImpl implements AlbumMapper {

    @Override
    public AlbumDto toDto(Album album) {
        if ( album == null ) {
            return null;
        }

        AlbumDto.AlbumDtoBuilder albumDto = AlbumDto.builder();

        albumDto.postsId( mapToPostsId( album.getPosts() ) );
        albumDto.id( album.getId() );
        albumDto.title( album.getTitle() );
        albumDto.description( album.getDescription() );
        albumDto.authorId( album.getAuthorId() );

        return albumDto.build();
    }

    @Override
    public Album toEntity(AlbumDto albumDto) {
        if ( albumDto == null ) {
            return null;
        }

        Album.AlbumBuilder album = Album.builder();

        album.id( albumDto.getId() );
        album.title( albumDto.getTitle() );
        album.description( albumDto.getDescription() );
        album.authorId( albumDto.getAuthorId() );

        return album.build();
    }

    @Override
    public void update(AlbumUpdateDto albumUpdateDto, Album album) {
        if ( albumUpdateDto == null ) {
            return;
        }

        album.setId( albumUpdateDto.getId() );
        album.setTitle( albumUpdateDto.getTitle() );
        album.setDescription( albumUpdateDto.getDescription() );
    }
}
