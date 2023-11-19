import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorDocumentoTest {

    @Test
    public void testarEditorDocumento() {
        EditorDocumento editor = new EditorDocumento();

        editor.setConteudo("Conteúdo inicial");
        editor.salvar();

        editor.setConteudo("Adicionando texto");
        editor.salvar();

        editor.setConteudo("Fazendo mais alterações");
        editor.salvar();

        editor.desfazer();
        assertEquals("Adicionando texto", editor.getConteudo());

        editor.refazer();
        assertEquals("Fazendo mais alterações", editor.getConteudo());
    }
}