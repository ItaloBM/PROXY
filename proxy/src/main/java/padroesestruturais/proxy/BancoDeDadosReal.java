package padroesestruturais.proxy;

public class BancoDeDadosReal implements BancoDeDados {

    public BancoDeDadosReal() {
        // Simulando um carregamento pesado (ex: conectar ao servidor da AWS)
        System.out.println("Conectando ao Banco de Dados Real do Clube...");
    }

    @Override
    public double getSalarioJogador(String nomeJogador) {
        if (nomeJogador.equals("Arrascaeta")) {
            return 1500000.0;
        }
        return 100000.0;
    }
}