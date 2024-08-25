import Racas.iRaca
import org.example.Atributos

class AnaoMontanha : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            forca += 2
        }
    }
}

