package mapStruct;

import mapStruct.Person.*;
import mapStruct.article.Article;
import mapStruct.article.ArticleDto;
import mapStruct.article.ArticleMapper;
import mapStruct.article.Category;
import modelMapper.person.Info;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void articleToArticleDto_AutoImplement_Success() {
        Article article = new Article(1, "제목", Category.BLOG, "jangwook", "테스트입니다.", 0, "2022-06-25");
        ArticleDto articleDto = ArticleMapper.INSTANCE.toDto(article);

        assertEquals(1, articleDto.id());
        assertEquals("제목", articleDto.subject());
        assertEquals("BLOG", articleDto.category());
        assertEquals("jangwook", articleDto.author());
        assertEquals("테스트입니다.", articleDto.contents());
        assertEquals(null, articleDto.comments());
    }

    @Test
    void articleDtoToArticle_Customized_Success() {
        ArticleDto articleDto = new ArticleDto(1, "제목", "BLOG", "jangwook", "테스트입니다.", List.of("좋은 글 잘 읽었습니다."));
        Article article = ArticleMapper.INSTANCE.toEntity(articleDto);

        assertEquals(1, article.id());
        assertEquals("제목", article.title());
        assertEquals(Category.BLOG, article.category());
        assertEquals("jangwook", article.author());
        assertEquals("테스트입니다.", article.contents());
        assertEquals(1, article.commentCount());
    }

    @Test
    void PersonToPersonDto_Success() {
        Person person = new Person(new Name("jangwook", "ryu"), new Age(26, 28), List.of("tennis", "football"));
        PersonDto personDto = PersonMapper.INSTANCE.toDto(person);

        assertEquals("jangwook", personDto.firstName());
        assertEquals("ryu", personDto.lastName());
        assertEquals(26, personDto.internationalAge());
        assertEquals(28, personDto.domesticAge());
        assertEquals(List.of("tennis", "football"), personDto.jobs());
    }

    @Test
    void AssembleNameAndAge_Info() {
        Name name = new Name("jangwook", "ryu");
        Age age = new Age(26, 28);
        Info assembleInfo = PersonMapper.INSTANCE.assemble(name, age);

        assertEquals("jangwook", assembleInfo.firstName());
        assertEquals("ryu", assembleInfo.lastName());
        assertEquals(26, assembleInfo.internationalAge());
        assertEquals(28, assembleInfo.domesticAge());
    }

}