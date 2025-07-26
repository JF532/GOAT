package br.com.goat.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tranfers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToOne
    @JoinColumn(name = "origin_club_id")
    private Club originClub;

    @OneToOne
    @JoinColumn(name = "destiny_club_id")
    private Club destinyClub;

    private LocalDate transferDate;

    private String transferType;

    private Double transferAmount;
}
