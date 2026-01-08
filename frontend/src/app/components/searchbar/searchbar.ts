import {Component} from '@angular/core';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {Search} from '../../services/search';

@Component({
  selector: 'app-searchbar',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './searchbar.html',
  styleUrl: './searchbar.css',
})
export class Searchbar {

  constructor(private search: Search) {}

  searchControl = new FormControl('');

  onKeyPress(event: KeyboardEvent) {
    if (event.key === "Enter" && this.searchControl.value != null) {
      this.search.setQuery(this.searchControl.value)
    }
  }

}
