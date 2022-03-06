package pt.ulusofona.cm.kotlin.challenge.models


  class Bicicleta(identificador : String) : Veiculo(identificador) {
       override fun requerCarta(): Boolean {
          return false
      }
      var aquisicao = String.format("%02d-%02d-%02d",dataDeAquisicao.date,dataDeAquisicao.month+1,dataDeAquisicao.year+1900)
      override fun toString(): String {
          return "Bicicleta | $identificador | $aquisicao | $posicao"
      }
  }