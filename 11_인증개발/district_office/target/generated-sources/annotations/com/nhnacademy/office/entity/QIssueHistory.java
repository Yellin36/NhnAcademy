package com.nhnacademy.office.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIssueHistory is a Querydsl query type for IssueHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIssueHistory extends EntityPathBase<IssueHistory> {

    private static final long serialVersionUID = -1017656803L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIssueHistory issueHistory = new QIssueHistory("issueHistory");

    public final StringPath certificateTypeCode = createString("certificateTypeCode");

    public final QIssueHistory_Pk pk;

    public final QResident resident;

    public QIssueHistory(String variable) {
        this(IssueHistory.class, forVariable(variable), INITS);
    }

    public QIssueHistory(Path<? extends IssueHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIssueHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIssueHistory(PathMetadata metadata, PathInits inits) {
        this(IssueHistory.class, metadata, inits);
    }

    public QIssueHistory(Class<? extends IssueHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pk = inits.isInitialized("pk") ? new QIssueHistory_Pk(forProperty("pk")) : null;
        this.resident = inits.isInitialized("resident") ? new QResident(forProperty("resident")) : null;
    }

}

