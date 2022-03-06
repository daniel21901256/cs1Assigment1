package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

  class Motor(var cavalos:Int, var cilindrada:Int) : Ligavel{
    override var ligado: Boolean = false

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }
}