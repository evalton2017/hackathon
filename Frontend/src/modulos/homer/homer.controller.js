import { inherit } from "@uirouter/core";

export default class HomerController {

  constructor(homerService, $stateParams, $state) {
    var vm = this;
    this.name = 'Homer';
    this.chinelo={};
    if($state.params){
      vm.homer=$state.params.obj;  
      console.log(vm.home);   
    }else{
      this.home={};
    }

    init();
  //listar todos 
    function init(){
      homerService.getHomes().then(function abc(resp) {
        console.log(resp.data)
        vm.homes = resp.data;
       
      });
    }
//funcao para salvar
    this.salvar = function (){
          homerService.getSalvar(vm.home).then(function save(resp){
           alert("home cadastrado com sucesso");
           vm.home={};
           init();
           $state.go('pesquisar')  
        }).catch(function(response) {
          alert("Erro Usuario já cadastrado"+response);
      });
      return console.log(200);
    }

    this.atualizar = function (){
      homerService.getAtualizar(vm.home).then(function save(resp){
       vm.home=resp.data;
       alert("Home atualizado com sucesso");
    }).catch(function(response) {
      alert("Erro Usuario já cadastrado"+response);
  });
  return console.log(200);
}

     //metodo responsavel por salvar a filha, este aparecerar apos o cadastro do pai, ou durante a edição
  this.salvarChinelo = function(){
    console.log(vm.chinelo,vm.home.id)
    homerService.getSalvarChinelo(vm.chinelo,vm.home.id).then(function save(resp){
      alert("Chinelo cadastrado com sucesso!!");
      vm.home=resp.data;
      vm.chinelo={};
      init();
      
   }).catch(function(response) {
     alert("Erro usuario já possui numero maximo de chinelos"+response);
  });
  return console.log(200);
  }    



   this.pesquisar = function(id){
     /* homerService.getPesquisa(id).then(function pesq(resp){
          vm.home = resp.data;
          console.log(vm.homes);
      }).catch(console.error());*/
    }

    this.deletar = function(id){
       homerService.getExcluir(id).then(function pesq(){
        alert("Ao excluir o usuarios os chinelos serão excluidos");
        init();    
        $state.go('pesquisar')
      }).catch(console.error());
    } 
     

   this.editar = function(obj){
     
      homerService.getEditar(obj).then(function(resp){
        vm.home = resp.data;
        vm.chinelos=[];
        vm.chinelos=vm.home.chinelos;  
        alert("chinelo incluido com sucesso");      
        $state.go('pesquisar')
      })
           
   }

   this.voltar = function(){
    vm.home={};
    init(); 
   }

  
  }
  
}
HomerController.$inject = ['homerService', '$stateParams','$state'];

