import Racas.iRaca
import org.example.Atributos

class Halfling : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            destreza += 2
        }
    }
}
