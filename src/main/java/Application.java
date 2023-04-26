import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Application {

    public static void main(String[] args) {
        System.out.println("Iniciando la aplicacion con Quarkus y MongoDB...");
        Quarkus.run(args);
    }
}

