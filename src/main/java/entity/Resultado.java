package entity;

import lombok.Getter;
import lombok.Setter;

public class Resultado {
    @Getter@Setter
    private double media;
    @Getter@Setter
    private double mediana;
    @Getter@Setter
    private double desvioPadrao;
    @Getter@Setter
    private int quantidade;
}
