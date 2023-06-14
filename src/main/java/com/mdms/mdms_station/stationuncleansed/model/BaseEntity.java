package com.mdms.mdms_station.stationuncleansed.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.TypeDef;

//@TypeDefs({
//    @TypeDef(
//        name = "string-array",
//        typeClass = StringArrayType.class
//    ),
//    @TypeDef(
//        name = "int-array",
//        typeClass = IntArrayType.class
//    )
//})
@MappedSuperclass
public class BaseEntity {
 
    @Id
    private Long id;
 
    @Version
    private Integer version;
 
    //Getters and setters omitted for brevity
}