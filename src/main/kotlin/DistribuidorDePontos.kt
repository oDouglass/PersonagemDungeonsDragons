package org.example
import org.example.Atributos
import org.example.Personagem

// Classe aberta que gerencia a distribuição de pontos nos atributos
// Recebe um objeto "Atributos" e um valor inicial de "pontosDisponiveis = 27"
open class DistribuidorDePontos(val atributos: Atributos,var pontosDisponiveis: Int) {

    // Nunca tinha usado, é um mapa para facilitar o código
    val custoPorPonto = mapOf(
        8 to 0,
        9 to 1,
        10 to 2,
        11 to 3,
        12 to 4,
        13 to 5,
        14 to 7,
        15 to 9 // Aumentar para 15 e custa 9 pontos
    )

    fun calcularCusto(novoValor: Int, valorAtual: Int): Int { // Função para calcular o custo de alterar um atributo de "valorAtual" para "novoValor"
        val custoNovo = custoPorPonto[novoValor] ?: throw IllegalArgumentException("Valor inválido") // Obtém o custo do novo valor do atributo ou lança uma exceção se for inválido
        val custoAtual = custoPorPonto[valorAtual] ?: throw IllegalArgumentException("Valor inválido") /// Obtém o custo do valor atual do atributo ou lança uma exceção se for inválido
        return custoNovo - custoAtual // Retorna a diferença entre o custo do novo valor e o custo do valor atual.
    }

    // Função que tenta aumentar o valor de um atributo específico, retornando verdadeiro se for bem-sucedido
    fun aumentarAtributo(atributo: String, novoValor: Int): Boolean {
        if (novoValor !in 8..15) {
            println("Valor inválido: os atributos devem estar entre 8 e 15.")
            return false
        }

        val valorAtual = when(atributo) { // Obtém o valor atual do atributo específico com base no nome do atributo passado
            "forca" -> atributos.forca
            "destreza" -> atributos.destreza
            "constituicao" -> atributos.constituicao
            "inteligencia" -> atributos.inteligencia
            "sabedoria" -> atributos.sabedoria
            "carisma" -> atributos.carisma
            else -> throw IllegalArgumentException("Atributo desconhecido") // Fluxo de excessão
        }

        val custo = calcularCusto(novoValor, valorAtual) // Calcula o custo para mudar o valor do atributo
        return if (pontosDisponiveis >= custo) { // Verifica se há pontos suficientes para realizar a mudança
            pontosDisponiveis -= custo // Deduz o custo dos pontos disponíveis
            when(atributo) { // Atualizar o valor do atributo com o novo valor
                "forca" -> atributos.forca = novoValor
                "destreza" -> atributos.destreza = novoValor
                "constituicao" -> atributos.constituicao = novoValor
                "inteligencia" -> atributos.inteligencia = novoValor
                "sabedoria" -> atributos.sabedoria = novoValor
                "carisma" -> atributos.carisma = novoValor
            }
            true // Retorna verdadeiro, indicando que a operação foi bem
        } else {
            println("Pontos insuficientes para aumentar $atributo para $novoValor.") // Não tem pontos
            false // Falhouuu
        }
    }

    fun pontosRestantes(): Int { // Função que retorna a quantidade de pontos restantes.
        return pontosDisponiveis // Retorna o valor de "pontosDisponiveis"
    }
}
