import angular from 'angular';

class HomerService {

    constructor($http) {
        this.$http = $http;
        //const apiBase = "http://localhost:9090/projeto/api";
        const apiBase = "http://localhost:8080";
        this.path =  apiBase + "/homer";
    }
    
    getHomes() {
        return this.$http.get(this.path);
    }
 
    //metodo responsavel por salvar a entidade Pai
    getSalvar(data) {
        if(data.situacao==true){
            data.situacao="A";
        }else{
            data.situacao="I";
        }
        return this.$http.post(this.path+'/salvar',data);
    }

   getSalvarChinelo(chinelo,id){
       return this.$http.post(this.path+'/salvar/chinelo/'+id,chinelo);
   }

    
    //metodo responsavel por pesquisar por nome ou todos se vazio
    getPesquisa(nome){
        if(nome==null || nome=="undefined"){
           return this.getHomes();
        }else{
            return this.$http.get(this.path+'/pesquisar/'+nome);
        }
        
    }

    //metodo usado para excluir a entidade pai, bem como as filhas
    getExcluir(codigo){
        return this.$http.delete(this.path+'/deletar/'+codigo);
    }

    getEditar(codigo){
        return this.$http.get(this.path+'/editar/'+codigo);
    }

    getAtualizar(data){
        return this.$http.put(this.path+'/atualizar/',data);
    }
 
 
}

export default angular.module('services.homer-service', [])
.service('homerService', HomerService)
.name;

