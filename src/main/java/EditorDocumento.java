import java.util.ArrayList;
import java.util.List;

class EditorDocumento {
    private String conteudo;
    private final List<EstadoDocumento> estados = new ArrayList<>();
    private int indiceAtual = -1;

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void salvar() {
        indiceAtual++;
        estados.add(new EstadoDocumento(conteudo));
    }

    public void desfazer() {
        if (indiceAtual > 0) {
            // Decrementa o índice e restaura o estado anterior
            indiceAtual--;
            conteudo = estados.get(indiceAtual).getConteudo();
        }
    }

    public void refazer() {
        if (indiceAtual < estados.size() - 1) {
            indiceAtual++;
            conteudo = estados.get(indiceAtual).getConteudo();
        }
    }
}
