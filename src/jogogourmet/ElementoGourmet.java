package jogogourmet;

/**
 *
 * @author Marcos Felipe
 */
public class ElementoGourmet {
    
    private String descricao;
    private ElementoGourmet sim;
    private ElementoGourmet nao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ElementoGourmet getSim() {
        return sim;
    }

    public void setSim(ElementoGourmet sim) {
        this.sim = sim;
    }

    public ElementoGourmet getNao() {
        return nao;
    }

    public void setNao(ElementoGourmet nao) {
        this.nao = nao;
    }
    
}
