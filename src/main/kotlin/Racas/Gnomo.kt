import Racas.iRaca
import org.example.Atributos

class Gnomo : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            inteligencia += 2
        }
    }
}
