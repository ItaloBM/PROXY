package sempadrao.proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AcessoSemProxyTest {

    @Test
    void estagiarioPodeVerSalarioConfidencial() {
        // Um estagiário qualquer ou sistema não autorizado acessa diretamente os dados
        BancoDeDadosClube banco = new BancoDeDadosClube();

        double salario = banco.getSalarioJogador("Arrascaeta");

        // Quebra de segurança! O estagiário conseguiu ver o salário.
        assertEquals(1500000.0, salario);
    }
}