package Chan.BookShelvesMaven.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserRoles is a Querydsl query type for UserRoles
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserRoles extends EntityPathBase<UserRoles> {

    private static final long serialVersionUID = -827563027L;

    public static final QUserRoles userRoles = new QUserRoles("userRoles");

    public final StringPath userRole = createString("userRole");

    public QUserRoles(String variable) {
        super(UserRoles.class, forVariable(variable));
    }

    public QUserRoles(Path<? extends UserRoles> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserRoles(PathMetadata metadata) {
        super(UserRoles.class, metadata);
    }

}

