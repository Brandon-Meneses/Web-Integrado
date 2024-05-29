import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit{
  tablaArray: any;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8080/custom-servlet').subscribe(data => {
      this.tablaArray = data;
      console.log(this.tablaArray);
    });
  }
}
