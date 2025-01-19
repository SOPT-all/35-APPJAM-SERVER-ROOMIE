package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", nullable = false)
    private Long roomId;

    @Column(nullable = false)
    private String name="";

    @Column(nullable = false)
    private int monthlyRent;

    @Column(nullable = false)
    private int deposit;

    @Column(nullable = false)
    private String facility="";

    @Column(nullable = true)
    private LocalDate contractPeriod;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private int occupancyType;

    @Column(nullable = false)
    private String mainImgUrl="";

    @Column(nullable = false)
    private int prepaidUtilities;

    @Column(nullable = false)
    private String managementFee="";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private House house;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Roommate> roommates = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<HousingRequest> housingRequests = new ArrayList<>();
}
