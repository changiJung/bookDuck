package Chan.BookShelvesMaven.DAO;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccountProfile is a Querydsl query type for AccountProfile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccountProfile extends EntityPathBase<AccountProfile> {

    private static final long serialVersionUID = 1440229854L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccountProfile accountProfile = new QAccountProfile("accountProfile");

    public final QAccount account;

    public final StringPath nickname = createString("nickname");

    public QAccountProfile(String variable) {
        this(AccountProfile.class, forVariable(variable), INITS);
    }

    public QAccountProfile(Path<? extends AccountProfile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccountProfile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccountProfile(PathMetadata metadata, PathInits inits) {
        this(AccountProfile.class, metadata, inits);
    }

    public QAccountProfile(Class<? extends AccountProfile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account"), inits.get("account")) : null;
    }

}

