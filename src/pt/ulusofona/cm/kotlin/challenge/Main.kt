package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.*
import java.util.*

fun main(){
  var vigarista = Pessoa("Tomas",Date(2000,1,1))
    print(vigarista)
  var motor = Motor(222,2222)
  var carro : Carro = Carro("askldhajshd",motor)
  vigarista.comprarVeiculo(carro)
  vigarista.tirarCarta()
  vigarista.moverVeiculoPara("askldhajshd",10,10)
  vigarista.moverPara(10,10)
}