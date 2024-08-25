import Racas.iRaca
import org.example.Atributos

class AltoElfo : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            inteligencia += 1
        }
    }
}