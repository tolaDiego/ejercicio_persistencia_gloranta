package ar.edu.utn.frba.dds.ejercicio_02.personajes;

import ar.edu.utn.frba.dds.ejercicio_02.converters.ConverterElementoString;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.ElementoDefensor;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_personaje")
public class Personaje {
  @Id
  @GeneratedValue
  private long id;

  @Getter
  @ElementCollection
  @CollectionTable(name = "elemento_defensor",joinColumns =@JoinColumn(name = "id_personaje"))
  @Convert(converter= ConverterElementoString.class)
  private List<ElementoDefensor> elementos;

  @Getter @Setter
  @Column
  private Integer estamina;

  @Getter @Setter
  @Column
  private Integer puntosDeVida;

  public Personaje(){
    this.elementos = new ArrayList<>();
  }

  public void atacar(Personaje personaje) {
  //todo
  }

  public void agregarElemento(ElementoDefensor elemento){
    this.elementos.add(elemento);
  }

}
