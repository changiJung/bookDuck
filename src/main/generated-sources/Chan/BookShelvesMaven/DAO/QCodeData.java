package Chan.BookShelvesMaven.DAO;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodeData is a Querydsl query type for CodeData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCodeData extends EntityPathBase<CodeData> {

    private static final long serialVersionUID = 316523481L;

    public static final QCodeData codeData = new QCodeData("codeData");

    public final StringPath code_cd = createString("code_cd");

    public final StringPath code_nm = createString("code_nm");

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public QCodeData(String variable) {
        super(CodeData.class, forVariable(variable));
    }

    public QCodeData(Path<? extends CodeData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeData(PathMetadata metadata) {
        super(CodeData.class, metadata);
    }

}

