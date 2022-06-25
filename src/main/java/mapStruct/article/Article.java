package mapStruct.article;

public record Article(
        int id,
        String title,
        Category category,
        String author,
        String contents,
        int commentCount,
        String createdDate) { }
