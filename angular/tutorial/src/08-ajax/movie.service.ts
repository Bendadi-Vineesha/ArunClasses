import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  // p05
  private host:string = "http://localhost:8080/api/v1/movies";

  constructor(private http:HttpClient) { }

  findAll(){
    // return this.http.get(this.host);
    return this.http.get(environment.movieHost);
  }
  getById(id:number){
    // return this.http.get(this.host+"/"+id);
    return this.http.get(`${this.host}/${id}`);
  }
  createMovie(m:any){
    let myHeaders:HttpHeaders = new HttpHeaders();
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Accept", "application/json");
    return this.http.post(this.host, m, {headers: myHeaders});
  }
  delete(id:number){
    return this.http.delete(`${this.host}/${id}`);
  }
  
}
