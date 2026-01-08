import {Component, computed} from '@angular/core';
import {Search} from '../../services/search';

@Component({
  selector: 'app-results-list',
  imports: [],
  templateUrl: './results-list.html',
  styleUrl: './results-list.css',
})
export class ResultsList {

  constructor(private search: Search) {}

  readonly query =  computed(() => this.search.getQuery())

  readonly filteredResults = computed(() => this.search.filteredResults());

}
