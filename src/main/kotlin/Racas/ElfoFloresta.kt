import Racas.iRaca
import org.example.Atributos

class ElfoFloresta : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            sabedoria += 1
        }
    }
}
