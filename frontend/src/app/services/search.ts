import {computed, Injectable, signal} from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Search {

  private _query = signal<string>('')

  results: string[] = [
    'Apple', 'Apricot', 'Banana', 'Blackberry', 'Blueberry',
    'Cherry', 'Durian', 'Grape', 'Guava', 'Mango', 'Orange'
  ];

  setQuery(value: string) {
    this._query.set(value)
  }

  getQuery() {
    return this._query()
  }

  filteredResults= computed(() => {
    return this.results.filter(r => r.trim().toLowerCase().includes(this._query().trim().toLowerCase()))
  });

}
