package exemplos.aula_250513.pagamento;

abstract class Pagamento {
    protected double valor;

    public abstract void processar();
}

class PagamentoCartao extends Pagamento {
    private String numeroCartao;
    @Override
    public void processar() {
        System.out.println("Processando pagamento com cartão: " + valor);
    }
}

class PagamentoBoleto extends Pagamento {
    private String codigoBoleto;
    @Override
    public void processar() {
        System.out.println("Processando pagamento com boleto: " + valor);
    }
}

class PagamentoPix extends Pagamento {
    private String chavePix;
    @Override
    public void processar() {
        System.out.println("Processando pagamento com Pix: " + valor);
    }
}

class App {
    public static void main(String[] args) {
        Pagamento pagamento = new PagamentoCartao();
        pagamento.valor = 100.0;
        pagamento.processar();

        pagamento = new PagamentoBoleto();
        pagamento.valor = 200.0;
        pagamento.processar();

        pagamento = new PagamentoPix();
        pagamento.valor = 300.0;
        pagamento.processar();
    }
}