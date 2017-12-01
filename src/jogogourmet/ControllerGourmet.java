package jogogourmet;

/**
 *
 * @author Marcos Felipe
 */
public class ControllerGourmet {

    private ElementoGourmet inicio;
    private final int SIM = 0;
    private final int NAO = 1;

    public ControllerGourmet() {
        inicio = exemploObject();
    }

    public ElementoGourmet exemploObject() {

        ElementoGourmet lasanha = new ElementoGourmet();
        lasanha.setDescricao("Lasanha");
        lasanha.setSim(null);
        lasanha.setNao(null);

        ElementoGourmet bolo = new ElementoGourmet();
        bolo.setDescricao("Bolo de Chocolate");
        bolo.setSim(null);
        bolo.setNao(null);

        ElementoGourmet massa = new ElementoGourmet();
        massa.setDescricao("Massa");
        massa.setSim(lasanha);
        massa.setNao(bolo);

        return massa;
    }

    public void iniciarRecursao() {
        System.out.println("INICIO DE RECURSAO");
        proximo(inicio);
        System.out.println("FIM DE RECURSAO");
    }

    public ElementoGourmet proximo(ElementoGourmet atual) {
        System.out.println("Método proximo INÍCIO, atual = " + atual.getDescricao());
        int escolha = ViewGourmet.showPerguntaPrato(atual.getDescricao());
        System.out.println(escolha);
        ElementoGourmet novoRamo;
        switch (escolha) {
            case SIM:
                if (atual.getSim() == null) {
                    ViewGourmet.showAcertei();
                    novoRamo = null;
                    System.out.println("MOSTREI O ACERTEI");
                } else {
                    novoRamo = proximo(atual.getSim());
                    if (novoRamo != null) {
                        atual.setSim(novoRamo);
                        novoRamo = null;
                    }
                    System.out.println("VOLTEI DO PROXIMO");
                }
                break;
            case NAO:
                if (atual.getNao() == null) {
                    novoRamo = criarNovoRamo(atual);
                } else {
                    novoRamo = proximo(atual.getNao());
                    if (novoRamo != null) {
                        atual.setNao(novoRamo);
                        novoRamo = null;
                    }
                }
                break;
            default:
                novoRamo = null;
                break;
        }
        System.out.println("TESTE");
        System.out.println("Método proximo FIM, atual = " + atual.getDescricao());

        return novoRamo;
    }

    public ElementoGourmet criarNovoRamo(ElementoGourmet atual) {
        String novoDescricao = ViewGourmet.showPerguntaNovoPrato();
        System.out.println(novoDescricao);

        if (novoDescricao != null) {
            novoDescricao = novoDescricao.trim();
            if (!novoDescricao.equals("")) {
                System.out.println("CRIAR NOVO RAMO");
                ElementoGourmet novo = new ElementoGourmet();
                novo.setDescricao(novoDescricao);
                novo.setSim(null);
                novo.setNao(null);

                String difEntreNovoEAtualDescricao = ViewGourmet.showPerguntaDiferenca(novoDescricao, atual.getDescricao());
                System.out.println(difEntreNovoEAtualDescricao);

                ElementoGourmet difEntreNovoEAtual = new ElementoGourmet();
                difEntreNovoEAtual.setDescricao(difEntreNovoEAtualDescricao);
                difEntreNovoEAtual.setSim(novo);
                difEntreNovoEAtual.setNao(atual);

                return difEntreNovoEAtual;
            }
        }
        return null;

    }
}
