package parkEasy;

import java.time.Duration;
import java.time.LocalTime;

public class Controle {
    Veiculo veiculo;
    String horaEntrada;
    String horaSaida;

    public Controle(Veiculo veiculo, String horaEntrada) {
        this.veiculo = veiculo;
        this.horaEntrada = horaEntrada;
    }


    public double calcularEstadia() {
        double valor = 0;
        long tempo;
        LocalTime inicio, fim;

        if (horaEntrada != null && horaSaida != null){
            inicio = LocalTime.parse(horaEntrada);
            fim = LocalTime.parse(horaSaida);
            tempo = Duration.between(inicio , fim).toMinutes();
            valor = 0.75 * tempo;
        }
        return valor;
    }

}