package br.com.goat.api.entities;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String social_name;
    private LocalDate dateBirth;
    private int age;
    private String preferredFoot;
    private String height;
    private Double marketValue;
    private String photoUrl;



   /*  private List<Position> positions; 
        OPCIONAL
   */ 
    
    /*  @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nationality")
    private Country nationality; */
    
    /*  @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "primary_position")
    private Position primaryPosition; */

    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "club")
    private Club club; 

    /*  @ManyToOne(cascade = CascadeType.ALL) ESSE TEM QUE VER COMO VAMOS ESTRUTURAR
	@JoinColumn(name = " club_history")
    private Club  clubHistory; */
}
