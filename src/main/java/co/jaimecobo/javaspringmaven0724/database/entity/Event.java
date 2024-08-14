package co.jaimecobo.javaspringmaven0724.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;
    @Column(name = "organizer_id", nullable = false, insertable = false, updatable = false)
    private Integer organizerId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
    @Column(name = "city_id", nullable = false, insertable = false, updatable = false)
    private Integer cityId;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;


//    @Column(name = "starting_date", nullable = false, columnDefinition = "timestamp default current_timestamp")
//    @Column(name = "starting_date", insertable=false, updatable=false, columnDefinition = "timestamp default current_timestamp")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date startingDate;
    @Column(name = "starting_date", nullable = false)
    private String startingDate;


    //    @Column(name = "ending_date", nullable = false, columnDefinition = "timestamp default current_timestamp")
//    @Column(name = "starting_date", insertable=false, updatable=false, columnDefinition = "timestamp default current_timestamp")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date endingDate;
    @Column(name = "ending_date", nullable = false)
    private String endingDate;


    @Column(name = "event_image_url", nullable = false)
    private String eventImageUrl;

    @Column(name = "event_web_url", nullable = false)
    private String eventWebUrl;

    @Column(name = "created_at", updatable = false,  nullable = false, columnDefinition = "timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

}
