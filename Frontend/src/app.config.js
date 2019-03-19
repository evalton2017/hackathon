routing.$inject = ['$stateProvider', '$urlRouterProvider'];

export default function routing($stateProvider, $urlRouterProvider) {
    let homeState = {
        name: 'home',
        url: '/home',
        templateUrl: './modulos/home/home.view.html',
        controller: 'HomeController',
        controllerAs: 'vm'
      }
      $stateProvider.state(homeState);

      let pesquisarState = {
        name: 'pesquisar',
        url: '/pesquisar',
        templateUrl: './modulos/homer/pesquisar.view.html',
        controller: 'HomerController',
        controllerAs: 'vm'
      }
      $stateProvider.state(pesquisarState);

      let homerState = {
        name: 'homer',
        url: '/homer',
        templateUrl: './modulos/homer/homer.view.html',
        controller: 'HomerController',
        controllerAs: 'vm'
      }
      $stateProvider.state(homerState);
       

      $urlRouterProvider.otherwise('/home')  
}

