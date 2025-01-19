package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="roommate")
@Data
public class Roommate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roommate_id", nullable = false)
    private Long roommateId;

    private int age;
    private String job;
    private String mbti;
    private String sleepTime;
    private String activateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}
