package sempadrao.proxy;

public class BancoDeDadosClube {
    // O PROBLEMA: O método está exposto. Não há controle de acesso centralizado.
    public double getSalarioJogador(String nomeJogador) {
        if (nomeJogador.equals("Arrascaeta")) {
            return 1500000.0; // Salário confidencial!
        }
        return 100000.0;
    }
}