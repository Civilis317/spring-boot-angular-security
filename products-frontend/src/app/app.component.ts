import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Demo';
  greeting = {};

  constructor(private http: HttpClient) {
    const headers = new HttpHeaders().set('authorization', 'Basic ' + btoa('testuser' + ':' + 'welcome1'));

    http.get('http://localhost:7080/product-service/resource', {headers: headers}).subscribe(data => this.greeting = data);
  }
}