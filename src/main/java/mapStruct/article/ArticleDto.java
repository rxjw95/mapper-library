package mapStruct.article;

import java.util.List;

public record ArticleDto(
        int id,
        String subject,
        String category,
        String author,
        String contents,
        List<String> comments) { }
