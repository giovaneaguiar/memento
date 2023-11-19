import java.util.Stack;

class EditorDocumento {
    private String conteudo;
    private final Stack<EstadoDocumento> pilhaDesfazer = new Stack<>();
    private final Stack<EstadoDocumento> pilhaRefazer = new Stack<>();

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void salvar() {
        pilhaDesfazer.push(new EstadoDocumento(conteudo));
        pilhaRefazer.clear();
    }

    public void desfazer() {
        if (!pilhaDesfazer.isEmpty()) {
            pilhaRefazer.push(new EstadoDocumento(conteudo));
            conteudo = pilhaDesfazer.pop().getConteudo();
        }
    }

    public void refazer() {
        if (!pilhaRefazer.isEmpty()) {
            pilhaDesfazer.push(new EstadoDocumento(conteudo));
            conteudo = pilhaRefazer.pop().getConteudo();
        }
    }
}