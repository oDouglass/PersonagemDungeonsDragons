import Racas.iRaca
import org.example.Atributos

class HalflingRobusto : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            constituicao += 1
        }
    }
}
