package co.jaimecobo.javaspringmaven0724.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VisitedCity> visitedCities;

    @ToString.Exclude
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Event> events;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "state_province_department_territory", nullable = false)
    private String stateProvinceDepartmentTerritory;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "slogan", unique = true, nullable = false)
    private String slogan;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @Column(name = "city_image_url", unique = true, nullable = false)
    private String cityImageUrl;

    @Column(name = "city_web_url", unique = true, nullable = false)
    private String cityWebUrl;

    @Column(name = "last_editor_user", nullable = false)
    private Integer LastEditorUser;

    @Column(name = "created_at", updatable = false,  nullable = false, columnDefinition = "timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "edited_date", nullable = false, columnDefinition = "timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editedDate;

}
