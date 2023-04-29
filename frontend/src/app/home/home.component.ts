import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  name: string = '';
  age: string | null = null;
  isSubmitted: boolean = false;
  enteredName: string = '';

  constructor(private http: HttpClient) {}

  findAge(): void {
    if (this.name) {
      this.http.get(`http://localhost:8080/api/getAge/${this.name}`).subscribe((response: any) => {
        this.age = response.toString();
        this.enteredName = this.name;
        this.name = '';
        this.isSubmitted = true;
      });
    }
  }

}
