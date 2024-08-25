import Racas.iRaca
import org.example.Atributos

class Drow : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            carisma += 1
        }
    }
}
