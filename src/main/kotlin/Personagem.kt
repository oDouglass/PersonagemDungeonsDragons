package org.example

import Racas.iRaca

open class Personagem (val atributosIniciais: Atributos, raca: iRaca) {

    val atributos: Atributos
    val pontosDeVida: Int = 10

    init {
        // Aplica o aprimoramento da raça aos atributos iniciais
        atributos = raca.aplicarAprimoramento(atributosIniciais)
    }

}