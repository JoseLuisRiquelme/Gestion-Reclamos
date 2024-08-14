package cl.praxis.GestionReclamos.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "complain")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complain_id")
    private int id;
    private String title;
    private String description;
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_id", nullable = false)
    private User user;
}
