package pt.ulusofona.cm.kotlin.challenge.models

 class Carro(identificador: String, var motor : Motor) : Veiculo(identificador) {
     override fun requerCarta(): Boolean {
         return true
     }
     var aquisicao = String.format("%02d-%02d-%02d",dataDeAquisicao.date,dataDeAquisicao.month+1,dataDeAquisicao.year+1900)
     override fun toString(): String {
         return "Carro | $identificador | $aquisicao | $posicao"
     }

 }