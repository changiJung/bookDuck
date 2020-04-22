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

    public final NumberPath<Integer> book_no = createNumber("book_no", Integer.class);

    public final StringPath bookAuthor = createString("bookAuthor");

    public final StringPath bookCount = createString("bookCount");

    public final StringPath bookIsbn = createString("bookIsbn");

    public final StringPath bookNm = createString("bookNm");

    public final StringPath bookPubl = createString("bookPubl");

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

