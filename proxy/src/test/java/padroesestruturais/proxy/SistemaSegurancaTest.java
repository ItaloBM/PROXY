package padroesestruturais.proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaSegurancaTest {

    @Test
    void devePermitirAcessoParaPresidente() {
        // O cliente pensa que está falando com o banco, mas está falando com o Proxy
        BancoDeDados banco = new BancoDeDadosProxy("Presidente");

        double salario = banco.getSalarioJogador("Arrascaeta");

        assertEquals(1500000.0, salario);
    }

    @Test
    void deveBloquearAcessoParaEstagiario() {
        BancoDeDados banco = new BancoDeDadosProxy("Estagiario");

        // Testa se o Proxy levanta a exceção correta ao tentar espiar os dados
        Exception exception = assertThrows(SecurityException.class, () -> {
            banco.getSalarioJogador("Arrascaeta");
        });

        assertEquals("Acesso Negado! O cargo 'Estagiario' não tem permissão para ver salários.", exception.getMessage());
    }
}