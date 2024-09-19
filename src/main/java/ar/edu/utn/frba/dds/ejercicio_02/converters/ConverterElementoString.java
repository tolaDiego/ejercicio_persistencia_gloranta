package ar.edu.utn.frba.dds.ejercicio_02.converters;

import ar.edu.utn.frba.dds.ejercicio_02.elementos.Arco;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.ElementoDefensor;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.Escudo;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.Espada;

import javax.persistence.AttributeConverter;
import javax.print.DocFlavor;

public class ConverterElementoString implements AttributeConverter<ElementoDefensor,String> {


    @Override
    public String convertToDatabaseColumn(ElementoDefensor elementoDefensor) {
        if(elementoDefensor instanceof Arco)
            return "ARCO";
        if(elementoDefensor instanceof Escudo)
            return "ESCUDO";
        if(elementoDefensor instanceof Espada)
            return "ESPADA";
        return null;
    }

    @Override
    public ElementoDefensor convertToEntityAttribute(String s) {
        ElementoDefensor elmento=null;
        switch (s){
            case "ARCO": elmento=new Arco(); break;
            case "ESCUDO" : elmento=new Escudo(); break;
            case "ESPADA": elmento=new Espada(); break;
        }
        return elmento;
    }
}
