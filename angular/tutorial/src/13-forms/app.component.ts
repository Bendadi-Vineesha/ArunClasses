import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
    selector: "app-root",
    templateUrl: `app.component.html`,
    styleUrls: ['app.component.scss']
})
export class AppComponent { 

    myForm:FormGroup;

    constructor(){
        this.myForm = new FormGroup({
            username: new FormControl("", [
                Validators.required,
                Validators.pattern("[A-Za-z0-9._]+@[A-Za-z0-9.]+\\.[a-z]{2,3}")
            ]),
            password: new FormControl("")
        });
    }

    getLogin(){
        console.log("send req")
        console.log(this.myForm);
        console.log(this.myForm.value);
        // service.login(this.myForm.value).subscribe({})
    }
}