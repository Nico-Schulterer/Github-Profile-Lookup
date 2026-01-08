import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Greeting } from  './components/greeting/greeting'
import {Searchbar} from './components/searchbar/searchbar';
import {ResultsList} from './components/results-list/results-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Greeting, Searchbar, ResultsList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');

  queryString = '';
}
