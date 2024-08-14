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
@Table(name = "relationships")
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", nullable = false)
    private User followerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed_id", nullable = false)
    private User followedId;

    @Enumerated(EnumType.STRING)
//    @Column(name = "relationship_type", nullable = false)
    @Column(name = "relationship_type")
    private RelationshipType relationshipType;

    @Column(name = "follower_or_not", columnDefinition = "BIT", nullable = false)
    private Integer followerOrNot;

    @Column(name = "created_at", updatable = false,  nullable = false, columnDefinition = "timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
