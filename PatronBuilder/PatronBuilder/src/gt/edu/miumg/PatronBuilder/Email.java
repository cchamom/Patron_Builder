package gt.edu.miumg.PatronBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Email {

    private List<String> Destinatarios = new ArrayList<>();
    private String Asunto;
    private String Cuerpo;
    private List<File> Adjuntos = new ArrayList<>();

    public Email() {}

    private Email(EmailBuilder builder) {
        this.Asunto = builder.email.Asunto;
        this.Destinatarios = builder.email.Destinatarios;
        this.Cuerpo = builder.email.Cuerpo;
        this.Adjuntos = builder.email.Adjuntos;
    }

    public String toString() {
        return "Destinatarios: " + Destinatarios + "\n" +  // Usar '\n' para salto de línea
                "Asunto: " + Asunto + "\n" +
                "Cuerpo: " + Cuerpo + "\n";
    }

    public static class EmailBuilder implements Builder<Email> {
        private Email email = new Email();

        public EmailBuilder setDestinatario(String Destinatario) {
            this.email.Destinatarios.add(Destinatario);
            return this;
        }

        public EmailBuilder setAsunto(String Asunto) {
            this.email.Asunto = Asunto;
            return this;
        }

        public EmailBuilder setCuerpo(String Cuerpo) {
            this.email.Cuerpo = Cuerpo;
            return this;
        }

        public EmailBuilder setAdjuntos(File adjunto) {
            this.email.Adjuntos.add(adjunto);
            return this;
        }

        @Override
        public Email build() {
            if (email.Destinatarios.isEmpty()) {
                throw new RuntimeException("El correo no de puede enviar por que no tiene destinatario");
            }
            return new Email(this);
        }
    }

    public List<String> getDestinatarios() {
        return Destinatarios;
    }

    public void setDestinatarios(List<String> destinatarios) {
        this.Destinatarios = destinatarios;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String asunto) {
        this.Asunto = asunto;
    }

    public String getCuerpo() {
        return Cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.Cuerpo = cuerpo;
    }
}
