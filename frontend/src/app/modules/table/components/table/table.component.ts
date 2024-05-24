import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit{
  tabla: any

  constructor(private http: HttpClient) {  }

  ngOnInit(): void {
    const requestOptions = {
      headers: new HttpHeaders({
        'Authorization': 'Basic YWRtaW46YWRtaW4=',
      })
    }

    this.http.get('http://localhost:8080/api/libro', requestOptions).subscribe((data) => {
      this.tabla = data
    })
  }

}
