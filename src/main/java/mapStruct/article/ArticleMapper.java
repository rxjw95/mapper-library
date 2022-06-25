package mapStruct.article;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    @Mapping(source = "title", target = "subject")
    ArticleDto toDto(Article article);



    default Article toEntity(ArticleDto articleDto) {
        if ( articleDto == null ) {
            return null;
        }

        Category category = null;

        int id = articleDto.id();
        String title = articleDto.subject();
        if ( articleDto.category() != null ) {
            category = Enum.valueOf( Category.class, articleDto.category() );
        }
        String author = articleDto.author();
        String contents = articleDto.contents();
        int commentCount = articleDto.comments().size();
        String createdDate = null;

        return new Article( id, title, category, author, contents, commentCount, createdDate );
    }
}
