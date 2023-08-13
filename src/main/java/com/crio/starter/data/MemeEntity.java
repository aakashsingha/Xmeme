package com.crio.starter.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="memes")
@AllArgsConstructor
@NoArgsConstructor
public class MemeEntity {

    @Transient
    public static final String SEQUENCE_NAME = "memes_sequence";
    
    @Id
    int id;

    @NonNull
    String name;

    @NonNull
    String url;

    @NonNull
    String caption;

    
}
