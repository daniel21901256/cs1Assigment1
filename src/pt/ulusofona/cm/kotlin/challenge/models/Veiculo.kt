package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

 abstract class Veiculo(val identificador : String) : Movimentavel {
    override var posicao : Posicao = Posicao(0,0)
    var dataDeAquisicao : Date = Date()

    abstract fun requerCarta() : Boolean

    fun atualizarDataDeAquisicao(){
        dataDeAquisicao = Date()
    }

    fun getId() : String{
        return identificador
    }

}