import Racas.iRaca
import org.example.Atributos

class Humano : iRaca {

    override fun aplicarAprimoramento(atributos: Atributos): Atributos {
        return atributos.apply {
            forca += 1
            destreza += 1
            constituicao += 1
            inteligencia += 1
            sabedoria += 1
            carisma += 1
        }
    }
}

