import Racas.iRaca
import org.example.Atributos

class Tiefling : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            inteligencia += 1
            carisma += 2
        }
    }
}
