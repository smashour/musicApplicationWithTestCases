package com.stackroute.unservice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document(collection ="Music")
public class Music {
    @Id //to make id as primary key


    int id;


    String name;

    String comments;



}