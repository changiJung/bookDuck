package Chan.BookShelvesMaven.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 600864718L;

    public static final QBook book = new QBook("book");

    public final StringPath author = createString("author");

    public final NumberPath<Long> bookShelevesId = createNumber("bookShelevesId", Long.class);

    public final NumberPath<Long> curPage = createNumber("curPage", Long.class);

    public final StringPath image = createString("image");

    public final StringPath isbn = createString("isbn");

    public final StringPath publisher = createString("publisher");

    public final StringPath title = createString("title");

    public final NumberPath<Long> totPage = createNumber("totPage", Long.class);

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}

