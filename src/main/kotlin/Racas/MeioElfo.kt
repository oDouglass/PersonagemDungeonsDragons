import Racas.iRaca
import org.example.Atributos

class MeioElfo : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            carisma += 2
        }
    }
}
