package com.nhnacademy.office.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHousehold is a Querydsl query type for Household
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHousehold extends EntityPathBase<Household> {

    private static final long serialVersionUID = -1171697027L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHousehold household = new QHousehold("household");

    public final StringPath currentHouseMovementAddress = createString("currentHouseMovementAddress");

    public final DatePath<java.time.LocalDate> householdCompositionDate = createDate("householdCompositionDate", java.time.LocalDate.class);

    public final StringPath householdCompositionReasonCode = createString("householdCompositionReasonCode");

    public final QResident householdResident;

    public final NumberPath<Long> householdSerialNumber = createNumber("householdSerialNumber", Long.class);

    public QHousehold(String variable) {
        this(Household.class, forVariable(variable), INITS);
    }

    public QHousehold(Path<? extends Household> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHousehold(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHousehold(PathMetadata metadata, PathInits inits) {
        this(Household.class, metadata, inits);
    }

    public QHousehold(Class<? extends Household> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.householdResident = inits.isInitialized("householdResident") ? new QResident(forProperty("householdResident")) : null;
    }

}

