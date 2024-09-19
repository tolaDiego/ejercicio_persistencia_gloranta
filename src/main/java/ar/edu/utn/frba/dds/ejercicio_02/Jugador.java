package ar.edu.utn.frba.dds.ejercicio_02;

import ar.edu.utn.frba.dds.ejercicio_02.personajes.Personaje;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "jugador")
public class Jugador {
  @Id
  @GeneratedValue
  private long id;
  @Column
  private String nombre;
  @Column
  private String apellido;
  @Column(name = "fecha_alta",columnDefinition = "DATETIME")
  private LocalDate fechaAlta;
  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "id_personaje")
  private Personaje personaje;

  public Jugador() {
    this.fechaAlta = LocalDate.now();
  }

  public void cambiarPersonaje(Personaje personaje) {
    this.personaje = personaje;
  }
}
