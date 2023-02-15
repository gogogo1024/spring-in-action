package com.example.taco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Column;

@Data
@Table("tacos")
public class Taco {

    // 定义 partition key
    // cassandra表中的任何行都可能由一个或多个分区管理，对每行的分区键执行哈希操作，以确定该行将由哪个分区进行管理。
    @PrimaryKeyColumn(type= PrimaryKeyType.PARTITIONED)
    private UUID id = Uuids.timeBased();

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;


    // 定义 clustering key
    // cassandra表中聚类键确定行在分区内维护的顺序（不一定是它们在查询结果中显示的顺序）
    @PrimaryKeyColumn(type=PrimaryKeyType.CLUSTERED, ordering= Ordering.DESCENDING)
    private Date createdAt = new Date();

    @Size(min=1, message="You must choose at least 1 ingredient")
    @Column("ingredients")
    private List<IngredientUDT> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) { this.ingredients.add(TacoUDRUtils.toIngredientUDT(ingredient));
    }

}