package br.com.goat.api.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String name;
    private String socialName;
    private LocalDate dateBirth;
    private int age;
    private String preferredFoot;
    private String height;
    private Double marketValue;
    private String photoUrl;



   /*  private List<Position> positions; 
        OPCIONAL
   */ 
    
    @ManyToOne
	@JoinColumn(name = "nationality_id")
    private Country nationalityId; 
    
    @ManyToOne
	@JoinColumn(name = "primary_position_id")
    private Position primaryPositionId; 

    @ManyToOne
	@JoinColumn(name = "club_id")
    private Club clubId; 

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transfer> transfers = new HashSet<>();
}
