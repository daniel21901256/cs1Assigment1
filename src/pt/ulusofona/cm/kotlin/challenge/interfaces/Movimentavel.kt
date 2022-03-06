package pt.ulusofona.cm.kotlin.challenge.interfaces
import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.models.Posicao

interface Movimentavel {
    var posicao: Posicao
    fun moverPara(x: Int, y:Int){
        if(posicao.x == x && posicao.y == y){
            throw AlterarPosicaoException("Já se encontra no lugar que pretende ir")
        }
        posicao.alterarPosicaoPara(x,y)
    }
}