import Racas.iRaca
import org.example.Atributos

class GnomoRochas : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            constituicao += 1
        }
    }
}
