import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  public showingFrequency = false;
  public showingMaxAge = false;
  public frequencyList: Map<string, number> = new Map<string, number>;
  public maxAgeNames: Map<string, number> = new Map<string, number>;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
  }

  public showFrequency(): void {
    this.http.get<Map<string, number>>(`http://localhost:8080/api/getStatistics`).subscribe((response: Map<string, number>) => {
      this.frequencyList = response;
    });
    if(this.showingFrequency == false) {
      this.showingFrequency = true;
    } else {this.showingFrequency = false}

  }

  public showMaxAge(): void {
    this.http.get<Map<string, number>>(`http://localhost:8080/api/getNameWithMaxAge`).subscribe((response: Map<string, number>) => {
      this.maxAgeNames = response;
    });
    if(this.showingMaxAge == false) {
    this.showingMaxAge = true;
    } else {this.showingMaxAge = false}
  }
}
