import Racas.iRaca
import org.example.Atributos

class Anao : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            constituicao += 2
        }
    }
}