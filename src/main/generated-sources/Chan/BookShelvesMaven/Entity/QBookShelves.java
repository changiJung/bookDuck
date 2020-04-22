package Chan.BookShelvesMaven.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookShelves is a Querydsl query type for BookShelves
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBookShelves extends EntityPathBase<BookShelves> {

    private static final long serialVersionUID = 320676026L;

    public static final QBookShelves bookShelves = new QBookShelves("bookShelves");

    public final StringPath BookId = createString("BookId");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final StringPath opnYn = createString("opnYn");

    public final NumberPath<Long> ShelvesNo = createNumber("ShelvesNo", Long.class);

    public final StringPath userId = createString("userId");

    public QBookShelves(String variable) {
        super(BookShelves.class, forVariable(variable));
    }

    public QBookShelves(Path<? extends BookShelves> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookShelves(PathMetadata metadata) {
        super(BookShelves.class, metadata);
    }

}

