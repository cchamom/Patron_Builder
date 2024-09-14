import gt.edu.miumg.PatronBuilder.Email;

public class Main {
    public static void main(String[] args) {

        Email email = new Email.EmailBuilder()
                .setDestinatario("crsitianchamo0606@gmail.com")
                .setAsunto("Asunto: Ofertas de cursos en linea")
                .setCuerpo("Oferta de un 15% en la inscripcion de nuestros cursos en linea por fechas patrias")
                .build();

        System.out.println(email);

    }
}
