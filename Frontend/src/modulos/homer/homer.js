import angular from 'angular';
import uirouter from 'angular-ui-router';

import HomerController from './homer.controller';

import homerService from '../../servicos/homer.service';

export default angular.module('myApp.homer', [uirouter, homerService])
  .controller('HomerController', HomerController)
  .name;

  