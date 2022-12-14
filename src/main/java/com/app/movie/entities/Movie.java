package com.app.movie.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document("movie")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private String id;
    private String name;
    private String trailerLink;
    private String imageLink;
    private Date releaseDate;
    private List<Category> categories;
    private String synopsis;
    private List<Staff> staffList;
    private String time;
    private String ageRange;
    private Date registrationDate;
    private List<Score> scores;
    private String status="created";


}
