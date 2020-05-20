package Chan.BookShelvesMaven.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookComment is a Querydsl query type for BookComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBookComment extends EntityPathBase<BookComment> {

    private static final long serialVersionUID = -786675023L;

    public static final QBookComment bookComment = new QBookComment("bookComment");

    public final StringPath comment = createString("comment");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final StringPath isbn = createString("isbn");

    public final DateTimePath<java.time.LocalDateTime> updateDt = createDateTime("updateDt", java.time.LocalDateTime.class);

    public final StringPath userId = createString("userId");

    public QBookComment(String variable) {
        super(BookComment.class, forVariable(variable));
    }

    public QBookComment(Path<? extends BookComment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookComment(PathMetadata metadata) {
        super(BookComment.class, metadata);
    }

}

