import Racas.iRaca
import org.example.Atributos

class HalflingPesLeves : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            carisma += 1
        }
    }
}
