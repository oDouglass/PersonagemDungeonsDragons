import Racas.iRaca
import org.example.Atributos

class Draconato : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            forca += 2
            carisma += 1
        }
    }
}
