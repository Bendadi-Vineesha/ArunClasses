import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit {

  user:string = "";
  constructor(private activatedRoute:ActivatedRoute) { 
    this.activatedRoute.params.subscribe((newParams:any)=>{
      console.log(newParams);
      this.user = newParams.name;
    })
  }

  ngOnInit(): void {
  }

}
