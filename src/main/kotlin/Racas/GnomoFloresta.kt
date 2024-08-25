import Racas.iRaca
import org.example.Atributos

class GnomoFloresta : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            destreza += 1
        }
    }
}
