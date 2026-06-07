package padroesestruturais.proxy;

public class BancoDeDadosProxy implements BancoDeDados {

    private BancoDeDadosReal bancoReal;
    private String cargoUsuarioLogado;

    public BancoDeDadosProxy(String cargoUsuarioLogado) {
        this.cargoUsuarioLogado = cargoUsuarioLogado;
    }

    @Override
    public double getSalarioJogador(String nomeJogador) {
        // 1. O Proxy faz a verificação de segurança (Protection Proxy)
        if (cargoUsuarioLogado.equals("Presidente") || cargoUsuarioLogado.equals("Diretor")) {

            // 2. O Proxy só cria o objeto pesado se a senha estiver correta (Virtual Proxy / Lazy Load)
            if (bancoReal == null) {
                bancoReal = new BancoDeDadosReal();
            }

            // 3. Repassa o pedido para o objeto real
            return bancoReal.getSalarioJogador(nomeJogador);
        }

        // Se não tiver permissão, bloqueia a chamada!
        throw new SecurityException("Acesso Negado! O cargo '" + cargoUsuarioLogado + "' não tem permissão para ver salários.");
    }
}