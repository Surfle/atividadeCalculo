package service;

import entity.Calculo;
import entity.Resultado;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Collections;

@Service
public class CalcularService {
    public Resultado cadastrar(Calculo calculo){
        Resultado resultado = new Resultado();
        int tamanho = calculo.getNumero().size();

        Assert.isTrue(calculo.getNumero() != null, "numeros nao informados");
        Assert.isTrue(tamanho >= 20, "numero de elementos menor que 20");

        Collections.sort(calculo.getNumero());

        for (int i: calculo.getNumero()){
            resultado.setMedia(resultado.getMedia()+i);
        }
        resultado.setMedia(resultado.getMedia()/tamanho);


        if (tamanho/2 == 0){
            resultado.setMediana(((calculo.getNumero().get(tamanho/2)) + (calculo.getNumero().get((tamanho/2)-1)))/2);
        }
        else {
            resultado.setMediana(calculo.getNumero().get((int) Math.round((double) tamanho / 2)));
        }

        double auxMedia = resultado.getMedia();
        double somaDiferencasQuadradas = 0;


        for (int i: calculo.getNumero()){
            double diferenca = i - auxMedia;
            somaDiferencasQuadradas += diferenca * diferenca;

        }
        double desvio = somaDiferencasQuadradas / (tamanho);
        resultado.setDesvioPadrao(Math.sqrt(desvio));

        resultado.setQuantidade(tamanho);


        return resultado;
    }

}
