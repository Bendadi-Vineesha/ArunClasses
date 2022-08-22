import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './../../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router, private userService:UserService) { }

  ngOnInit(): void {
  }
  getLogin(){
    this.userService.name= "Harika";
    this.userService.valid = true;
    // send request to server, res

    // redirect to welcome page
    console.log("going to welcome component")
    this.router.navigate(["welcome", this.userService.name])
  }

}
