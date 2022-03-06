package pt.ulusofona.cm.kotlin.challenge.interfaces

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException

interface Ligavel {
    var ligado: Boolean

    fun ligar(){
        if (estaLigado()){throw VeiculoLigadoException("O veiculo já se encontra ligado")}
        ligado = true
    }
    fun desligar(){
        if (!estaLigado()){throw VeiculoDesligadoException("O veiculo já se encontra desligado")
        }
        ligado = false
    }
    fun estaLigado():Boolean{
        return ligado
    }
}