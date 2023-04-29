import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

import { AppComponent } from './app.component';
import { StatisticsComponent } from './statistics/statistics.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'statistics', component: StatisticsComponent },
  { path: '**', component: HomeComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    StatisticsComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
