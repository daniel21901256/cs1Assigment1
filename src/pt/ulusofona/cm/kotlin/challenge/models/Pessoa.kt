package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.exceptions.*
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDateTime
import java.util.*

 class Pessoa(var nome: String, var dataDeNascimento : Date) : Movimentavel{
    override var posicao: Posicao = Posicao(0,0)
    var veiculos = mutableListOf<Veiculo>()
    var carta : Carta? = null

    fun comprarVeiculo(veiculo: Veiculo){
       veiculo.atualizarDataDeAquisicao()
       veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador:String) : Veiculo{
            for (veiculo in veiculos) {
                if (veiculo.getId() == identificador) {
                    return veiculo
                }
            }
         throw VeiculoNaoEncontradoException("O veiculo com id $identificador não foi encontrado")

    }

    fun venderVeiculo(identificador : String, comprador:Pessoa) {

           var veiculo = pesquisarVeiculo(identificador)
           comprador.comprarVeiculo(veiculo)
           veiculos.remove(veiculo)

    }

    fun moverVeiculoPara(identificador:String, x:Int, y:Int){

           var veiculo = pesquisarVeiculo(identificador)
           estouPerto(veiculo.posicao)
           if(veiculo.requerCarta() && temCarta()){
               when(veiculo){
                   is Carro -> if(!veiculo.motor.estaLigado()){veiculo.motor.ligar()}
               }
               veiculo.moverPara(x,y)
               moverPara(x,y)
               when(veiculo){
                   is Carro -> veiculo.motor.desligar()
               }
           }else if (veiculo.requerCarta() && !temCarta()){
               throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
           }else{
               veiculo.moverPara(x,y)
               moverPara(x,y)
           }
    }

    fun estouPerto(posicao2: Posicao):Boolean{
        if(posicao.getx() == posicao2.getx() &&  posicao.gety() == posicao2.gety()){
            return true
        }else{
            throw PessoaLongeVeiculoException("Não está perto do veiculo que pretende movimentar\nEste encontra-se na posição $posicao2")
        }
    }

    fun temCarta():Boolean{
        return carta != null
    }

    fun tirarCarta(){
            if (calcularMaiorDeIdade(dataDeNascimento)) {
                carta = Carta()
            }

    }

    fun calcularMaiorDeIdade(birthday: Date):Boolean{
        var dataAtual = LocalDateTime.now()
        if(dataAtual.year - 18 > birthday.year){
           return true
        }else if(dataAtual.year - 18 == birthday.year){
            if(dataAtual.monthValue  > birthday.month){
                return true
            }else if(dataAtual.monthValue  == birthday.month){
                if(dataAtual.dayOfMonth >= birthday.date){
                    return true
                }
            }
        }
        throw MenorDeIdadeException("$nome é menor de idade")
    }

     var nascimento = String.format("%02d-%02d-%02d",dataDeNascimento.date,dataDeNascimento.month,dataDeNascimento.year)

    override fun toString(): String {
        return "Pessoa | $nome | $nascimento | $posicao"
    }
}