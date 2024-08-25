package org.example
import Racas.*
import AltoElfo
import Anao
import AnaoColina
import AnaoMontanha
import Draconato
import Drow
import Elfo
import ElfoFloresta
import Gnomo
import GnomoFloresta
import GnomoRochas
import Halfling
import HalflingPesLeves
import HalflingRobusto
import Humano
import MeioElfo
import MeioOrc
import Racas.iRaca
import Tiefling

fun main() {

    // Estou instanciando as duas classes que criei para distribuir os pontos e receber os atributos do personagem
    val atributosIniciais = Atributos()
    val distribuidor = DistribuidorDePontos(atributosIniciais, 27)

    interfaceConsole(distribuidor) //Chama a função e passa o distribuidor

    val novoPersonagem = Personagem(atributosIniciais, escolherRaca()) //Instancia o Novo Personagem

    println("\nPersonagem criado com sucesso!")

    println("Ficou assim:")
    println("1. Força: ${novoPersonagem.atributos.forca}")
    println("2. Destreza: ${novoPersonagem.atributos.destreza}")
    println("3. Constituição: ${novoPersonagem.atributos.constituicao}")
    println("4. Inteligência: ${novoPersonagem.atributos.inteligencia}")
    println("5. Sabedoria: ${novoPersonagem.atributos.sabedoria}")
    println("6. Carisma: ${novoPersonagem.atributos.carisma}")
    println("7. Pontos de Vida: ${novoPersonagem.pontosDeVida}")
}

fun exibirAtributos(atributos: Atributos) { // Printar valores dos atributos durante fun interfaceConsole;
    println("Atributos atuais:")
    println("1. Força: ${atributos.forca}")
    println("2. Destreza: ${atributos.destreza}")
    println("3. Constituição: ${atributos.constituicao}")
    println("4. Inteligência: ${atributos.inteligencia}")
    println("5. Sabedoria: ${atributos.sabedoria}")
    println("6. Carisma: ${atributos.carisma}")
}

fun exibirRacas(){ // Criada para printar as classes Raças, da interface iRaca;
    println("0. Alto Elfo")
    println("1. Anão")
    println("2. Anão da Colina")
    println("3. Anão da Montanha")
    println("4. Draconato")
    println("5. Drow")
    println("6. Elfo")
    println("7. Elfo da Floresta")
    println("8. Gnomo")
    println("9. Gnomo da Floresta")
    println("10. Gnomo de Rochas")
    println("11. Halfling")
    println("12. Halfling Pés Leves")
    println("13. Halfling Robusto")
    println("14. Humano")
    println("15. Meio Elfo")
    println("16. Meio Orc")
    println("17. Tielfling")
    println("Se você não escolher nenhuma, você será um Humano!")
}

fun escolherRaca(): iRaca { //Função para escolher a Raça, retornará um objeto do tipo iRaca
    println("***ESCOLHER RAÇA***")

    exibirRacas() //Chamada da função de exibir raças;

    println("Escolha uma raça para o personagem (0-17):")

    val escolhaRaca = readLine()?.toInt() // Variavél escolhaRaca para armazenar a opção escolhida pelo jogador;

    //racaSelecionada armazenará o objeto do tipo iRaca, para retornar no final da função;
    // when, switch case do kotlin, utilizado para verificar a escolhaRaca(Int) e retornar o que precisamos;
    val racaSelecionada: iRaca = when (escolhaRaca) {
        0 -> AltoElfo()
        1 -> Anao()
        2 -> AnaoColina()
        3 -> AnaoMontanha()
        4 -> Draconato()
        5 -> Drow()
        6 -> Elfo()
        7 -> ElfoFloresta()
        8 -> Gnomo()
        9 -> GnomoFloresta()
        10 -> GnomoRochas()
        11 -> Halfling()
        12 -> HalflingPesLeves()
        13 -> HalflingRobusto()
        14 -> Humano()
        15 -> MeioElfo()
        16 -> MeioOrc()
        17 -> Tiefling()
        else -> Humano() // valor padrão, outro tipo de verificação está em desenvolvimento;
    }
    return racaSelecionada //Retornando algum tipo de raça, que é o que precisamos na Main;
}

fun interfaceConsole(distribuidor: DistribuidorDePontos) { // Função que cria a interface de console, recebendo um objeto distribuidor do tipo DistribuidorDePontos

    var continuar = true // Declara uma variável boolean local chamada "continuar", iniciando como verdadeira para controlar o loop

    while (continuar) { // Loop que continua enquanto "continuar" for verdadeiro
        println("\nPontos restantes: ${distribuidor.pontosRestantes()}") // Exibe no console a quantidade de pontos

        // Verifica se os pontos restantes são zero
        if (distribuidor.pontosRestantes() == 0) { // Se os pontos restantes forem iguais a zero, então define "continuar" como falso para encerrar o loop
            println("Todos os pontos foram distribuídos. Escolha a raça do personagem.")
            continuar = false
            continue // Pula para próxima interação.. no caso, encerra o while e encerra tudo
        }

        exibirAtributos(distribuidor.atributos) // Mostrar os atributos atuais;

        println("Escolha um atributo para ajustar (1-6) ou 0 para sair:")
        val escolha = readLine()?.toIntOrNull()

        if (escolha == 0) { // Se cair aqui, o loop se encerra..
            continuar = false
            continue
        }

        println("Digite o novo valor para o atributo escolhido (8-15):")
        val novoValor = readLine()?.toIntOrNull()

        if (novoValor != null && escolha != null) { // Verifica se o novo valor e a escolha não são nulos
            val atributoEscolhido = when (escolha) {
                1 -> "forca"
                2 -> "destreza"
                3 -> "constituicao"
                4 -> "inteligencia"
                5 -> "sabedoria"
                6 -> "carisma"
                else -> null // Retorna null se a "escolha" não for nenhuma dessas;
            }

            if (atributoEscolhido != null) { // Verifica se o atributo escolhido não é nulo
                distribuidor.aumentarAtributo(atributoEscolhido, novoValor) // Chama o metodo "aumentarAtributo" do distribuidor
                // Aqui que mandamos para a classe Distribuidor o atributo (Força, e o valor que escolhemos, no distribuidor vai informar se está entre o 8-15;
            } else {
                println("Escolha inválida.") // Se o atributo escolhido for nulo;
            }
        } else {
            println("Entrada inválida.") // Se o novo valor ou a escolha forem nulos;
        }

    }
}

